package com.survey.survey_app.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.survey.survey_app.persistence.entity.DetailResponse;

public interface DetailResponseRepository extends CrudRepository<DetailResponse, Long> {

}