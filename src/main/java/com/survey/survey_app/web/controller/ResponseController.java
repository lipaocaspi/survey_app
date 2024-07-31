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

import com.survey.survey_app.domain.service.response.ResponseService;
import com.survey.survey_app.persistence.entity.Response;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @GetMapping
    public List<Response> listResponses(){
        return this.responseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> view(@PathVariable Long id){
        Optional<Response> optionalResponse  = responseService.findById(id);
        if (optionalResponse.isPresent()){
            return ResponseEntity.ok(optionalResponse.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody Response response){
        Response responseNew = this.responseService.save(response);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable Long id, @RequestBody Response response){
        Optional<Response> responseOptional = this.responseService.update(id, response);
        if (responseOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(responseOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        Response response = new Response();
        response.setId(id);
        Optional<Response> optionalResponse = this.responseService.delete(id);
        if (optionalResponse.isPresent()){
            return ResponseEntity.ok(optionalResponse.orElseThrow());
        }
        return ResponseEntity.notFound().build();

    }
}