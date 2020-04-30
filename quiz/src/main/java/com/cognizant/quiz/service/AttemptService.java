package com.cognizant.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.quiz.AttemptRepository;
import com.cognizant.quiz.model.Attempt;

@Service
public class AttemptService {

	@Autowired
	AttemptRepository attemptRepository;
	
	@Transactional
	public Attempt getAttempt(int userId, int attemptId)
	{
		
		return attemptRepository.findById(attemptId).get();
		
		
	}
	
	@Transactional
	public double getScore()
	{
		return attemptRepository.getScore();
	}
	
	@Transactional
	public List<Object[]> getDetails()
	{
		return attemptRepository.getDetails();
	}
}
