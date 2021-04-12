package com.quizapi.backend.Persistency.Service;

import java.util.LinkedList;

import com.quizapi.backend.Persistency.Entities.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    LinkedList<Question> findAllByOrderByQuestionAsc();

    LinkedList<Question> findAllByOrderByQuestionDesc();

    LinkedList<Question> findAllByOrderBySeverityAsc();

    LinkedList<Question> findAllByOrderBySeverityDesc();

    LinkedList<Question> findBySeverity(int severity);

    void delete(Question question);

    void deleteAll();
}
