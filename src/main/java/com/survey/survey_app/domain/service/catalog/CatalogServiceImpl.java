package com.survey.survey_app.domain.service.catalog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey_app.domain.repository.CatalogRepository;
import com.survey.survey_app.persistence.entity.Catalog;

import jakarta.transaction.Transactional;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Transactional
    @Override
    public Optional<Catalog> delete(Long id) {
        Optional<Catalog> optionalCatalog = this.catalogRepository.findById(id);
        optionalCatalog.ifPresent(
            catalogFound -> {
                this.catalogRepository.delete(catalogFound);
            }
        );
        return optionalCatalog;
    }

    @Override
    public List<Catalog> findAll() {
        return (List<Catalog>) this.catalogRepository.findAll();
    }

    @Override
    public Optional<Catalog> findById(Long id) {
        return this.catalogRepository.findById(id);
    }

    @Override
    public Catalog save(Catalog catalog) {
        return this.catalogRepository.save(catalog);
    }

    @Override
    public Optional<Catalog> update(Long id, Catalog catalog) {
        Optional<Catalog> optionalCatalog = this.catalogRepository.findById(id);
        if (optionalCatalog.isPresent()){
            Catalog catalogItem = optionalCatalog.orElseThrow();
            catalogItem.setName(catalog.getName());
            return Optional.of(this.catalogRepository.save(catalogItem));
        }
        return optionalCatalog;
    }
}