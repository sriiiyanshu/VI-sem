import nltk

# Input sentence
sentence = "The quick brown fox jumps over the lazy dog."

# Tokenize the sentence
tokens = nltk.word_tokenize(sentence)

# POS tagging
pos_tags = nltk.pos_tag(tokens)

# Display the POS tags
print("Part-of-Speech Tags:")
for word, tag in pos_tags:
    print(f"{word} --> {tag}")
