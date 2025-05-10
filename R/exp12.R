# Load required libraries
library(forecast)
library(tseries)

# Load and inspect the AirPassengers dataset
data("AirPassengers")
ap <- AirPassengers

# Print basic information
print(ap)
cat("Start:", start(ap), "\n")
cat("End:", end(ap), "\n")
cat("Frequency:", frequency(ap), "\n")

# Plot the original time series
plot(ap, main="Monthly Airline Passengers (1949-1960)", ylab="Passengers", xlab="Year")

# Decompose the time series
decomposed <- decompose(ap)
plot(decomposed)

# Check stationarity using Augmented Dickey-Fuller test
adf_result <- adf.test(ap)
print(adf_result)

# Apply log transformation and differencing to stabilize variance and achieve stationarity
log_ap <- log(ap)
diff_log_ap <- diff(log_ap)
plot(diff_log_ap, main="Log-transformed and Differenced Series")

# ADF test on transformed data
adf_result_diff <- adf.test(diff_log_ap)
print(adf_result_diff)

# Plot ACF and PACF to check autocorrelations
acf(diff_log_ap, main="ACF of Differenced Series")
pacf(diff_log_ap, main="PACF of Differenced Series")

# Fit an ARIMA model automatically
fit <- auto.arima(ap)
summary(fit)

# Forecast the next 24 months (2 years)
forecast_ap <- forecast(fit, h=24)
plot(forecast_ap, main="Forecast of AirPassengers")

# Evaluate model performance
accuracy(forecast_ap)
