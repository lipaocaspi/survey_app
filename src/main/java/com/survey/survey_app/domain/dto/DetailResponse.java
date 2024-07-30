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
@Table(name = "detail_responses")
public class DetailResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private Integer responseOption;
    private Long questionId;
    private Long responseId;
    private String responseText;

	@ManyToOne
    @JoinColumn(name = "questionId", insertable = false, updatable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "responseId", insertable = false, updatable = false)
    private Response response;

	public DetailResponse() {}

	public DetailResponse(Integer responseOption, Long questionId, Long responseId, String responseText) {
		this.responseOption = responseOption;
		this.questionId = questionId;
		this.responseId = responseId;
		this.responseText = responseText;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getResponseOption() {
		return responseOption;
	}

	public void setResponseOption(Integer responseOption) {
		this.responseOption = responseOption;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getResponseId() {
		return responseId;
	}

	public void setResponseId(Long responseId) {
		this.responseId = responseId;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
}