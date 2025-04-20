package com.learning.quizapp.service;

import com.learning.quizapp.DAO.QuestionDao;
import com.learning.quizapp.DAO.QuizDao;
import com.learning.quizapp.model.Question;
import com.learning.quizapp.model.QuestionWrapper;
import com.learning.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title){
        List<Question> question = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(question);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success!", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        if(quiz.isPresent()) {
            List<Question> questionFromDB = quiz.get().getQuestion();

            for (Question q : questionFromDB) {
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                questionsForUser.add(qw);
            }
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }
}
