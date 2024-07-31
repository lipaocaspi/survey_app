package com.survey.survey_app.domain.service.responsecatalog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey_app.domain.repository.ResponseCatalogRepository;
import com.survey.survey_app.persistence.entity.ResponseCatalog;

import jakarta.transaction.Transactional;

@Service
public class ResponseCatalogServiceImpl implements ResponseCatalogService {
    @Autowired
    private ResponseCatalogRepository responseCatalogRepository;

    @Transactional
    @Override
    public Optional<ResponseCatalog> delete(Long id) {
        Optional<ResponseCatalog> optionalResponseCatalog = this.responseCatalogRepository.findById(id);

        optionalResponseCatalog.ifPresent(
            responseCatalogFound -> {
                this.responseCatalogRepository.delete(responseCatalogFound);
            }
        );

        return optionalResponseCatalog;
    }

    @Override
    public List<ResponseCatalog> findAll() {
        return (List<ResponseCatalog>) this.responseCatalogRepository.findAll();
    }

    @Override
    public Optional<ResponseCatalog> findById(Long id) {
        return this.responseCatalogRepository.findById(id);
    }

    @Override
    public ResponseCatalog save(ResponseCatalog responseCatalog) {
        return this.responseCatalogRepository.save(responseCatalog);
    }

    @Override
    public Optional<ResponseCatalog> update(Long id, ResponseCatalog responseCatalog) {
        Optional<ResponseCatalog> optionalResponseCatalog = this.responseCatalogRepository.findById(id);
        if (optionalResponseCatalog.isPresent()){
            ResponseCatalog responseCatalogItem = optionalResponseCatalog.orElseThrow();
            responseCatalogItem.setResponseOption( responseCatalog.getResponseOption() );
            responseCatalogItem.setResponseText( responseCatalog.getResponseText() );
            return Optional.of( this.responseCatalogRepository.save(responseCatalogItem));
        }
        return optionalResponseCatalog;
    }
}