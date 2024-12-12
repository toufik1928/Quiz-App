package com.quizApp;

//import com.quizApp.model.Question;
//import com.quizApp.repository.QuestionRepository;
//import com.quizApp.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
import com.quizApp.model.Question;
import com.quizApp.model.User;
import com.quizApp.repository.QuestionRepository;
import com.quizApp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuizAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedDatabase(QuestionRepository questionRepository, UserRepository userRepository) {
		return args -> {
			// Seed user
			User user = new User();
			user.setId(1L);
			user.setName("Test User");
			userRepository.save(user);

			// Seed questions
			Question q1 = new Question(1L, "What is the capital of France?", "Paris", "Berlin", "Madrid", "Rome", "A");
			Question q2 = new Question(2L, "What is 2 + 2?", "3", "4", "5", "6", "B");
			Question q3 = new Question(3L, "Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Venus", "B");

			questionRepository.save(q1);
			questionRepository.save(q2);
			questionRepository.save(q3);
		};
	}
}
