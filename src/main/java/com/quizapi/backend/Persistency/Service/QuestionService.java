package com.quizapi.backend.Persistency.Service;

import com.quizapi.backend.Persistency.Entities.Question;

public interface QuestionService {
    Question insertQuestion(Question newQuestion);
}
