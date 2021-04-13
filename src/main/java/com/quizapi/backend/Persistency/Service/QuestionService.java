package com.quizapi.backend.Persistency.Service;

import com.quizapi.backend.Persistency.Entities.Question;

public interface QuestionService {
    Question findQuestion(String question);

    Question findRandomQuestion();

    Question insertQuestion(Question newQuestion);
}
