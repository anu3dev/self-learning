package com.learning.quizapp;

public class ReadMe {
}

/*
 * to create a connection in mySQL workbench app -
 * login with any user which has root level access and create connection from user and privileges tab.
 * also provide roles to perform operations and create a schema.
 *
 * CREATE TABLE quizapp.question ( id int NOT NULL PRIMARY KEY AUTO_INCREMENT, category varchar(255), difficulty_level varchar(255),
 * option1 varchar(255), option2 varchar(255), option3 varchar(255), option4 varchar(255), question_title varchar(255), right_answer varchar(255));
 *
 * INSERT INTO quizapp.question (id, category, difficulty_level, option1, option2, option3, option4, question_title, right_answer)
 * VALUES (1,'JAVA', 'EASY', '0', 'Not a Number', 'Infinity', 'Run time exception', 'What does the expression float a = 35 / 0 return?', 'Infinity');
 *
 * INSERT INTO quizapp.question (id, category, difficulty_level, option1, option2, option3, option4, question_title, right_answer)
 * VALUES (2,'JAVASCRIPT', 'EASY', 'const', 'var', 'let', 'static', 'Which keyword is used for declaring a variable in JavaScript that can be reassigned?', 'let');
 *
 * CREATE TABLE quizapp.quiz ( id int NOT NULL PRIMARY KEY AUTO_INCREMENT, title varchar(255));
 *
 * CREATE TABLE quizapp.quiz_question ( quiz_id int, question_id int);
 */

/*
 * There are multiple layers in spring boot applications.
 * Controller layer - to accept user request.
 * Service layer - do some processing based on request received by controller layer, generally we write all business logics here.
 * Dao layer - is responsible to connect with DB and fetch data.
 *
 * to use DAO, just need to create an interface and extend to JPA repo, it requires two values, one object name and other object type.
 */

/*
 * @SpringBootApplication
 * @RestController - to accept the rest request.
 * @RequestMapping("question") - to create an url path, here question will be in url.
 * @GetMapping("allQuestions") - to create method level url, here url will be http://localhost:8080/question/allQuestions
 *
 * @Autowired - instead of creating an object using new keyword, we use @Autowired annotation.
 * @Service - if we want spring to handle any object then either we can use @Component or @Service
 * @Entity - create a model to work with a table
 * @Data - to use lombok features
 * @Table(name="questions") - if entity model name is different then table name then we can specify the table name in model.
 * @Id - is auto generated and primary key.
 *
 * if we put the snake casing as column name then we can put camel case in model name.
 * e.g. question_title is column name then questionTitle will be variable name in model.
 */

/*
 * he
 */
