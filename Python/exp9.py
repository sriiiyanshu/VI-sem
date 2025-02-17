#Regular expressions: Create a program that uses regular expressions to find all instances of a specific pattern in a text file.
import re

file = open("exp9file.txt",'r')
txt=file.read()

regex=r'\b\w{4}\b'

match = re.findall(regex,txt)
print(match)
