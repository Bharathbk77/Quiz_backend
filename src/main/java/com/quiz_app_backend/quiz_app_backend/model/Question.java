package com.quiz_app_backend.quiz_app_backend.model;

import java.util.List;

public class Question {
    private Long id;
    private String questionText;
    private List<Option> options;
    private Long correctOptionId;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public List<Option> getOptions() { return options; }
    public void setOptions(List<Option> options) { this.options = options; }
    public Long getCorrectOptionId() { return correctOptionId; }
    public void setCorrectOptionId(Long correctOptionId) { this.correctOptionId = correctOptionId; }
}
