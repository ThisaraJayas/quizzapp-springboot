package com.quizzapp.quizzapp.service;

import com.quizzapp.quizzapp.Question;
import com.quizzapp.quizzapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }
}
