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

import com.survey.survey_app.domain.service.chapter.ChapterService;
import com.survey.survey_app.persistence.entity.Chapter;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping
    public List<Chapter> listChapters(){
        return this.chapterService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chapter> view(@PathVariable Long id){
        Optional<Chapter> optionalChapter  = chapterService.findById(id);
        if (optionalChapter.isPresent()){
            return ResponseEntity.ok(optionalChapter.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Chapter> create(@RequestBody Chapter chapter){
        Chapter chapterNew = this.chapterService.save(chapter);
        return ResponseEntity.status(HttpStatus.CREATED).body(chapterNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chapter> update(@PathVariable Long id, @RequestBody Chapter chapter){
        Optional<Chapter> chapterOptional = this.chapterService.update(id, chapter);
        if (chapterOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(chapterOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Chapter> delete(@PathVariable Long id){
        Chapter chapter = new Chapter();
        chapter.setId(id);
        Optional<Chapter> optionalChapter = this.chapterService.delete(id);
        if (optionalChapter.isPresent()){
            return ResponseEntity.ok(optionalChapter.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}