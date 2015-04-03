
import rewinder
import os
import json
import git
import util
import re
import sh
import calendar
import dateutil
import random
# a factory for making different kinds of rewinders
# this used to be in sourcer, but sourcer became hard to scroll through
# ############################ NCommits ###############################


# Rewinder ready to rewind.
# This rewinder will bookmark up to `n' commits on the master branch, about evenly spaced and in the same descending order as returned by git log.  The list should include the most recent commit first.
def nCommitsGithubRewinder(logger, repoID, repo_path, report_path, uniqueSourceID, n, rewinder_type, credentials):
    # this is the path of the new directory to clone the project into
    repoIDPath = repo_path + str(repoID) + "/"
    logger.debug("Factory, repoIDPath: " + repoIDPath)

    # get metadata for sourceJSON
    repoJSON = util.get_json(logger, "https://api.github.com/repositories/" + str(repoID), credentials, True)
    repo_name = repoJSON['name']
    default_branch = repoJSON['default_branch']
    logger.debug("nCoGiRe - default branch name: " + default_branch)
    clone_url = repoJSON['clone_url']

    # make sure that repo_path exists, or create it.
    if not os.path.exists(repo_path):
        logger.critical("Factory - nCoGiRe, this path does not exist!! repo_path: " + repo_path)
        os.mkdir(repo_path)

    # try to empty this folder and clone into a new folder in repo_path
    for try_i in range(1, 4):
        if(try_i > 1):
            logger.info("nCoGiRe, attempt " + str(try_i) + " to remove contents of repo_path: " + str(repo_path) + " and then clone using clone_url: " + clone_url)
        try:
            # try to erase everything in repo_path
            repoPathContents = [os.path.join(repo_path, f) for f in os.listdir(repo_path)]
            logger.info("nCoGiRe, repoPathContents: " + str(repoPathContents))
            if repoPathContents:
                # shuffle: don't always get stuck behind a problem directory
                random.shuffle(repoPathContents)
                for x in repoPathContents:
                    try:
                        util.erasePath(x, logger)
                    except Exception as ex:
                        logger.warning("exception when trying to erasePath on: " + x + " ex: " + str(ex))
                # I've had enough problems erasing the repo_path.  forget it.
                # all that matters is that we can clone into an empty directory,
                # and in the long run of course we want to avoid running out of
                # disk space, so trying to erase all these directories is good

            # make a new directory just for this new project - this should always succeed and allow git to clone, since all repoIDs are unique
            os.mkdir(repoIDPath)
            git.repo.base.Repo.clone_from(clone_url, repoIDPath, None, branch=default_branch)
            break
        except Exception as e:
            logger.info("Factory - nCoGiRe, unexpected error: " + str(e))

    # just to be safe, always do these sanity checks.
    # the repoIDPath should exist and contain the new ".git" every time.
    if not os.path.exists(repoIDPath):
        logger.info("Factory - nCoGiRe, path missing!")
        raise RuntimeWarning("do not proceed with repoIDPath directory missing - you will rewind the tour_de_source project!")
    repoIDPathContents = [os.path.join(repoIDPath, f) for f in os.listdir(repoIDPath)]
    logger.info("contents of repoIDPath: " + str(repoIDPathContents))
    if not repoIDPathContents:
        logger.info("Factory - nCoGiRe, repoIDPathContents is empty!")
        raise RuntimeWarning("do not proceed with repoIDPath directory empty - you will rewind the tour_de_source project!")
    if repoIDPath + ".git" not in repoIDPathContents:
        logger.info("Factory - nCoGiRe, repoIDPathContents has no git!  cloning did not succeed.")
        raise RuntimeWarning("do not proceed with repoIDPath directory having no .git folder - you will rewind the tour_de_source project!")

    # now get the time and sha for commits
    commitList = []
    repoGit = git.Git(repoIDPath)
    hexshas = repoGit.log("--format=format:\"%ct %H\"").split('\n')
    for line in hexshas:
        cleanedLine = line[line.find('"') + 1:line.rfind('"')]
        pair = cleanedLine.split(' ')

        # this json is what couples each rewinded data source to a particular github project version.  For bitbucket or another source, many of the inner fields should be different, but the three root fields: type, meta and data should be the same for all future sourceJson objects like this.
        sourceJson = json.dumps({"type": "Github", "meta": {"repoID": str(repoID), "default_branch": str(default_branch), "clone_url": clone_url, "name": repo_name}, "data": {"sha": str(pair[1]), "commitS": str(pair[0])}})
        # logger.info("sourceJSON created: " + sourceJson)
        if len(pair) == 2:
            commitList.append((pair[0], pair[1], sourceJson))

    # here we are sorting by the first field of the tuple: the commit time
    commitList.sort(reverse=True)
    nCommits = len(commitList)
    if nCommits <= n:
        # return a rewinder with all commits
        stack = commitList
    else:
        # return a rewinder with n commits, spaced out about evenly
        unitFloat = nCommits / float(n - 1)
        stack = []

        # always put the most recent first
        stack.append(commitList[0])

        # put the rest
        for multiplier in range(1, n):
            commitIndex = int(multiplier * unitFloat) - 1
            stack.append(commitList[commitIndex])

    # remember python lists pop at the tail...
    stack.reverse()
    return rewinder.GitRewinder(repoIDPath, rewinder_type, uniqueSourceID, stack)

