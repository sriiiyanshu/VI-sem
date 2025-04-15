# Load dataset
data(mtcars)

# Create a new data frame with car name, mpg, and weight
selected_data <- data.frame(Car = rownames(mtcars),
                            mpg = mtcars$mpg,
                            wt = mtcars$wt)

# Display selected data in console
print(selected_data)


# Scatter plot of weight vs mpg
plot(mtcars$wt, mtcars$mpg,
     main = "Scatter Plot of Car Weight vs MPG",
     xlab = "Weight (1000 lbs)",
     ylab = "Miles Per Gallon (mpg)",
     pch = 19, col = "blue")


# Fit linear regression model
model <- lm(mpg ~ wt, data = mtcars)

# Display model summary
print(summary(model))

# Add regression line to the scatter plot
abline(model, col = "red", lwd = 2)
