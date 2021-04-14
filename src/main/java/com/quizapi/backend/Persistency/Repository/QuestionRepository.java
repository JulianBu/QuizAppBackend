package com.quizapi.backend.Persistency.Repository;

import java.util.LinkedList;

import com.quizapi.backend.Persistency.Entities.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    LinkedList<Question> findAllByOrderByQuestionAsc();

    LinkedList<Question> findAllByOrderByQuestionDesc();

    LinkedList<Question> findAllByOrderBySeverityAsc();

    LinkedList<Question> findAllByOrderBySeverityDesc();

    LinkedList<Question> findBySeverity(int severity);

    @Query(value = "SELECT * FROM QUIZQUESTION RAND() LIMIT 1", nativeQuery = true)
    Question getRandomQuestion();

    Question findByQuestion(String question);

    void delete(Question question);

    void deleteAll();
}
