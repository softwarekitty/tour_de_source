
setEPS()
postscript("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/analysis/analysis_output/partFunctions.eps",width=5,height=2.1)
par(mar=c(1,4,1,1), cex=.97)
M_partFunctions = matrix(c(31054,7116,5788,1084,1825,124,6826,77),ncol=1,byrow=T)
rownames(M_partFunctions)=c("re.compile 31,054 (57.6%)","re.search 7,116 (13.2%)","re.match 5,788 (10.7%)","re.split 1,084 (2%)","re.findall 1,825 (3.4%)","re.finditer 124 (0.2%)","re.sub 6,826 (12.7%)","re.subn 77 (0.1%)")
barplot(M_partFunctions, legend=rownames(M_partFunctions),col=c("gray50","gray30","gray75","gray12","gray87","gray20","gray67","gray8"),xlim=c(0,9),width=0.6,ylim = range(pretty(c(0, 53894))),las=1)
dev.off()

setEPS()
postscript("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/analysis/analysis_output/partFlags.eps",width=5,height=2.1)
par(mar=c(1,4,1,1), cex=.97)
M_partFlags = matrix(c(2996,24,1764,711,397,943,0),ncol=1,byrow=T)
rownames(M_partFlags)=c("IGNORECASE 2,996 (43.8%)","LOCALE 24 (0.4%)","MULTILINE 1,764 (25.8%)","DOTALL 711 (10.4%)","UNICODE 397 (5.8%)","VERBOSE 943 (13.8%)","multiple flags 0 (0%)")
barplot(M_partFlags,legend=rownames(M_partFlags),col=c("gray80","gray32","gray67","gray8","gray50","gray92","grey20"),xlim=c(0,9),width=0.6,ylim = range(pretty(c(0, 6835))),las=1)
dev.off()

............