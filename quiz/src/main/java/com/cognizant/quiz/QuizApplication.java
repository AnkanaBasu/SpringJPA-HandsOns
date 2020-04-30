package com.cognizant.quiz;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.quiz.model.Attempt;
import com.cognizant.quiz.service.AttemptService;

@SpringBootApplication
public class QuizApplication {

	private static AttemptService attemptService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QuizApplication.class, args);

		attemptService = context.getBean(AttemptService.class);
		getAttemptDetail();
	}

	private static void getAttemptDetail() {
		// TODO Auto-generated method stub
		Attempt at = attemptService.getAttempt(1, 1);
		System.out.println(at.getId());
		System.out.println(at.getDate());
		System.out.println(at.getUser_id().getName());
		System.out.println(at.getScore());

		System.out.println("Score" + attemptService.getScore());
		List<Object[]> list = attemptService.getDetails();

		Integer prev = 0;
		int i = 0;

		for (Object o[] : list) {
			Integer qid = (Integer) o[0];
			if (prev != qid) {
				i = 0;
				prev = qid;
				String ques = (String) o[1];

				System.out.println(ques);
			}

			String op_name = (String) o[2];
			Double op_score = (Double) o[3];
			Boolean op_bool = (Boolean) o[4];

			System.out.println(++i + ") " + op_name + "  " + "\t" + op_score + "\t" + op_bool);
		}

		System.out.println("Score is " + attemptService.getScore());

	}

}
