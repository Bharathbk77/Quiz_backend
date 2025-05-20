package com.quiz_app_backend.quiz_app_backend.controller;

import com.quiz_app_backend.quiz_app_backend.model.*;
import com.quiz_app_backend.quiz_app_backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/technologies")
    public List<String> getTechnologies() {
        return quizService.getAllTechnologies();
    }


    @GetMapping("/questions/{technology}")
    public List<Question> getQuestions(@PathVariable String technology) {
        return quizService.getQuestionsByTechnology(technology);
    }

    @PostMapping("/submit")
    public Map<String, Object> submitQuiz(@RequestBody SubmitQuizRequest request) {
        return quizService.calculateScore(request);
    }
}

