package com.quizApp.service;

import com.quizApp.dto.QuestionDTO;
import com.quizApp.dto.QuizResultDTO;
import com.quizApp.request.SubmitAnswerRequest;

public interface QuizService {

    // Method to get a random question
    QuestionDTO getRandomQuestion();

    // Method to submit an answer for a specific user
    void submitAnswer(Long userId, SubmitAnswerRequest request);

    // Method to get the quiz result for a user
    QuizResultDTO getQuizResult(Long userId);
}
