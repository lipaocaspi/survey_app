package com.survey.survey_app.domain.service.chapter;

import java.util.List;
import java.util.Optional;

import com.survey.survey_app.persistence.entity.Chapter;

public interface ChapterService {
    List<Chapter> findAll();
    Optional<Chapter> findById(Long id);
    Chapter save(Chapter catalog);
    Optional<Chapter> update(Long id, Chapter catalog);
    Optional<Chapter> delete(Long id);
}