package com.gyojincompany.gyojinboard;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gyojincompany.gyojinboard.question.Question;
import com.gyojincompany.gyojinboard.question.QuestionRepository;

@SpringBootTest
public class PagingTest {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	public void list() {
		List<Question> qList = questionRepository.findQuestionsWithPaging(1, 10);
		
		System.out.println(qList.size());
		for(Question question: qList) {
			System.out.println(question.getId());
		}
	}

}
