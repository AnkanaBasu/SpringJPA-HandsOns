package com.cognizant.quiz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="attempt_question")
public class AttemptQuestion {

	@Id
	@Column(name="aq_id")
	Integer id;
	
	@ManyToOne
	@JoinColumn(name="aq_at_id")
	Attempt attempt;
	
	@ManyToOne
	@JoinColumn(name="aq_qt_id")
	Question question;
	

	@OneToMany(mappedBy="attemptQuestion",fetch = FetchType.EAGER)
	Set<AttemptOption> attemptOption;
	
	
	public Set<AttemptOption> getAttemptOption() {
		return attemptOption;
	}




	public void setAttemptOption(Set<AttemptOption> attemptOption) {
		this.attemptOption = attemptOption;
	}




	public AttemptQuestion() {
		super();
	}
	
	
	

	public AttemptQuestion(Integer id, Attempt attempt, Question question) {
		super();
		this.id = id;
		this.attempt = attempt;
		this.question = question;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Attempt getAttempt() {
		return attempt;
	}

	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}




	@Override
	public String toString() {
		return "AttemptQuestion [id=" + id + ", attempt=" + attempt + ", question=" + question + ", attemptOption="
				+ attemptOption + "]";
	}
	
	
	
	
}