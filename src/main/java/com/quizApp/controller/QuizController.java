package com.quizApp.controller;

import com.quizApp.dto.QuestionDTO;
import com.quizApp.dto.QuizResultDTO;
import com.quizApp.request.SubmitAnswerRequest;
import com.quizApp.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizServiceImpl quizService;

    @GetMapping("/start")
    public ResponseEntity<QuestionDTO> startQuiz() {
        return ResponseEntity.ok(quizService.getRandomQuestion());
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitAnswer(@RequestParam Long userId, @RequestBody SubmitAnswerRequest request) {
        quizService.submitAnswer(userId, request);
        return ResponseEntity.ok("Answer submitted successfully");
    }

    @GetMapping("/result")
    public ResponseEntity<QuizResultDTO> getResult(@RequestParam Long userId) {
        return ResponseEntity.ok(quizService.getQuizResult(userId));
    }
}

