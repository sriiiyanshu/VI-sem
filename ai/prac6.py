#Write a program to remove punctuations from the given string.

def remove_punctuation(text):
    punctuations = '''!()-[]{};:'"\\,<>./?@#$%^&*_~'''

    for punc in text:
        if punc in punctuations:
            text=text.replace(punc,"")
    return text

text = input("Enter a string to remove punctuations: ")
print("String without punctuations: \n", remove_punctuation(text))
