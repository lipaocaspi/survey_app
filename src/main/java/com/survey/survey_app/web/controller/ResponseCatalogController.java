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

import com.survey.survey_app.domain.service.responsecatalog.ResponseCatalogService;
import com.survey.survey_app.persistence.entity.ResponseCatalog;

@RestController
@RequestMapping("/api/response-catalogs")
public class ResponseCatalogController {
    
    @Autowired
    private ResponseCatalogService responseCatalogService;

    @GetMapping
    public List<ResponseCatalog> listResponseCatalogs(){
        return this.responseCatalogService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCatalog> view(@PathVariable Long id){
        Optional<ResponseCatalog> optionalResponseCatalog  = responseCatalogService.findById(id);
        if (optionalResponseCatalog.isPresent()){
            return ResponseEntity.ok(optionalResponseCatalog.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ResponseCatalog> create(@RequestBody ResponseCatalog responseCatalog){
        ResponseCatalog responseCatalogNew = this.responseCatalogService.save(responseCatalog);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseCatalogNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCatalog> update(@PathVariable Long id, @RequestBody ResponseCatalog responseCatalog){
        Optional<ResponseCatalog> responseCatalogOptional = this.responseCatalogService.update(id, responseCatalog);
        if (responseCatalogOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(responseCatalogOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseCatalog> delete(@PathVariable Long id){
        ResponseCatalog responseCatalog = new ResponseCatalog();
        responseCatalog.setId(id);
        Optional<ResponseCatalog> optionalResponseCatalog = this.responseCatalogService.delete(id);
        if (optionalResponseCatalog.isPresent()){
            return ResponseEntity.ok(optionalResponseCatalog.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}