package com.survey.survey_app.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.survey.survey_app.domain.dto.Chapter;

public interface ChapterRepository extends CrudRepository<Chapter, Long> {

}