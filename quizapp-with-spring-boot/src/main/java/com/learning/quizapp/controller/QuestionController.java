package com.learning.quizapp.controller;

import com.learning.quizapp.model.Question;
import com.learning.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    // http://localhost:8080/question/allQuestions
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    // http://localhost:8080/question/category/JAVA
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    // http://localhost:8080/question/addQuestion
    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestions(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
