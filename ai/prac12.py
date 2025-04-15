import nltk
import random
from nltk import NaiveBayesClassifier
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize


# Sample training data: (sentence, category)
training_data = [
    ("The team played a fantastic match and won the trophy", "sports"),
    ("He scored a goal in the final minutes of the game", "sports"),
    ("She is a brilliant software developer at Google", "technology"),
    ("Python is a widely used programming language", "technology"),
    ("The player broke the world record in sprinting", "sports"),
    ("Artificial Intelligence is transforming the world", "technology"),
]

# Preprocessing: Remove stopwords and convert to features
stop_words = set(stopwords.words('english'))

def preprocess(sentence):
    words = word_tokenize(sentence.lower())
    return {word: True for word in words if word not in stop_words and word.isalpha()}

# Create feature sets
feature_sets = [(preprocess(sentence), category) for sentence, category in training_data]

# Shuffle and split data (not necessary here since data is small)
random.shuffle(feature_sets)

# Train the Naive Bayes Classifier
classifier = NaiveBayesClassifier.train(feature_sets)

# Input sentence to classify
test_sentence = "He developed a mobile app using Python."

# Preprocess and classify
features = preprocess(test_sentence)
predicted_category = classifier.classify(features)

print(f"\nInput Sentence: {test_sentence}")
print(f"Predicted Category: {predicted_category}")

# Show the most informative features
classifier.show_most_informative_features(5)
