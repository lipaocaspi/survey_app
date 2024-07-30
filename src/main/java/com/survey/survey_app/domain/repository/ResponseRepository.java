package com.survey.survey_app.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.survey.survey_app.persistence.entity.Response;

public interface ResponseRepository extends CrudRepository<Response, Long> {

}