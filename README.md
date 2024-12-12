# Quiz Application

This is a simple quiz application built using Spring Boot. It allows users to take quizzes, submit answers, and view results. 

# Features
- **Random Question Retrieval**: The user can get random questions from the predefined database.
- **Answer Submission**: Users can submit answers for each question.
- **Quiz Result Calculation**: Once the user has answered all questions, they can get their quiz results showing how many questions were answered correctly and incorrectly.
- **Simple User Management**: One test user is preconfigured with ID `1` and name `Test User`.

---

## Tech Stack
- **Backend**: Spring Boot (Java)
- **Database**: H2 (or any other relational database of your choice)
- **Libraries/Frameworks**:
  - Spring Data JPA
  - Spring Web
  - Jakarta Persistence (JPA)
  - Spring Boot DevTools
  - Lombok (for reducing boilerplate code)

---

## Assumptions
- The application is seeded with one test user with ID `1` and name `Test User`.
- The application also has a predefined set of questions seeded in the database.
- All questions have a correct answer stored as a letter (A, B, C, D).
- The database will be populated with dummy data when the application starts.

---

## Setup and Installation

### Prerequisites
- **JDK 11 or higher**
- **Maven** for building the project
- **IDE** (IntelliJ IDEA, Eclipse, etc.) or a simple text editor

### Steps to Run Locally

1. **Clone the repository**:
   ```bash
   git clone https://github.com/toufik1928/Quiz-App/quiz-app.git
   cd quiz-app

**How to Run**
1)Run Application: After building the application, run it locally or deploy it on your server.
2)Accessing the API: The application will be available at http://localhost:8080. You can use tools like Postman or Curl to interact with the API.


**API Endpoints**

1. Get Random Question
Endpoint: GET /api/quiz/random
Description: Fetches a random question from the database.
Response:-
        {
          "id": 1,
          "questionText": "What is the capital of France?",
          "optionA": "Paris",
          "optionB": "Berlin",
          "optionC": "Madrid",
          "optionD": "Rome"
        }

2. Submit Answer
Endpoint: POST /api/quiz/submit
Description: Submits an answer for a question.
Request Body:
        json
        {
          "questionId": 1,
          "userAnswer": "A"
        }

Response:
        json
        {
          "message": "Answer submitted successfully"
        }


3. Get Quiz Result
Endpoint: GET /api/quiz/result/{userId}
Description: Fetches the quiz result for a user (shows correct and incorrect answers).
Response:
        json
        {
          "totalQuestions": 3,
          "correctAnswers": 2,
          "incorrectAnswers": 1,
          "answerDetails": [
            {
              "question": "What is the capital of France?",
              "userAnswer": "A",
              "correctAnswer": "A",
              "isCorrect": true
            },
            {
              "question": "What is 2 + 2?",
              "userAnswer": "B",
              "correctAnswer": "B",
              "isCorrect": true
            },
            {
              "question": "Which planet is known as the Red Planet?",
              "userAnswer": "A",
              "correctAnswer": "B",
              "isCorrect": false
            }
          ]
        }

