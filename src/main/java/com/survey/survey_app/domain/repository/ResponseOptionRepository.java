package com.survey.survey_app.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.survey.survey_app.domain.dto.ResponseOption;

public interface ResponseOptionRepository extends CrudRepository<ResponseOption, Long> {

}