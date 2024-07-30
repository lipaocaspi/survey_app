package com.survey.survey_app;

import java.sql.Time;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.survey.survey_app.persistence.entity.Catalog;
import com.survey.survey_app.persistence.entity.Chapter;
import com.survey.survey_app.persistence.entity.DetailResponse;
import com.survey.survey_app.persistence.entity.Question;
import com.survey.survey_app.persistence.entity.Response;
import com.survey.survey_app.persistence.entity.ResponseCatalog;
import com.survey.survey_app.persistence.entity.ResponseOption;
import com.survey.survey_app.persistence.entity.Survey;
import com.survey.survey_app.domain.repository.CatalogRepository;
import com.survey.survey_app.domain.repository.ChapterRepository;
import com.survey.survey_app.domain.repository.DetailResponseRepository;
import com.survey.survey_app.domain.repository.QuestionRepository;
import com.survey.survey_app.domain.repository.ResponseCatalogRepository;
import com.survey.survey_app.domain.repository.ResponseOptionRepository;
import com.survey.survey_app.domain.repository.ResponseRepository;
import com.survey.survey_app.domain.repository.SurveyRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SurveyAppApplication implements CommandLineRunner {

	@Autowired
	private CatalogRepository catalogRepository;

	@Autowired
	private ChapterRepository chapterRepository;
	
	@Autowired
	private DetailResponseRepository detailResponseRepository;

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private ResponseRepository responseRepository;

	@Autowired
	private ResponseCatalogRepository responseCatalogRepository;
	
	@Autowired
	private ResponseOptionRepository responseOptionRepository;

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

		ResponseOption responseOption1 = new ResponseOption("1", 1L, "Not satisfied at all", "1", null);
		responseOptionRepository.save(responseOption1);
		ResponseOption responseOption2 = new ResponseOption("2", 1L, "Slightly satisfied", "2", null);
		responseOptionRepository.save(responseOption2);
		ResponseOption responseOption3 = new ResponseOption("3", 1L, "Moderately satisfied", "3", null);
		responseOptionRepository.save(responseOption3);
		ResponseOption responseOption4 = new ResponseOption("4", 1L, "Very satisfied", "4", null);
		responseOptionRepository.save(responseOption4);
		ResponseOption responseOption5 = new ResponseOption("5", 1L, "Extremely satisfied", "5", null);
		responseOptionRepository.save(responseOption5);
		ResponseOption responseOption6 = new ResponseOption("Yes", 3L, null, "Yes", null);
		responseOptionRepository.save(responseOption6);
		ResponseOption responseOption7 = new ResponseOption("No", 3L, null, "No", null);
		responseOptionRepository.save(responseOption7);
		ResponseOption responseOption8 = new ResponseOption("1", 4L, null, "1", null);
		responseOptionRepository.save(responseOption8);
		ResponseOption responseOption9 = new ResponseOption("2", 4L, null, "2", null);
		responseOptionRepository.save(responseOption9);
		ResponseOption responseOption10 = new ResponseOption("3", 4L, null, "3", null);
		responseOptionRepository.save(responseOption10);
		ResponseOption responseOption11 = new ResponseOption("4", 4L, null, "4", null);
		responseOptionRepository.save(responseOption11);
		ResponseOption responseOption12 = new ResponseOption("5", 4L, null, "5", null);
		responseOptionRepository.save(responseOption12);
		ResponseOption responseOption13 = new ResponseOption("Yes", 5L, null, "Yes", null);
		responseOptionRepository.save(responseOption13);
		ResponseOption responseOption14 = new ResponseOption("No", 5L, null, "No", null);
		responseOptionRepository.save(responseOption14);

		Time responseTime1 = Time.valueOf("12:30:00");
		Timestamp responseDate1 = Timestamp.valueOf("2024-07-29 12:30:00.000000");
		Response response1 = new Response(responseTime1, responseDate1, 1L, "John Doe");
		responseRepository.save(response1);
		Time responseTime2 = Time.valueOf("13:45:00");
		Timestamp responseDate2 = Timestamp.valueOf("2024-07-29 13:45:00.000000");
		Response response2 = new Response(responseTime2, responseDate2, 1L, "Jane Smith");
		responseRepository.save(response2);
		Time responseTime3 = Time.valueOf("14:00:00");
		Timestamp responseDate3 = Timestamp.valueOf("2024-07-29 14:00:00.000000");
		Response response3 = new Response(responseTime3, responseDate3, 2L, "Michael Johnson");
		responseRepository.save(response3);
		Time responseTime4 = Time.valueOf("15:15:00");
		Timestamp responseDate4 = Timestamp.valueOf("2024-07-29 15:15:00.000000");
		Response response4 = new Response(responseTime4, responseDate4, 2L, "Emily Davis");
		responseRepository.save(response4);

		DetailResponse detailResponse1 = new DetailResponse(4, 1L, 1L, null);
		detailResponseRepository.save(detailResponse1);
		DetailResponse detailResponse2 = new DetailResponse(null, 2L, 1L, "The service was quick and efficient");
		detailResponseRepository.save(detailResponse2);
		DetailResponse detailResponse3 = new DetailResponse(1, 3L, 1L, null);
		detailResponseRepository.save(detailResponse3);
		DetailResponse detailResponse4 = new DetailResponse(5, 1L, 2L, null);
		detailResponseRepository.save(detailResponse4);
		DetailResponse detailResponse5 = new DetailResponse(null, 2L, 2L, "I had a great experience overall");
		detailResponseRepository.save(detailResponse5);
		DetailResponse detailResponse6 = new DetailResponse(1, 3L, 2L, null);
		detailResponseRepository.save(detailResponse6);
		DetailResponse detailResponse7 = new DetailResponse(4, 4L, 3L, null);
		detailResponseRepository.save(detailResponse7);
		DetailResponse detailResponse8 = new DetailResponse(1, 5L, 3L, null);
		detailResponseRepository.save(detailResponse8);
		DetailResponse detailResponse9 = new DetailResponse(3, 4L, 4L, null);
		detailResponseRepository.save(detailResponse9);
		DetailResponse detailResponse10 = new DetailResponse(1, 5L, 4L, null);
		detailResponseRepository.save(detailResponse10);

		ResponseCatalog responseCatalog1 = new ResponseCatalog(1, 1L, 1L, 1L, "Option 1 for Question 1");
		responseCatalogRepository.save(responseCatalog1);
		ResponseCatalog responseCatalog2 = new ResponseCatalog(2, 1L, 2L, 1L, "Option 2 for Question 2");
		responseCatalogRepository.save(responseCatalog2);
		ResponseCatalog responseCatalog3 = new ResponseCatalog(1, 2L, 3L, 2L, "Option 1 for Question 3");
		responseCatalogRepository.save(responseCatalog3);
		ResponseCatalog responseCatalog4 = new ResponseCatalog(3, 2L, 4L, 2L, "Option 3 for Question 4");
		responseCatalogRepository.save(responseCatalog4);
		// System.out.println(question1);
	}
}