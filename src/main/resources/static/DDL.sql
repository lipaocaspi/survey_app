DROP DATABASE IF EXISTS survey;
CREATE DATABASE survey;
USE survey;

CREATE TABLE surveys (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    create_at TIMESTAMP(6),
    updated_at TIMESTAMP(6),
    description VARCHAR(255),
    name VARCHAR(255)
);

CREATE TABLE catalogs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE responses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    response_time TIME(6),
    response_date TIMESTAMP(6),
    survey_id BIGINT,
    name_respondent VARCHAR(255),
    FOREIGN KEY (survey_id) REFERENCES surveys(id)
);

CREATE TABLE chapter (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    survey_id BIGINT,
    chapter_number VARCHAR(255),
    chapter_title VARCHAR(255),
    FOREIGN KEY (survey_id) REFERENCES surveys(id)
);

CREATE TABLE questions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    chapter_id BIGINT,
    parent_question_id BIGINT,
    survey_id BIGINT,
    question_number VARCHAR(255),
    question_text VARCHAR(255),
    response_type VARCHAR(255),
    comment_question VARCHAR(255),
    FOREIGN KEY (chapter_id) REFERENCES chapter(id),
    FOREIGN KEY (parent_question_id) REFERENCES questions(id),
    FOREIGN KEY (survey_id) REFERENCES surveys(id)
);

CREATE TABLE response_options (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    option_value VARCHAR(5),
    question_id BIGINT,
    comment_response VARCHAR(255),
    option_text VARCHAR(255),
    question_parent INT,
    FOREIGN KEY (question_id) REFERENCES questions(id)
);

CREATE TABLE detail_responses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    response_option INT,
    question_id BIGINT,
    response_id BIGINT,
    response_text VARCHAR(255),
    FOREIGN KEY (question_id) REFERENCES questions(id),
    FOREIGN KEY (response_id) REFERENCES responses(id)
);

CREATE TABLE response_catalogs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    response_option INT,
    catalog_id BIGINT,
    question_id BIGINT,
    response_id BIGINT,
    response_text VARCHAR(255),
    FOREIGN KEY (catalog_id) REFERENCES catalogs(id),
    FOREIGN KEY (question_id) REFERENCES questions(id),
    FOREIGN KEY (response_id) REFERENCES responses(id)
);

-- Poblar la tabla surveys
INSERT INTO surveys (create_at, updated_at, description, name) VALUES
('2024-07-29 12:00:00.000000', '2024-07-29 12:00:00.000000', 'Customer Satisfaction Survey', 'Survey 1'),
('2024-07-29 13:00:00.000000', '2024-07-29 13:00:00.000000', 'Employee Engagement Survey', 'Survey 2');

-- Poblar la tabla catalogs
INSERT INTO catalogs (name) VALUES
('Catalog 1'),
('Catalog 2');

-- Poblar la tabla chapter
INSERT INTO chapter (survey_id, chapter_number, chapter_title) VALUES
(1, 'C1', 'Introduction'),
(1, 'C2', 'Feedback'),
(2, 'C1', 'Work Environment'),
(2, 'C2', 'Career Development');

-- Poblar la tabla questions
INSERT INTO questions (chapter_id, parent_question_id, survey_id, question_number, question_text, response_type, comment_question) VALUES
(1, NULL, 1, 'Q1', 'How satisfied are you with our service?', 'Multiple Choice', 'Please select one option'),
(1, 1, 1, 'Q1.1', 'Please specify the reason for your rating', 'Text', NULL),
(2, NULL, 1, 'Q2', 'Would you recommend our service to others?', 'Yes/No', 'Please select Yes or No'),
(3, NULL, 2, 'Q1', 'How would you rate the work environment?', 'Rating', 'Rate from 1 to 5'),
(4, NULL, 2, 'Q2', 'Do you feel there are opportunities for career development?', 'Yes/No', 'Please select Yes or No');

-- Poblar la tabla response_options
INSERT INTO response_options (option_value, question_id, comment_response, option_text, question_parent) VALUES
('1', 1, 'Not satisfied at all', '1', NULL),
('2', 1, 'Slightly satisfied', '2', NULL),
('3', 1, 'Moderately satisfied', '3', NULL),
('4', 1, 'Very satisfied', '4', NULL),
('5', 1, 'Extremely satisfied', '5', NULL),
('Yes', 3, NULL, 'Yes', NULL),
('No', 3, NULL, 'No', NULL),
('1', 4, NULL, '1', NULL),
('2', 4, NULL, '2', NULL),
('3', 4, NULL, '3', NULL),
('4', 4, NULL, '4', NULL),
('5', 4, NULL, '5', NULL),
('Yes', 5, NULL, 'Yes', NULL),
('No', 5, NULL, 'No', NULL);

-- Poblar la tabla responses
INSERT INTO responses (response_time, response_date, survey_id, name_respondent) VALUES
('12:30:00.000000', '2024-07-29 12:30:00.000000', 1, 'John Doe'),
('13:45:00.000000', '2024-07-29 13:45:00.000000', 1, 'Jane Smith'),
('14:00:00.000000', '2024-07-29 14:00:00.000000', 2, 'Michael Johnson'),
('15:15:00.000000', '2024-07-29 15:15:00.000000', 2, 'Emily Davis');

-- Poblar la tabla detail_responses
INSERT INTO detail_responses (response_option, question_id, response_id, response_text) VALUES
(4, 1, 1, NULL),
(NULL, 2, 1, 'The service was quick and efficient'),
(1, 3, 1, NULL),
(5, 1, 2, NULL),
(NULL, 2, 2, 'I had a great experience overall'),
(1, 3, 2, NULL),
(4, 4, 3, NULL),
(1, 5, 3, NULL),
(3, 4, 4, NULL),
(1, 5, 4, NULL);

-- Poblar la tabla response_catalogs
INSERT INTO response_catalogs (response_option, catalog_id, question_id, response_id, response_text) VALUES
(1, 1, 1, 1, 'Option 1 for Question 1'),
(2, 1, 2, 1, 'Option 2 for Question 2'),
(1, 2, 3, 2, 'Option 1 for Question 3'),
(3, 2, 4, 2, 'Option 3 for Question 4');