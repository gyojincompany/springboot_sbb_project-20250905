package com.gyojincompany.gyojinboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.gyojinboard.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
