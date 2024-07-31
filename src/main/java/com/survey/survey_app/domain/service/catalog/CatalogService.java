package com.survey.survey_app.domain.service.catalog;

import java.util.List;
import java.util.Optional;

import com.survey.survey_app.persistence.entity.Catalog;

public interface CatalogService {
    List<Catalog> findAll();
    Optional<Catalog> findById(Long id);
    Catalog save(Catalog catalog);
    Optional<Catalog> update(Long id, Catalog catalog);
    Optional<Catalog> delete(Long id);
}