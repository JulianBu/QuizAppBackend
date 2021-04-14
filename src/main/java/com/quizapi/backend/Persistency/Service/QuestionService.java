package com.quizapi.backend.Persistency.Service;

import java.util.LinkedList;

import com.quizapi.backend.Persistency.Entities.Question;

public interface QuestionService {
    Question findQuestion(String question);

    Question findRandomQuestion();

    Question insertQuestion(Question newQuestion);

    LinkedList<Question> getAllQuestions();
}
