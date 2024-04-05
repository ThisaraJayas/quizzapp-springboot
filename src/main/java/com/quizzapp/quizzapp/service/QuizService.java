package com.quizzapp.quizzapp.service;

import com.quizzapp.quizzapp.dao.QuestionDao;
import com.quizzapp.quizzapp.dao.QuizDao;
import com.quizzapp.quizzapp.model.Question;
import com.quizzapp.quizzapp.model.QuestionWrapper;
import com.quizzapp.quizzapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestion, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,noOfQuestion);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("SUccess", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFormDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q : questionsFormDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }
}
