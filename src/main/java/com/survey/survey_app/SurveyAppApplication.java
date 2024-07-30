package com.survey.survey_app;

import java.sql.Timestamp;
// import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.survey.survey_app.domain.dto.Catalog;
import com.survey.survey_app.domain.dto.Chapter;
import com.survey.survey_app.domain.dto.Question;
import com.survey.survey_app.domain.dto.Survey;
import com.survey.survey_app.domain.repository.CatalogRepository;
import com.survey.survey_app.domain.repository.ChapterRepository;
/* import com.survey.survey_app.domain.repository.DetailResponseRepository; */
import com.survey.survey_app.domain.repository.QuestionRepository;
/* import com.survey.survey_app.domain.repository.ResponseCatalogRepository;
import com.survey.survey_app.domain.repository.ResponseOptionRepository;
import com.survey.survey_app.domain.repository.ResponseRepository; */
import com.survey.survey_app.domain.repository.SurveyRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SurveyAppApplication implements CommandLineRunner {

	@Autowired
	private CatalogRepository catalogRepository;

	@Autowired
	private ChapterRepository chapterRepository;
	/*
	@Autowired
	private DetailResponseRepository detailResponseRepository;
	*/
	@Autowired
	private QuestionRepository questionRepository;
	/*
	@Autowired
	private ResponseRepository responseRepository;

	@Autowired
	private ResponseCatalogRepository responseCatalogRepository;

	@Autowired
	private ResponseOptionRepository responseOptionRepository;
 	*/
	@Autowired
	private SurveyRepository surveyRepository;

	public static void main(String[] args) {
		SpringApplication.run(SurveyAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createAll();
	}

	@Transactional
	public void createAll(){
		Timestamp createAt1 = Timestamp.valueOf("2024-07-29 12:00:00.000000");
		Timestamp updatedAt1 = Timestamp.valueOf("2024-07-29 12:00:00.000000");
		Survey survey1 = new Survey(createAt1, updatedAt1, "Customer Satisfaction Survey", "Survey 1");
		surveyRepository.save(survey1);
		Timestamp createAt2 = Timestamp.valueOf("2024-07-29 13:00:00.000000");
		Timestamp updatedAt2 = Timestamp.valueOf("2024-07-29 13:00:00.000000");
		Survey survey2 = new Survey(createAt2, updatedAt2, "Employee Engagement Survey", "Survey 2");
		surveyRepository.save(survey2);

		Catalog catalog1 = new Catalog("Catalog 1");
		catalogRepository.save(catalog1);
		Catalog catalog2 = new Catalog("Catalog 2");
		catalogRepository.save(catalog2);

		Chapter chapter1 = new Chapter(1L, "C1", "Introduction");
		chapterRepository.save(chapter1);
		Chapter chapter2 = new Chapter(1L, "C2", "Feedback");
		chapterRepository.save(chapter2);
		Chapter chapter3 = new Chapter(2L, "C1", "Work Environment");
		chapterRepository.save(chapter3);
		Chapter chapter4 = new Chapter(2L, "C2", "Career Development");
		chapterRepository.save(chapter4);

		Question question1 = new Question(1L, null, 1L, "Q1", "How satisfied are you with our service?", "Multiple Choice", "Please select one option");
		questionRepository.save(question1);
		Question question2 = new Question(1L, 1L, 1L, "Q1.1", "Please specify the reason for your rating", "Text", null);
		questionRepository.save(question2);
		Question question3 = new Question(2L, null, 1L, "Q2", "Would you recommend our service to others?", "Yes/No", "Please select Yes or No");
		questionRepository.save(question3);
		Question question4 = new Question(3L, null, 2L, "Q1", "How would you rate the work environment?", "Rating", "Rate from 1 to 5");
		questionRepository.save(question4);
		Question question5 = new Question(4L, null, 2L, "Q2", "Do you feel there are opportunities for career development?", "Yes/No", "Please select Yes or No");
		questionRepository.save(question5);

		System.out.println(question1);
	}
}