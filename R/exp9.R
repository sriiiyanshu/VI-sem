# Simulated data with some outliers
x <- c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 25)
y <- c(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 50, 25, 30, 18, 22, 100, 200, 250, 10, 300, 50)

data <- data.frame(x, y)

# Scatter Plot
plot(data$x, data$y, main = "Scatter Plot", xlab = "x", ylab = "y", pch = 19, col = "blue")

# Fit Linear Model
model <- lm(y ~ x, data = data)
abline(model, col = "red")  # Add regression line to plot

# Residual Plot
plot(model$fitted.values, model$residuals,
     main = "Residual Plot", xlab = "Fitted Values", ylab = "Residuals",
     pch = 19, col = "darkgreen")
abline(h = 0, col = "red", lty = 2)

# Standardized Residuals (Detecting Outliers)
std_res <- rstandard(model)
outliers <- which(abs(std_res) > 2)  # Typically > 2 is a sign of an outlier

# Print Outliers
cat("\nOutliers based on Standardized Residuals:\n")
if (length(outliers) > 0) {
  print(data[outliers, ])
} else {
  cat("No significant outliers found.\n")
}

# Hat Values (Detecting High Leverage Points)
leverage <- hatvalues(model)
high_leverage <- which(leverage > (2 * mean(leverage)))

# Print High Leverage Points
cat("\nHigh Leverage Points:\n")
if (length(high_leverage) > 0) {
  print(data[high_leverage, ])
} else {
  cat("No high leverage points found.\n")
}

# Cook’s Distance (Detecting Influential Data Points)
cooks <- cooks.distance(model)

# Plot Cook's Distance
plot(cooks, type = "h", main = "Cook's Distance", ylab = "Cook's Distance")
abline(h = 4/(nrow(data)-2), col = "red", lty = 2)  # Rule of thumb threshold

# Identify Influential Points
influential <- which(cooks > 4/(nrow(data)-2))

# Print Influential Data Points
cat("\nInfluential Data Points based on Cook's Distance:\n")
if (length(influential) > 0) {
  print(data[influential, ])
} else {
  cat("No influential points found.\n")
}
