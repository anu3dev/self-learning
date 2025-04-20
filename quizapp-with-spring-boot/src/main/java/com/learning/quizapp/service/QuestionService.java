package com.learning.quizapp.service;

import com.learning.quizapp.DAO.QuestionDao;
import com.learning.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao dao;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(dao.findByCategory(category), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            dao.save(question);
            return new ResponseEntity<>("Success!", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed!", HttpStatus.BAD_REQUEST);
    }
}
