package com.quizzapp.quizzapp.controller;

import com.quizzapp.quizzapp.Question;
import com.quizzapp.quizzapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();   //we use responseENtity to get status codes
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable  String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
