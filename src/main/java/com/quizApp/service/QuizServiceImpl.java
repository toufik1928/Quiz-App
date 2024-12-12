package com.quizApp.service;

import com.quizApp.dto.QuestionDTO;
import com.quizApp.dto.QuizResultDTO;
import com.quizApp.exception.ResourceNotFoundException;
import com.quizApp.model.Question;
import com.quizApp.model.UserAnswer;
import com.quizApp.repository.QuestionRepository;
import com.quizApp.repository.UserAnswerRepository;
import com.quizApp.request.SubmitAnswerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    public QuestionDTO getRandomQuestion() {
        Question question = questionRepository.findRandomQuestion();
        return mapToDTO(question);
    }

    public void submitAnswer(Long userId, SubmitAnswerRequest request) {
        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

        boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(request.getUserAnswer());
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUserId(userId);
        userAnswer.setQuestionId(request.getQuestionId());
        userAnswer.setUserAnswer(request.getUserAnswer());
        userAnswer.setIsCorrect(isCorrect);

        userAnswerRepository.save(userAnswer);
    }

    public QuizResultDTO getQuizResult(Long userId) {
        List<UserAnswer> userAnswers = userAnswerRepository.findByUserId(userId);

        int correctAnswers = (int) userAnswers.stream().filter(UserAnswer::isCorrect).count();
        int totalQuestions = userAnswers.size();

        List<QuizResultDTO.AnswerDetail> details = userAnswers.stream().map(answer -> {
            Question question = questionRepository.findById(answer.getQuestionId())
                    .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

            QuizResultDTO.AnswerDetail detail = new QuizResultDTO.AnswerDetail();
            detail.setQuestion(question.getQuestionText());
            detail.setUserAnswer(answer.getUserAnswer());
            detail.setCorrectAnswer(question.getCorrectAnswer());
            detail.setIsCorrect(answer.isCorrect());
            return detail;
        }).collect(Collectors.toList());

        QuizResultDTO result = new QuizResultDTO();
        result.setTotalQuestions(totalQuestions);
        result.setCorrectAnswers(correctAnswers);
        result.setIncorrectAnswers(totalQuestions - correctAnswers);
        result.setAnswerDetails(details);

        return result;
    }

    private QuestionDTO mapToDTO(Question question) {

        QuestionDTO dto = new QuestionDTO();
        dto.setId(question.getId());
        dto.setQuestionText(question.getQuestionText());
        dto.setOptionA(question.getOptionA());
        dto.setOptionB(question.getOptionB());
        dto.setOptionC(question.getOptionC());
        dto.setOptionD(question.getOptionD());
        return dto;
    }
}

