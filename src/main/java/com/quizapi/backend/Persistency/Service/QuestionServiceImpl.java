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
            Question q = findQuestion(newQuestion.getQuestion());
            if (q == null) {
                return questionRepo.save(newQuestion);
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("Question could be saved", e);
            return null;
        }
    }

    @Override
    public Question findQuestion(String question) {
        Question q = questionRepo.findByQuestion(question);
        if (q == null) {
            return null;
        }
        return q;
    }

}
