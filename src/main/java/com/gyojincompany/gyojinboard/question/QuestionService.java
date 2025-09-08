package com.gyojincompany.gyojinboard.question;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
//	@Autowired
	private final QuestionRepository questionRepository; 
	// @RequiredArgsConstructor에 의해 생성자 방식으로 주입된 questionRepostitory(final 필드만 가능)
	
	public List<Question> getList() { //모든 질문글 가져오기
		return questionRepository.findAll();
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> qOptional = questionRepository.findById(id);
		
		if(qOptional.isPresent()) {
			return qOptional.get(); //question 반환
		} else {
			throw new DataNotFoundException("question not found");
		}
		
	}
	
}
