package com.cognizant.quiz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {

	@Id
	@Column(name="qt_id")
	Integer id;
	
	@Column(name="qt_text")
	String text;

	@OneToMany(mappedBy="question",fetch = FetchType.EAGER)
	Set<AttemptQuestion> attemptQuestion;
	
	@OneToMany(mappedBy="question",fetch = FetchType.EAGER)
	Set<Options> options;
	
	
	
	public Set<Options> getOptions() {
		return options;
	}

	public void setOptions(Set<Options> options) {
		this.options = options;
	}

	public Set<AttemptQuestion> getAttemptQuestion() {
		return attemptQuestion;
	}

	public void setAttemptQuestion(Set<AttemptQuestion> attemptQuestion) {
		this.attemptQuestion = attemptQuestion;
	}

	public Question() {
		super();
	}

	public Question(Integer id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", attemptQuestion=" + attemptQuestion + ", options=" + options
				+ "]";
	}
	
	
	
	
}