package com.survey.survey_app.domain.service.response;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey_app.domain.repository.ResponseRepository;
import com.survey.survey_app.persistence.entity.Response;

import jakarta.transaction.Transactional;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    @Transactional
    @Override
    public Optional<Response> delete(Long id) {
        Optional<Response> optionalResponse = this.responseRepository.findById(id);
        optionalResponse.ifPresent(
            responseFound -> {
                this.responseRepository.delete(responseFound);
            }
        );
        return optionalResponse;
    }

    @Override
    public List<Response> findAll() {
        return (List<Response>) this.responseRepository.findAll();
    }

    @Override
    public Optional<Response> findById(Long id) {
        return this.responseRepository.findById(id);
    }

    @Override
    public Response save(Response response) {
        return this.responseRepository.save(response);
    }

    @Override
    public Optional<Response> update(Long id, Response response) {
        Optional<Response> optionalResponse = this.responseRepository.findById(id);
        if (optionalResponse.isPresent()){
            Response responseItem = optionalResponse.orElseThrow();
            responseItem.setNameRespondent(response.getNameRespondent());
            return Optional.of( this.responseRepository.save(responseItem));
        }
        return optionalResponse;
    }
}