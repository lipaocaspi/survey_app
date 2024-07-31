package com.survey.survey_app.domain.service.responseoption;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey_app.domain.repository.ResponseOptionRepository;
import com.survey.survey_app.persistence.entity.ResponseOption;

import jakarta.transaction.Transactional;

@Service
public class ResponseOptionServiceImpl implements ResponseOptionService {
    @Autowired
    private ResponseOptionRepository responseOptionRepository;

    @Transactional
    @Override
    public Optional<ResponseOption> delete(Long id) {
        Optional<ResponseOption> optionalResponseOption = this.responseOptionRepository.findById(id);
        optionalResponseOption.ifPresent(
            responseOptionFound -> {
                this.responseOptionRepository.delete(responseOptionFound);
            }
        );
        return optionalResponseOption;
    }

    @Override
    public List<ResponseOption> findAll() {
        return (List<ResponseOption>) this.responseOptionRepository.findAll();
    }

    @Override
    public Optional<ResponseOption> findById(Long id) {
        return this.responseOptionRepository.findById(id);
    }

    @Override
    public ResponseOption save(ResponseOption responseOption) {
        return this.responseOptionRepository.save(responseOption);
    }

    @Override
    public Optional<ResponseOption> update(Long id, ResponseOption responseOption) {
        Optional<ResponseOption> optionalResponseOption = this.responseOptionRepository.findById(id);
        if (optionalResponseOption.isPresent()){
            ResponseOption responseOptionItem = optionalResponseOption.orElseThrow();
            responseOptionItem.setCommentResponse( responseOption.getCommentResponse() );
            responseOptionItem.setOptionText( responseOption.getOptionText() );
            responseOption.setOptionValue( responseOption.getOptionValue());
            return Optional.of( this.responseOptionRepository.save(responseOptionItem));
        }
        return optionalResponseOption;
    }
}