package com.survey.survey_app.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.survey.survey_app.domain.dto.Survey;

public interface SurveyRepository extends CrudRepository<Survey, Long> {

}