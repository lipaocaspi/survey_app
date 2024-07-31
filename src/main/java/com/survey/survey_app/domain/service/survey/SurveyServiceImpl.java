package com.survey.survey_app.domain.service.survey;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey_app.domain.repository.SurveyRepository;
import com.survey.survey_app.persistence.entity.Survey;

import jakarta.transaction.Transactional;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    @Transactional
    @Override
    public Optional<Survey> delete(Long id) {
        Optional<Survey> optionalSurvey = this.surveyRepository.findById(id);
        optionalSurvey.ifPresent(
            surveyFound -> {
                this.surveyRepository.delete(surveyFound);
            }
        );
        return optionalSurvey;
    }

    @Override
    public List<Survey> findAll() {
        return (List<Survey>) this.surveyRepository.findAll();
    }

    @Override
    public Optional<Survey> findById(Long id) {
        return this.surveyRepository.findById(id);
    }

    @Override
    public Survey save(Survey survey) {
        return this.surveyRepository.save(survey);
    }

    @Override
    public Optional<Survey> update(Long id, Survey survey) {
        Optional<Survey> optionalSurvey = this.surveyRepository.findById(id);
        if (optionalSurvey.isPresent()){
            Survey surveyItem = optionalSurvey.orElseThrow();
            surveyItem.setName( survey.getName() );
            surveyItem.setDescription( survey.getDescription() );
            return Optional.of( this.surveyRepository.save(surveyItem));
        }
        return optionalSurvey;
    }
}