# ############################ fakeNCommits ###############################


# For testing
def fakeNCommitsGithubRewinder(logger, repoID, repo_path, report_path, uniqueSourceID, n, rewinder_type, BASE_PATH):
    default_branch = "master"
    clone_url = "fake_clone_url"
    repo_name = "copycat"

    logger.debug("nCoGiRe, rsync-ing test_repo folder to repo folder")
    sh.rsync("-r", BASE_PATH + 'tools/test_repo/', repo_path,)
    sh.cd(repo_path)

    # hopefully the correct directory has the same name as the project, or is the last directory of all cloned directories.  This can vary - with git you could potentially have all your files in the root cloned directory, but in practice, almost noone does that.  I have seen several projects with multiple folders in this root cloned directory.  I think this is a case where it is best to just ignore the unusual ones.
    directoriesInPath = os.listdir(repo_path)
    directoriesInPath.sort()
    for directory in directoriesInPath:
        if not directory[0] == ".":
            if directory.lower() == repo_name.lower():
                repoDirName = directory
                break
            repoDirName = directory

    if repoDirName != repo_name:
        logger.critical("nCoGiRe, did not find folder with same name as project(" + repo_name + ").  Using the last directory found: " + repoDirName)

    # now get the time and sha for commits
    sh.cd(repoDirName)
    commitList = []
    for line in sh.git.log("--format=format:\"%ct %H\"", _iter=True, _tty_out=False):
        cleanedLine = line[line.find('"') + 1:line.rfind('"')]
        pair = cleanedLine.split(' ')

        # this json is what couples each rewinded data source to a particular github project version.  For bitbucket or another source, many of the inner fields should be different, but the three root fields: type, meta and data should be the same for all future sourceJson objects like this.
        sourceJson = json.dumps({"type": "Github", "meta": {"repoID": str(repoID), "default_branch": str(default_branch), "clone_url": clone_url, "name": repoDirName}, "data": {"sha": str(pair[1]), "commitS": str(pair[0])}})
        if len(pair) == 2:
            commitList.append((pair[0], pair[1], sourceJson))

    # here we are sorting by the first field of the tuple: the commit time
    commitList.sort(reverse=True)
    nCommits = len(commitList)
    rewindablePath = repo_path + repoDirName

    if nCommits <= n:
        # return a rewinder with all commits
        stack = commitList
    else:
        # return a rewinder with n commits, spaced out about evenly
        unitFloat = nCommits / float(n - 1)
        stack = []

        # always put the most recent first
        stack.append(commitList[0])

        # put the rest
        for multiplier in range(1, n):
            commitIndex = int(multiplier * unitFloat) - 1
            stack.append(commitList[commitIndex])

    # remember python lists pop at the tail...
    stack.reverse()
    return rewinder.GitRewinder(rewindablePath, rewinder_type, uniqueSourceID, stack)


# this is for testing the github api, so we want many calls to get_json
# ############################# OnlyJSON ############################
def getMockRewinder(logger, repoID, credentials):
    logger.debug("getMock, repoID: " + str(repoID) + " maxing out calls to github.")
    for i in range(0, 1000):
        repoJSON = util.get_json(logger, "https://api.github.com/repositories/" + str(repoID), credentials)
        repo_name = repoJSON['name']
    default_branch = repoJSON['default_branch']
    logger.debug("getMock - default branch name: " + default_branch)
    clone_url = repoJSON['clone_url']
    masterURL = re.sub(r'({.*)$', '/' + default_branch, repoJSON['branches_url'])
    masterJSON = util.get_json(logger, masterURL, credentials)
    masterSHA = masterJSON['commit']['sha']
    masterDate = masterJSON['commit']['commit']['committer']['date']
    masterDateS = calendar.timegm(dateutil.parser.parse(masterDate).utctimetuple())
    sourceJSON = json.dumps({"type": "Mock_Github", "meta": {"repoID": str(repoID), "default_branch": str(default_branch), "clone_url": clone_url, "name": repo_name}, "data": {"sha": masterSHA, "commitS": masterDateS}})
    return rewinder.MockRewinder(repoID, sourceJSON)
