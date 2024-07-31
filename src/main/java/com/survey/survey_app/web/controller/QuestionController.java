package com.survey.survey_app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.survey_app.domain.service.question.QuestionService;
import com.survey.survey_app.persistence.entity.Question;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    
     @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> listQuestions(){
        return this.questionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> view(@PathVariable Long id){
        Optional<Question> optionalQuestion  = questionService.findById(id);
        if (optionalQuestion.isPresent()){
            return ResponseEntity.ok(optionalQuestion.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Question> create(@RequestBody Question question){
        Question questionNew = this.questionService.save(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(questionNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> update(@PathVariable Long id, @RequestBody Question question){
        Optional<Question> questionOptional = this.questionService.update(id, question);
        if (questionOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(questionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Question> delete(@PathVariable Long id){
        Question question = new Question();
        question.setId(id);
        Optional<Question> optionalQuestion = this.questionService.delete(id);
        if (optionalQuestion.isPresent()){
            return ResponseEntity.ok(optionalQuestion.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}