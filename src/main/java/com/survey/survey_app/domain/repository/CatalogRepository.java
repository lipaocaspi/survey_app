package com.survey.survey_app.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.survey.survey_app.persistence.entity.Catalog;

public interface CatalogRepository extends CrudRepository<Catalog, Long> {

}