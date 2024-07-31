package com.survey.survey_app.domain.service.detailresponse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey_app.domain.repository.DetailResponseRepository;
import com.survey.survey_app.persistence.entity.DetailResponse;

import jakarta.transaction.Transactional;

@Service
public class DetailResponseServiceImpl implements DetailResponseService {
    @Autowired
    private DetailResponseRepository detailResponseRepository;

    @Transactional
    @Override
    public Optional<DetailResponse> delete(Long id) {
        Optional<DetailResponse> optionalDetailResponse = this.detailResponseRepository.findById(id);
        optionalDetailResponse.ifPresent(
            detailResponseFound -> {
                this.detailResponseRepository.delete(detailResponseFound);
            }
        );
        return optionalDetailResponse;
    }

    @Override
    public List<DetailResponse> findAll() {
        return (List<DetailResponse>) this.detailResponseRepository.findAll();
    }

    @Override
    public Optional<DetailResponse> findById(Long id) {
        return this.detailResponseRepository.findById(id);
    }

    @Override
    public DetailResponse save(DetailResponse detailResponse) {
        return this.detailResponseRepository.save(detailResponse);
    }

    @Override
    public Optional<DetailResponse> update(Long id, DetailResponse detailResponse) {
        Optional<DetailResponse> optionalDetailResponse = this.detailResponseRepository.findById(id);
        if (optionalDetailResponse.isPresent()){
            DetailResponse detailResponseItem = optionalDetailResponse.orElseThrow();
            detailResponseItem.setResponseOption( detailResponse.getResponseOption() );
            detailResponseItem.setResponseText( detailResponse.getResponseText() );
            return Optional.of( this.detailResponseRepository.save(detailResponseItem));
        }
        return optionalDetailResponse;
    }
}