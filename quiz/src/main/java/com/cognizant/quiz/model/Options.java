package com.cognizant.quiz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="options")
public class Options {
	@Id
	@Column(name="op_id")
	Integer id;
	
	@Column(name="op_score")
	Double score;
	
	@Column(name="op_text")
	String text;

	@ManyToOne
	@JoinColumn(name="op_qt_id")
	Question question;
	
	@OneToMany(mappedBy="option")
	Set<AttemptOption> attemptOption;

	


	public Options(Integer id, Double score, String text, Question question) {
		super();
		this.id = id;
		this.score = score;
		this.text = text;
		this.question = question;
	}

	public Options() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Set<AttemptOption> getAttemptOption() {
		return attemptOption;
	}

	public void setOptions(Set<AttemptOption> attemptOption) {
		this.attemptOption = attemptOption;
	}

	@Override
	public String toString() {
		return "Options [id=" + id + ", score=" + score + ", text=" + text + ", question=" + question
				+ ", attemptOption=" + attemptOption + "]";
	}
}
