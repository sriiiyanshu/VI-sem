a=int(input("Enter first number "))
b=int(input("Enter second number "))

try:
    result=a/b
    print(f"Divison of {a} by {b} is: {result}") 
except:
    print("Divison by zero not possible")  
finally:
    print("Program executed")