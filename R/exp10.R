# Data
x <- c(10, 20, 30, 40, 50)
y <- c(15, 25, 35, 45, 60)

# Pearson correlation
correlation=cor(x, y, method = "pearson")
cat("Pearson correlation of x and y is: ",correlation)
