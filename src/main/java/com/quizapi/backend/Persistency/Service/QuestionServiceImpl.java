package com.quizapi.backend.Persistency.Service;

import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.quizapi.backend.Persistency.Entities.Question;
import com.quizapi.backend.Persistency.Repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepo;

    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public Question findRandomQuestion() {
        try {
            Question q = questionRepo.getRandomQuestion();
            log.info("Getting Random Question: " + q);
            return q;
        } catch (Exception e) {
            log.error("Could not get random question", e);
            return null;
        }
    }

    @Override
    public LinkedList<Question> getAllQuestions() {

        return questionRepo.findAllByOrderByQuestionAsc();
    }

}
