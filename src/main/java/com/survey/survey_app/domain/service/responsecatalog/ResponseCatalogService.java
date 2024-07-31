package com.survey.survey_app.domain.service.responsecatalog;

import java.util.List;
import java.util.Optional;

import com.survey.survey_app.persistence.entity.ResponseCatalog;

public interface ResponseCatalogService {
    List<ResponseCatalog> findAll();
    Optional<ResponseCatalog> findById(Long id);
    ResponseCatalog save(ResponseCatalog responseCatalog);
    Optional<ResponseCatalog> update(Long id, ResponseCatalog responseCatalog);
    Optional<ResponseCatalog> delete(Long id);
}