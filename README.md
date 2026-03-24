# Incident Classification System

## Overview

This project is a backend system built using Spring Boot that processes documents and classifies text into predefined incident topics using keyword-based logic.

## Features

* Add incident topics with keywords
* Upload document (text input)
* Split document into sentences
* Classify each sentence into relevant topic
* Store results in PostgreSQL
* Fetch classification results via APIs
* Dashboard showing topic distribution
## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* REST APIs

## API Endpoints

### 1. Add Topics

POST /api/topics

Sample Request:
{
"title": "Delhi Bomb Blast",
"keywords": ["Delhi", "blast", "explosion"]
}

### 2. Upload Document

POST /api/documents

Sample Request:
{
"text": "Explosion occurred in Delhi. Blast reported in Kanpur."
}

### 3. Get Results

GET /api/documents/{id}/results

### 4. Dashboard

GET /api/dashboard
## How It Works

* The document is split into sentences
* Each sentence is matched against topic keywords
* The topic with highest keyword match is assigned
* If no match → marked as UNCLASSIFIED

## Setup Instructions

1. Clone repository
   git clone https://github.com/your-username/incident-classification-system.git

2. Configure PostgreSQL in application.properties

3. Run Spring Boot application

## Sample Output

{
"documentId": 1,
"results": [
{
"text": "Explosion occurred in Delhi",
"assignedTopic": "Delhi Bomb Blast",
"confidence": 0.75
}
]
}

## Future Improvements

* PDF support
* NLP-based classification
* Fuzzy keyword matching
* Multi-language support

## Author
Tapas Kumar Nayak
