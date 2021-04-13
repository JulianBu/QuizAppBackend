package com.quizapi.backend.Controller;

import com.quizapi.backend.Persistency.Entities.Question;
import com.quizapi.backend.Persistency.Service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QuestionController {

    @Autowired
    private QuestionService QuestionService;

    @PostMapping("quizapp/insertQuestion")
    @ResponseBody
    public ResponseEntity<Question> insertQuestion(@RequestBody Question question) {
        log.info("Question gets inserted: " + question.toString());
        Question newQuestion = QuestionService.insertQuestion(question);
        if (newQuestion == null) {
            log.info("Question could not be saved");
            return ResponseEntity.notFound().build();
        } else {
            log.info("Question is now saved. Cool!");
            return ResponseEntity.ok(newQuestion);
        }
    }

    @GetMapping("quizapp/get-question")
    @ResponseBody
    public ResponseEntity<Question> getQuestion() {
        Question q = QuestionService.findRandomQuestion();
        return ResponseEntity.ok().build();
        
    }
}
