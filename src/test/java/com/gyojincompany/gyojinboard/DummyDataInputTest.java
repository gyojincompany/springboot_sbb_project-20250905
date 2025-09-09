package com.gyojincompany.gyojinboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gyojincompany.gyojinboard.question.QuestionService;

@SpringBootTest
public class DummyDataInputTest {
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	public void testDummy() {
		for(int i=1;i<=300;i++) { //300개의 질문 더미 데이터 생성
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "연습 내용 더미데이터 입니다.";
			questionService.create(subject, content, null);
		}
		
	}

}
