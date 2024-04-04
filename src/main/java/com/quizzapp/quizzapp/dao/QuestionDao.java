package com.quizzapp.quizzapp.dao;

import com.quizzapp.quizzapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {  //all database stuff handled by JpaRepository
                                                                         //Question - database table name, Integer - databse primary key title

}
