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

import com.survey.survey_app.domain.service.detailresponse.DetailResponseService;
import com.survey.survey_app.persistence.entity.DetailResponse;

@RestController
@RequestMapping("/api/detail-responses")
public class DetailResponseController {
    
    @Autowired
    private DetailResponseService detailResponseService;

    @GetMapping
    public List<DetailResponse> listDetailResponses(){
        return this.detailResponseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailResponse> view(@PathVariable Long id){
        Optional<DetailResponse> optionalDetailResponse  = detailResponseService.findById(id);
        if (optionalDetailResponse.isPresent()){
            return ResponseEntity.ok(optionalDetailResponse.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DetailResponse> create(@RequestBody DetailResponse detailResponse){
        DetailResponse detailResponseNew = this.detailResponseService.save(detailResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(detailResponseNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailResponse> update(@PathVariable Long id, @RequestBody DetailResponse detailResponse){
        Optional<DetailResponse> detailResponseOptional = this.detailResponseService.update(id, detailResponse);
        if (detailResponseOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(detailResponseOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetailResponse> delete(@PathVariable Long id){
        DetailResponse detailResponse = new DetailResponse();
        detailResponse.setId(id);
        Optional<DetailResponse> optionalDetailResponse = this.detailResponseService.delete(id);
        if (optionalDetailResponse.isPresent()){
            return ResponseEntity.ok(optionalDetailResponse.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}