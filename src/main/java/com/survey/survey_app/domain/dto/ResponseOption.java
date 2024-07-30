package com.survey.survey_app.domain.dto;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "response_options")
public class ResponseOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String optionValue;
    private Long questionId;
    private String commentResponse;
    private String optionText;
    private Integer questionParent;

	@ManyToOne
    @JoinColumn(name = "questionId", insertable = false, updatable = false)
    private Question question;

	public ResponseOption() {}

	public ResponseOption(String optionValue, Long questionId, String commentResponse, String optionText, Integer questionParent) {
		this.optionValue = optionValue;
		this.questionId = questionId;
		this.commentResponse = commentResponse;
		this.optionText = optionText;
		this.questionParent = questionParent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getCommentResponse() {
		return commentResponse;
	}

	public void setCommentResponse(String commentResponse) {
		this.commentResponse = commentResponse;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public Integer getQuestionParent() {
		return questionParent;
	}

	public void setQuestionParent(Integer questionParent) {
		this.questionParent = questionParent;
	}
}