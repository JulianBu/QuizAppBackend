package com.quizapi.backend.Controller;

import com.quizapi.backend.Persistency.Entities.Question;
import com.quizapi.backend.Persistency.Entities.Questions;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QuestionController {

    @PostMapping("quizapp/insertQuestion")
    @ResponseBody
    public ResponseEntity<Question> insertQuestion(@RequestBody Question question) {
        log.info("Question gets inserted: " + question.toString());
        return ResponseEntity.ok().build();
    }
}
