package com.quiz_app_backend.quiz_app_backend.model;

import java.util.List;

public class Technology {
    private String technology;
    private List<Question> questions;

    // getters and setters
    public String getTechnology() { return technology; }
    public void setTechnology(String technology) { this.technology = technology; }
    public List<Question> getQuestions() { return questions; }
    public void setQuestions(List<Question> questions) { this.questions = questions; }
}