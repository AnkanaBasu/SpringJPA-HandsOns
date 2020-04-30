package com.cognizant.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attempt_option")
public class AttemptOption {

	@Id
	@Column(name="ao_id")
	Integer id;
	
	@Column(name="ao_selected")
	Boolean selected;

	@ManyToOne
	@JoinColumn(name="ao_op_id")
	Options option;
	
	
	@ManyToOne
	@JoinColumn(name="ao_aq_id")
	AttemptQuestion attemptQuestion;


	
	public AttemptOption() {
		super();
	}


	public AttemptOption(Integer id, Boolean selected, Options option, AttemptQuestion attemptQuestion) {
		super();
		this.id = id;
		this.selected = selected;
		this.option = option;
		this.attemptQuestion = attemptQuestion;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Boolean getSelected() {
		return selected;
	}


	public void setSelected(Boolean selected) {
		this.selected = selected;
	}


	public Options getOption() {
		return option;
	}


	public void setOption(Options option) {
		this.option = option;
	}


	public AttemptQuestion getAttemptQuestion() {
		return attemptQuestion;
	}


	public void setAttemptQuestion(AttemptQuestion attemptQuestion) {
		this.attemptQuestion = attemptQuestion;
	}


	@Override
	public String toString() {
		return "AttemptOption [id=" + id + ", selected=" + selected + ", option=" + option + ", attemptQuestion="
				+ attemptQuestion + "]";
	}
	
	

}
