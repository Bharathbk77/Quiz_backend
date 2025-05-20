package com.quiz_app_backend.quiz_app_backend.model;

import java.util.Map;

public class SubmitQuizRequest {
    private String technology;
    private Map<Long, Long> answers; // questionId -> selectedOptionId

    // getters and setters
    public String getTechnology() { return technology; }
    public void setTechnology(String technology) { this.technology = technology; }
    public Map<Long, Long> getAnswers() { return answers; }
    public void setAnswers(Map<Long, Long> answers) { this.answers = answers; }
}