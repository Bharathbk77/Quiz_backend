package com.quiz_app_backend.quiz_app_backend.service;

import com.quiz_app_backend.quiz_app_backend.model.Question;
import com.quiz_app_backend.quiz_app_backend.model.SubmitQuizRequest;
import com.quiz_app_backend.quiz_app_backend.model.Technology;
import com.quiz_app_backend.quiz_app_backend.util.QuizDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    private QuizDataLoader dataLoader;

    // Returns all available technologies
    public List<String> getAllTechnologies() {
        List<Technology> techList = dataLoader.getTechnologies();
        if (techList == null) {
            return Collections.emptyList();
        }
        List<String> technologies = new ArrayList<>();
        for (Technology t : techList) {
            technologies.add(t.getTechnology());
        }
        return technologies;
    }

    // Returns all questions for a given technology
    public List<Question> getQuestionsByTechnology(String technology) {
        return dataLoader.getTechnologies().stream()
                .filter(t -> t.getTechnology().equalsIgnoreCase(technology))
                .findFirst()
                .map(Technology::getQuestions)
                .orElse(Collections.emptyList());
    }

    // Calculates score based on submitted answers
    public Map<String, Object> calculateScore(SubmitQuizRequest request) {
        List<Question> questions = getQuestionsByTechnology(request.getTechnology());
        int score = 0;

        for (Question q : questions) {
            Long submitted = request.getAnswers().get(q.getId());
            if (submitted != null && submitted.equals(q.getCorrectOptionId())) {
                score++;
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("score", score);
        result.put("total", questions.size());
        return result;
    }
}
