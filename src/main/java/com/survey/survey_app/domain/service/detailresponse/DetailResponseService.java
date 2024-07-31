package com.survey.survey_app.domain.service.detailresponse;

import java.util.List;
import java.util.Optional;

import com.survey.survey_app.persistence.entity.DetailResponse;

public interface DetailResponseService {
    List<DetailResponse> findAll();
    Optional<DetailResponse> findById(Long id);
    DetailResponse save(DetailResponse detailResponse);
    Optional<DetailResponse> update(Long id, DetailResponse detailResponse);
    Optional<DetailResponse> delete(Long id);
}