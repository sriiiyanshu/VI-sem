# Cash flows for two projects over 5 years
projectA <- c(100, 120, 130, 110, 115)
projectB <- c(100, 150, 90, 160, 80)

# Calculate standard deviation
sd_A <- sd(projectA)
sd_B <- sd(projectB)

cat("Standard Deviation - Project A:", sd_A, "\n")
cat("Standard Deviation - Project B:", sd_B, "\n")

if (sd_A > sd_B) {
  cat("Project A is riskier based on standard deviation.\n")
} else {
  cat("Project B is riskier based on standard deviation.\n")
}

cat("\n")

mean_A <- mean(projectA)
mean_B <- mean(projectB)

cv_A <- sd_A / mean_A
cv_B <- sd_B / mean_B

cat("Coefficient of Variation - Project A:", cv_A, "\n")
cat("Coefficient of Variation - Project B:", cv_B, "\n")

if (cv_A > cv_B) {
  cat("Project A is riskier based on CV.\n")
} else {
  cat("Project B is riskier based on CV.\n")
}
