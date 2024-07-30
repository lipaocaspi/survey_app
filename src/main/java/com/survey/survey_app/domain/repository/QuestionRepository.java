package com.survey.survey_app.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.survey.survey_app.persistence.entity.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}