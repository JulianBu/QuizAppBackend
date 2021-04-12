package com.quizapi.backend.Persistency.Service;

import com.quizapi.backend.Persistency.Entities.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepo;

    @Override
    public Question insertQuestion(Question newQuestion) {
        try {
            log.info("Insert Question: " + newQuestion.getQuestion());
            return questionRepo.save(newQuestion);

        } catch (Exception e) {
            log.error("Question could be saved", e);
            return null;
        }
    }

}
