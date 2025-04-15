##Data visualization: Create a program that reads data from a file and then creates a visualization of that data using a data visualization library.
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# Load first 1000 rows from the CSV file
data = pd.read_csv('healthcare_dataset.csv', nrows=1000)

# Convert 'Date of Admission' to datetime
data['Date of Admission'] = pd.to_datetime(data['Date of Admission'], errors='coerce')

# Set seaborn style
sns.set(style="whitegrid")

# 1. Histogram of Age
plt.figure(figsize=(8, 5))
sns.histplot(data['Age'], bins=20, kde=True, color='skyblue')
plt.title('Distribution of Patient Ages')
plt.xlabel('Age')
plt.ylabel('Frequency')
plt.tight_layout()
plt.show()

# 2. Box Plot of Billing Amount by Gender
plt.figure(figsize=(8, 5))
sns.boxplot(x='Gender', y='Billing Amount', data=data, palette='Set2')
plt.title('Billing Amount by Gender')
plt.tight_layout()
plt.show()

# 3. Bar Chart of Medical Condition Counts
plt.figure(figsize=(10, 6))
data['Medical Condition'].value_counts().plot(kind='bar', color='coral')
plt.title('Frequency of Medical Conditions')
plt.xlabel('Medical Condition')
plt.ylabel('Count')
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

# 4. Pie Chart of Blood Type Distribution
plt.figure(figsize=(7, 7))
blood_counts = data['Blood Type'].value_counts()
plt.pie(blood_counts, labels=blood_counts.index, autopct='%1.1f%%', startangle=140,
        colors=sns.color_palette('pastel'))
plt.title('Blood Type Distribution')
plt.tight_layout()
plt.show()

# 5. Count Plot of Admission Type
plt.figure(figsize=(8, 5))
sns.countplot(x='Admission Type', data=data, palette='muted')
plt.title('Admission Type Count')
plt.xlabel('Admission Type')
plt.ylabel('Count')
plt.tight_layout()
plt.show()

# 6. Line Plot of Average Billing Over Time (Monthly)
monthly_billing = data.groupby(data['Date of Admission'].dt.to_period('M'))['Billing Amount'].mean()
monthly_billing.index = monthly_billing.index.to_timestamp()

plt.figure(figsize=(12, 6))
monthly_billing.plot(marker='o', color='teal')
plt.title('Average Billing Amount Over Time')
plt.xlabel('Date of Admission (Month)')
plt.ylabel('Average Billing Amount')
plt.grid(True)
plt.tight_layout()
plt.show()
