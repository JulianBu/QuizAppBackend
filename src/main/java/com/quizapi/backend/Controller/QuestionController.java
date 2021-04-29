package com.quizapi.backend.Controller;

import java.util.LinkedList;

import com.quizapi.backend.Persistency.Entities.Question;
import com.quizapi.backend.Persistency.Service.QuestionService;
import com.quizapi.backend.Utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = Constants.QUIZAPP)
public class QuestionController {

    @Autowired
    private QuestionService QuestionService;

    @PostMapping("/insertQuestion")
    @ResponseBody
    public ResponseEntity<Question> insertQuestion(@RequestBody Question question) {
        log.info("Question gets inserted: {}", question.toString());
        Question newQuestion = QuestionService.insertQuestion(question);
        if (newQuestion == null) {
            log.info("Question could not be saved.");
            return ResponseEntity.notFound().build();
        } else {
            log.info("Question is now saved. Cool!");
            return ResponseEntity.ok(newQuestion);
        }
    }

    @GetMapping("/get-question")
    @ResponseBody
    public ResponseEntity<Question> getQuestion() {
        Question q = QuestionService.findRandomQuestion();
        log.info("The Question: {}", q);
        return ResponseEntity.ok(q);

    }

    @GetMapping("/get-all-questions")
    @ResponseBody
    public ResponseEntity<LinkedList<Question>> getAllQuestions() {
        LinkedList<Question> questions = QuestionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }
}
