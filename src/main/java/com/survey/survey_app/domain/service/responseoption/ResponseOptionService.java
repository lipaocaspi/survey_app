package com.survey.survey_app.domain.service.responseoption;

import java.util.List;
import java.util.Optional;

import com.survey.survey_app.persistence.entity.ResponseOption;

public interface ResponseOptionService {
    List<ResponseOption> findAll();
    Optional<ResponseOption> findById(Long id);
    ResponseOption save(ResponseOption responseOption);
    Optional<ResponseOption> update( Long id, ResponseOption responseOption);
    Optional<ResponseOption> delete(Long id);
}