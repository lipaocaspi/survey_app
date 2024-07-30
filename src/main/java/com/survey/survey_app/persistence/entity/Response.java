package com.survey.survey_app.persistence.entity;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private Time responseTime;
    private Timestamp responseDate;
    private Long surveyId;
    private String nameRespondent;

	@ManyToOne
    @JoinColumn(name = "surveyId", insertable = false, updatable = false)
    private Survey survey;
    
	public Response() {}

	public Response(Time responseTime, Timestamp responseDate, Long surveyId, String nameRespondent) {
		this.responseTime = responseTime;
		this.responseDate = responseDate;
		this.surveyId = surveyId;
		this.nameRespondent = nameRespondent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Time getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Time responseTime) {
		this.responseTime = responseTime;
	}

	public Timestamp getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Timestamp responseDate) {
		this.responseDate = responseDate;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getNameRespondent() {
		return nameRespondent;
	}

	public void setNameRespondent(String nameRespondent) {
		this.nameRespondent = nameRespondent;
	}
}