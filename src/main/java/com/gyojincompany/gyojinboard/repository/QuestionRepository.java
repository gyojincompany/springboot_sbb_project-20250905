package com.gyojincompany.gyojinboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.gyojinboard.entity.Question;
import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	public Question findBySubject(String subject);
	
}
