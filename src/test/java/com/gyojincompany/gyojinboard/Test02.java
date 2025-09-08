package com.gyojincompany.gyojinboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.gyojincompany.gyojinboard.answer.Answer;
import com.gyojincompany.gyojinboard.answer.AnswerRepository;
import com.gyojincompany.gyojinboard.question.Question;
import com.gyojincompany.gyojinboard.question.QuestionRepository;

@SpringBootTest
public class Test02 {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
//	@Test
//	@DisplayName("질문 게시판 제목 수정하기")	
//	public void testJpa1() {
//		Optional<Question> optionalQuestion = questionRepository.findById(2); //기본키 글번호가 2번인 레코드를 반환
//		assertTrue(optionalQuestion.isPresent()); //기본키로 가져온 레코드가 존재하면 true->테스트 통과
//		//기본키로 가져온 레코드가 존재하지 않으면 false->테스트 종료(테스트 실패)
//		Question question = optionalQuestion.get();
//		question.setSubject("수정된 제목!!!!");
//		
//		this.questionRepository.save(question);
//	}
	
//	@Test
//	@DisplayName("질문 게시판 글 삭제하기 테스트")	
//	public void testJpa2() {
//		assertEquals(2, questionRepository.count());
//		//questionRepository.count()->모든 행(레코드)의 갯수를 반환
//		Optional<Question> QOptional = questionRepository.findById(2); //2번글 가져오기
//		assertTrue(QOptional.isPresent()); //2번글의 존재 여부 테스트
//		Question question = QOptional.get();
//		questionRepository.delete(question); //delete(엔티티)->해당 글이 삭제
//		assertEquals(1, questionRepository.count());
//	}
	
//	@Test
//	@DisplayName("답변 게시판 글 생성하기")	
//	public void testJpa3() {
//		//답변->질문글의 번호를 준비
//		Optional<Question> QOptional = questionRepository.findById(3);
//		assertTrue(QOptional.isPresent());
//		Question question = QOptional.get();
//		
//		Answer answer = new Answer();
//		answer.setContent("네 자동으로 생성됩니다."); //답변 내용 넣어주기
//		answer.setCreatedate(LocalDateTime.now()); //현재 시간 넣어주기
//		answer.setQuestion(question); //답변이 달릴 질문글 필드로 넣어주기
//		answerRepository.save(answer);
//	}

//	@Test
//	@DisplayName("답변 게시판 글 조회하기")	
//	public void testJpa4() {
//		Optional<Answer> aOptional = answerRepository.findById(1); //답변 글 테이블에서 1번 글 가져오기
//		assertTrue(aOptional.isPresent()); //해당 글 번호의 답변이 존재하는지 확인 테스트
//		
//		Answer answer = aOptional.get();
//		assertEquals(3, answer.getQuestion().getId()); //부모 질문글의 번호로 확인 테스트		
//		
//	}
	
	@Test
	@DisplayName("질문 글을 통해 답변 글들 조회하기")	
	@Transactional
	public void testJpa5() {
		//질문 글 가져오기(3번 질문 글)
		Optional<Question> qOptional = questionRepository.findById(3);
		assertTrue(qOptional.isPresent());
		Question question = qOptional.get();
		
		List<Answer> answerList = question.getAnswerList(); //해당 질문글에 달린 답변들의 리스트	
		//게으른 초기화문제로 오류->question entity 가 닫힌 후에 초기화를 시도
		//테스트 과정에서만 발생->@Transactional로 에러는 막을 수 있음
		
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
		
	}
	
	
}
