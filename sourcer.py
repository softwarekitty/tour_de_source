import sqlite3
import rewinder
import util
import urllib2
import json

'''*Sourcer interface:
        *Sourcer(rewinder_type) rewinder_type could be Version, Weekly, 1%, first, last, etc.  some way to choose what commits to choose from all possible commits.  For now we don't do anything with this value - placeholder.  Also, we don't want to do any long running online processes in the initialization - just get ready

        initialize_report(report_db)
            it should give the scanner some way to reference
            what the scanner has scanned - ideally enough to go back
            there if needed

        hasNext()
            prepares for an advance to the next project, if needed
            returns true if there is a next project from this source


        next()
            provides a rewinder for the next project
            records that the advance has been used
'''


class GithubPythonSourcer:

    def __init__(self, rewinder_type):
        self.rewinder_type = rewinder_type
        self.exhausted = False
        self.last = 0
        self.queue= []

    def initialize_report(self, report_db):

        # this report_db should already exist, created in Tourist
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute('''CREATE TABLE name (GithubMeta) (id int, repoID text, lastSHA text, lastRepoJSON text, lastTagJSON text)''')
        c.execute('''CREATE TABLE name (GithubData) (id int, commitDateTimeMS int, SHA text, metaID int)''')
        conn.commit()
        conn.close()

    def isExhausted(self):
        return bool(self.exhausted)

    # returns a rewinder for the next repo
    def next(self):
        if len(self.queue) == 0:
            self.refreshQueue(last)
        if self.exhausted is True:
            return None
        last = queue.pop(0)
        return self.getRewinder(last)

    # refresh the queue of projects, using the first page found
    # that has a python project on it
    # set exhausted to true if the source is exhausted
    # rationalle here is that getting a few pages and then
    # processing them spreads out api access so the limit
    # is likely to refresh before we run out
    def refreshQueue(self, lastRepo):
        sinceLastJSON = json.load(urllib2.urlopen('https://api.github.com/repositories?since=' + lastRepo))
        for projectJSON in sinceLastJSON:
            languagesJSON = json.load(urllib2.urlopen(projectJSON['languages_url']))
            if "Python" in languagesJSON:
                # do stuff


        githubJSON = util.getURLContent("https://api.github.com/repositories?since=" + lastRepo)
        if githubJSON is None or githubJSON == "":
            self.exhausted = True
            return
        # TODO - make JSONArray(x) work
        arr = JSONArray(githubJSON)
        for repoJSON in arr:
            if

















    def getRewinder(self):
        if self.rewinder_type == "Version":
            return getGithubVersionRewinder()
        else:
            return None

    def getGithubVersionRewinder(self):
        # create a stack of not-yet-scraped versions, most recent on top


        # TODO - populate data in meta, data github tables for each rewinder
        # later, make this return the right type of rewinder depending
'''get()
//
        Stack<String> commits = new Stack<String>();

        // meanwhile, also be adding or updating the Github oriented tables'
        // data
        boolean firstScrape = !DatabaseAdapter
                .hasScrapedGithub(github2, string);
        String repoJSON = getURLContent("https://api.github.com/repositories/"
                + projectID);
        JSONObject repositoriesObject = new JSONObject(repoJSON);
        String tagJSON = getURLContent(repositoriesObject.getString("tags_url"));
        JSONArray tags = new JSONArray(tagJSON);
        String currentSha = getSha1(repositoriesObject);
        if (firstScrape) {
            DatabaseAdapter.addGithubProject(projectID, repoJSON, tagJSON,
                    currentSha);
        } else {
            DatabaseAdapter.updateGithubProject(projectID, repoJSON, tagJSON,
                    currentSha);
        }

        if (tags != null && tags.length() != 0) {
            for (int i = tags.length() - 1; i >= 0; i++) {
                JSONObject tagged_commit = new JSONObject(getURLContent(tags
                        .getJSONObject(i).getJSONObject("commit")
                        .getString("url")));
                String sha = tagged_commit.getString("sha");
                String date = tagged_commit.getJSONObject("commit")
                        .getJSONObject("committer").getString("date");
                if (firstScrape
                        && DatabaseAdapter.alreadyScrapedGithub(projectID, sha)) {
                    commits.push(sha);
                }
            }
        } else {
            // we can only get here if this is the firstScrape of a project with
            // no tags.  Let's inspect the current state of the project as if it
            // were a tag
            commits.push(currentSha);
        }

        // empty the base folder
        emptyBaseFolder(new File(baseFolder));

        // create a directory for the repo
        File f = new File(baseFolder + "/" + projectID);
        if (f.exists()) {

            //really shouldn't ever get here if we just emptied the directory
            System.out.println("Repository exists.\nDeleting repository and cloning a new copy....");
            try {
                FileUtils.deleteDirectory(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // use jgit to clone this repo to folder at current head, not rewound
        String remotePath = repositoriesObject.getString("clone_url");
        try {
            Git.cloneRepository().setURI(remotePath).setDirectory(f).call();
            System.out.println("Cloned project " + projectID);
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
        return new GitVersionRewinder(commits,f);'''
