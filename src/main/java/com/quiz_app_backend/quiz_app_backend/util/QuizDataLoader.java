package com.quiz_app_backend.quiz_app_backend.util;


import com.quiz_app_backend.quiz_app_backend.model.Technology;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;



import java.io.InputStream;
import java.util.List;

@Component
public class QuizDataLoader {
    private List<Technology> technologies;

    @PostConstruct
    public void loadData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getClassLoader().getResourceAsStream("quiz-data.json");
            technologies = mapper.readValue(is, new TypeReference<List<Technology>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }
}
