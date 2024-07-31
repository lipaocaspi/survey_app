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

import com.survey.survey_app.domain.service.catalog.CatalogService;
import com.survey.survey_app.persistence.entity.Catalog;

@RestController
@RequestMapping("/api/catalogs")
public class CatalogController {
    
    @Autowired
    private CatalogService catalogService;

    @GetMapping
    public List<Catalog> listCatalogs(){
        return this.catalogService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalog> view(@PathVariable Long id){
        Optional<Catalog> optionalCatalog  = catalogService.findById(id);
        if (optionalCatalog.isPresent()){
            return ResponseEntity.ok(optionalCatalog.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Catalog> create(@RequestBody Catalog catalog){
        Catalog catalogNew = this.catalogService.save(catalog);
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Catalog> update(@PathVariable Long id, @RequestBody Catalog catalog){
        Optional<Catalog> catalogOptional = this.catalogService.update(id, catalog);
        if (catalogOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(catalogOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Catalog> delete(@PathVariable Long id){
        Catalog catalog = new Catalog();
        catalog.setId(id);
        Optional<Catalog> optionalCatalog = this.catalogService.delete(id);
        if (optionalCatalog.isPresent()){
            return ResponseEntity.ok(optionalCatalog.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}