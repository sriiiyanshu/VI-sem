#Exception handling: Create a program that prompts the user for two numbers and then divides them, handling any exceptions that may arise.
a=int(input("Enter first number "))
b=int(input("Enter second number "))

try:
    result=a/b
    print(f"Divison of {a} by {b} is: {result}") 
except:
    print("Divison by zero not possible")  
finally:
    print("Program executed")
    
    