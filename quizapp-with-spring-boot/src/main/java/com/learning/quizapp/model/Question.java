package com.learning.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;
    private String rightAnswer;
}
