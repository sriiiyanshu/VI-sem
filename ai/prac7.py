#Write a program to sort the sentence in alphabetical order.

def sorted_str(text):
    text=' '.join(sorted(text.split()))
    return text
    
text=input("Enter a string: ").strip()
print("Sorted String is:", sorted_str(text))

