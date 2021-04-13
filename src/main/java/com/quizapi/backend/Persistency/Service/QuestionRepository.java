package com.quizapi.backend.Persistency.Service;

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

    /*
     * @Query("SELECT * FROM Question ORDER BY RAND()") Question
     * getRandomQuestion();
     */

    Question findByQuestion(String question);

    void delete(Question question);

    void deleteAll();
}
