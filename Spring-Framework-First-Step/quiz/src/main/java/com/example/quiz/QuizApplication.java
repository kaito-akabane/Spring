package com.example.quiz;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args)
				.getBean(QuizApplication.class).execute();
	}
	
	@Autowired
	QuizRepository repository;
	
	private void execute() {
		setup();
		showList();
	}
	
	private void setup() {
		Quiz quiz1 = new Quiz(null, "Spring은 Java 프레임워크이다.", true, "Kang");
		quiz1 = repository.save(quiz1);
		System.out.println(quiz1+" 등록 완료");
	}
	
	private void showList() {
		System.out.println("데이터 취득");
		Iterable<Quiz> quizzes = repository.findAll();
		for(Quiz q : quizzes) System.out.println(q);
	}
}
