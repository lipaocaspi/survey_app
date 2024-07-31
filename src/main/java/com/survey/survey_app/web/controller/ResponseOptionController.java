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

import com.survey.survey_app.domain.service.responseoption.ResponseOptionService;
import com.survey.survey_app.persistence.entity.ResponseOption;

@RestController
@RequestMapping("/api/response-options")
public class ResponseOptionController {

    @Autowired
    private ResponseOptionService responseOptionService;

    @GetMapping
    public List<ResponseOption> listResponseOptions(){
        return this.responseOptionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOption> view(@PathVariable Long id){
        Optional<ResponseOption> optionalResponseOption  = responseOptionService.findById(id);
        if (optionalResponseOption.isPresent()){
            return ResponseEntity.ok(optionalResponseOption.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ResponseOption> create(@RequestBody ResponseOption responseOption){
        ResponseOption responseOptionNew = this.responseOptionService.save(responseOption);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseOptionNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseOption> update(@PathVariable Long id, @RequestBody ResponseOption responseOption){
        Optional<ResponseOption> responseOptionOptional = this.responseOptionService.update(id, responseOption);
        if (responseOptionOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(responseOptionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseOption> delete(@PathVariable Long id){
        ResponseOption responseOption = new ResponseOption();
        responseOption.setId(id);
        Optional<ResponseOption> optionalResponseOption = this.responseOptionService.delete(id);
        if (optionalResponseOption.isPresent()){
            return ResponseEntity.ok(optionalResponseOption.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}