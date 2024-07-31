package com.survey.survey_app.domain.service.question;

import java.util.List;
import java.util.Optional;

import com.survey.survey_app.persistence.entity.Question;

public interface QuestionService {
    List<Question> findAll();
    Optional<Question> findById(Long id);
    Question save(Question question);
    Optional<Question> update(Long id, Question detailResponse);
    Optional<Question> delete(Long id);
}