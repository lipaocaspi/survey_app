package com.survey.survey_app.domain.service.chapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey_app.domain.repository.ChapterRepository;
import com.survey.survey_app.persistence.entity.Chapter;

import jakarta.transaction.Transactional;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    @Transactional
    @Override
    public Optional<Chapter> delete(Long id) {
        Optional<Chapter> optionalChapter = this.chapterRepository.findById(id);
        optionalChapter.ifPresent(
            chapterFound -> {
                this.chapterRepository.delete(chapterFound);
            }
        );
        return optionalChapter;
    }

    @Override
    public List<Chapter> findAll() {
        return (List<Chapter>) this.chapterRepository.findAll();
    }

    @Override
    public Optional<Chapter> findById(Long id) {
        return this.chapterRepository.findById(id);
    }

    @Override
    public Chapter save(Chapter chapter) {
        return this.chapterRepository.save(chapter);
    }

    @Override
    public Optional<Chapter> update(Long id, Chapter chapter) {
        Optional<Chapter> optionalChapter = this.chapterRepository.findById(id);
        if (optionalChapter.isPresent()){
            Chapter chapterItem = optionalChapter.orElseThrow();
            chapterItem.setChapterNumber( chapter.getChapterNumber() );
            chapterItem.setChapterTitle( chapter.getChapterTitle() );
            return Optional.of( this.chapterRepository.save(chapterItem));
        }
        return optionalChapter;
    }
}