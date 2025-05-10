# Set seed for reproducibility
set.seed(42)

# Parameters
n <- 10000
mu <- 1000
sigma <- 200

# 1. Simulate bulb lifespans (Normal Distribution)
lifespans <- rnorm(n, mean = mu, sd = sigma)

# Visual Analysis
hist(lifespans, breaks = 50, col = "lightblue",
     main = "Histogram of Simulated Bulb Lifespans",
     xlab = "Lifespan (hours)")
abline(v = mu, col = "red", lwd = 2, lty = 2)

# 2. Probability Calculations
# P(X < 800)
p_less_800 <- pnorm(800, mean = mu, sd = sigma)
cat("Probability that bulb lasts < 800 hours:", round(p_less_800, 4), "\n")

# P(X > 1200)
p_more_1200 <- 1 - pnorm(1200, mean = mu, sd = sigma)
cat("Percentage of bulbs > 1200 hours:", round(p_more_1200 * 100, 2), "%\n")

# 3. Defective Rates
defective_count <- sum(lifespans < 800)
expected_defective <- p_less_800 * n
cat("Simulated defective bulbs:", defective_count, "\n")
cat("Expected defective bulbs:", round(expected_defective), "\n")

# 4. Comparison with Uniform and Exponential distributions
uniform_lifespans <- runif(n, min = 600, max = 1400)
exp_lifespans <- rexp(n, rate = 1/1000)

comparison <- data.frame(
  Distribution = c("Normal", "Uniform", "Exponential"),
  Mean = c(mean(lifespans), mean(uniform_lifespans), mean(exp_lifespans)),
  Variance = c(var(lifespans), var(uniform_lifespans), var(exp_lifespans))
)
print(comparison)

# Optional: Visualize other distributions
hist(uniform_lifespans, col = "lightgreen", breaks = 50,
     main = "Uniform Distribution", xlab = "Lifespan (hours)")
hist(exp_lifespans, col = "lightcoral", breaks = 50,
     main = "Exponential Distribution", xlab = "Lifespan (hours)")

# 5. Hypothesis Test (t-test)
t_result <- t.test(lifespans, mu = 1000)
print(t_result)

if (t_result$p.value < 0.05) {
  cat("Reject H0: Mean is significantly different from 1000 hours.\n")
} else {
  cat("Fail to reject H0: No significant difference from 1000 hours.\n")
}
