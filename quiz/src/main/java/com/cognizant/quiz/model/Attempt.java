package com.cognizant.quiz.model;

import java.util.Date;
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
@Table(name="attempt")
public class Attempt {

	@Id
	@Column(name="at_id")
	Integer id;
	
	@Column(name="at_date")
	Date date;

	@Column(name="at_score")
	Double score;
	
	@ManyToOne
	@JoinColumn(name = "at_us_id")
	User user_id;


	@OneToMany(mappedBy="attempt",fetch = FetchType.EAGER)
	Set<AttemptQuestion> attemptQuestion;
	
	
	
	public Set<AttemptQuestion> getAttemptQuestion() {
		return attemptQuestion;
	}

	public void setAttemptQuestion(Set<AttemptQuestion> attemptQuestion) {
		this.attemptQuestion = attemptQuestion;
	}

	public Attempt() {
		super();
	}

	public Attempt(Integer id, Date date, Double score, User user_id) {
		super();
		this.id = id;
		this.date = date;
		this.score = score;
		this.user_id = user_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Attempt [id=" + id + ", date=" + date + ", score=" + score + ", user_id=" + user_id
				+ ", attemptQuestion=" + attemptQuestion + "]";
	}
	
	
	
	
}