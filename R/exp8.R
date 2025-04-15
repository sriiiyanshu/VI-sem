# Sample data
data <- c(100, 120, 140, 150, 100, 1000, 200, 220, 240, 800)

boxplot(data, main = "Boxplot of Sample Data", col = "lightblue")

boxplot_stats <- boxplot.stats(data)
outliers <- boxplot_stats$out  # outlier values

# Display the outliers
cat("\nOutliers:\n")
print(outliers)

cat("\nBoxplot Summary Statistics:\n")
print(boxplot_stats)
