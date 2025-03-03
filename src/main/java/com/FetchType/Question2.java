package com.FetchType;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question2 {
	
	@Id
	@Column(name="question_id")
	private int questionId;
	
	private String question;
	
	@OneToMany(mappedBy="question",fetch = FetchType.EAGER)  
	private List<Answer2> answers;
// OneToMany creates extra table of questionid-answerid .if we use mappedBy then it won't create extra table.
	
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer2> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer2> answers) {
		this.answers = answers;
	}

	public Question2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question2(int questionId, String question, List<Answer2> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}
	
	
}
