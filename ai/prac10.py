#Stop words
import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
import string

# Read the text file
with open('prac10Text.txt', 'r') as file:
    text = file.read()

# Tokenize using NLTK's word_tokenize
words = word_tokenize(text)

# Load English stop words
stop_words = set(stopwords.words('english'))

# Filter out stop words and punctuation
filtered_words = [word for word in words if word.lower() not in stop_words and word not in string.punctuation]

# Join the filtered words into a single string
filtered_text = ' '.join(filtered_words)

# Output
print("Original Text:\n", text)
print("\nText after removing Stop Words:\n", filtered_text)
