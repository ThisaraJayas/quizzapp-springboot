package com.quizzapp.quizzapp.dao;

import com.quizzapp.quizzapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {  //all database stuff handled by JpaRepository
                                                                         //Question - database table name, Integer - databse primary key title


    List<Question> findByCategory(String category);  //findByCategory <- Category sql will find out

    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :noOfQuestion", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int noOfQuestion);
}
