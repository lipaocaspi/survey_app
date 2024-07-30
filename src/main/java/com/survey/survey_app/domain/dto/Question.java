package com.survey.survey_app.domain.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chapterId;
    private Long parentQuestionId;
    private Long surveyId;
    private String questionNumber;
    private String questionText;
    private String responseType;
    private String commentQuestion;

    @ManyToOne
    @JoinColumn(name = "chapterId", insertable = false, updatable = false)
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "parentQuestionId", insertable = false, updatable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "surveyId", insertable = false, updatable = false)
    private Survey survey;

    public Question() {}

    /* public Question(Long chapterId, Long surveyId, String questionNumber, String questionText, String responseType,
            String commentQuestion) {
        this.chapterId = chapterId;
        this.surveyId = surveyId;
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.responseType = responseType;
        this.commentQuestion = commentQuestion;
    } */

    public Question(Long chapterId, Long parentQuestionId, Long surveyId, String questionNumber, String questionText, String responseType, String commentQuestion) {
        this.chapterId = chapterId;
        this.parentQuestionId = parentQuestionId;
        this.surveyId = surveyId;
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.responseType = responseType;
        this.commentQuestion = commentQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Long getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestionId(Long parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getCommentQuestion() {
        return commentQuestion;
    }

    public void setCommentQuestion(String commentQuestion) {
        this.commentQuestion = commentQuestion;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
    
    
}