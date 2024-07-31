package com.survey.survey_app.domain.service.question;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey_app.domain.repository.QuestionRepository;
import com.survey.survey_app.persistence.entity.Question;

import jakarta.transaction.Transactional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    @Override
    public Optional<Question> delete(Long id) {
        Optional<Question> optionalQuestion = this.questionRepository.findById(id);
        optionalQuestion.ifPresent(
            questionFound -> {
                this.questionRepository.delete(questionFound);
            }
        );
        return optionalQuestion;
    }

    @Override
    public List<Question> findAll() {
        return (List<Question>) this.questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return this.questionRepository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Optional<Question> update(Long id, Question question) {
        Optional<Question> optionalQuestion = this.questionRepository.findById(id);
        if (optionalQuestion.isPresent()){
            Question questionItem = optionalQuestion.orElseThrow();
            questionItem.setCommentQuestion( question.getCommentQuestion() );
            questionItem.setQuestionText( question.getQuestionText() );
            questionItem.setResponseType( question.getResponseType()) ;
            questionItem.setQuestionNumber( question.getQuestionNumber());
            return Optional.of( this.questionRepository.save(questionItem));
        }
        return optionalQuestion;
    }
}