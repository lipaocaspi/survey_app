package com.survey.survey_app.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.survey.survey_app.domain.dto.Catalog;

public interface CatalogRepository extends CrudRepository<Catalog, Long> {

}