#R CMD BATCH <filename>

# simulating a horizontal bar chart for flag usage: ["IGNORECASE","DEBUG","LOCALE","MULTILINE","DOTALL","UNICODE","VERBOSE"]
setEPS()
options(scipen=10)
postscript("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/analysis/analysis_output/test.eps")
data = matrix(c(500000000,300000000,900000000,200000000,400000000,100000000,600000000), ncol=1, byrow=T)
rownames(data) = c("DEBUG","IGNORECASE","LOCALE", "MULTILINE", "DOTALL", "UNICODE", "VERBOSE")
par(pin=c(2.2,2))
barplot(data,
  main="Regex Flag Usage",
  legend=rownames(data),
  col=c("green","grey","red", "skyblue", "violet", "orange4", "lightyellow2"),
  xlim=c(0,9), width=0.6, las=1
)
dev.off()
