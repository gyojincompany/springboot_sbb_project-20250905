package com.gyojincompany.gyojinboard.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyojincompany.gyojinboard.DataNotFoundException;
import com.gyojincompany.gyojinboard.question.Question;
import com.gyojincompany.gyojinboard.user.SiteUser;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	public void create(Question question, String content, SiteUser author) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreatedate(LocalDateTime.now()); //현재 시간 등록(답변 등록 시간)
		answer.setQuestion(question);
		answer.setAuthor(author);
		answerRepository.save(answer);
	}
	
	public Answer getAnswer(Integer id) { //기본키인 답변 id를 인수로 넣어주면 해당 엔티티 반환
		Optional<Answer> _answer = answerRepository.findById(id); //기본키로 엔티티 조회하기
		
		if(_answer.isPresent()) {
			return _answer.get(); //->해당 answer 엔티티가 올바르게 반환
		} else {
			throw new DataNotFoundException("해당 답변이 존재하지 않습니다.");
		}
	}
	
	public void modify(Answer answer, String content) { //답변 수정하기
		answer.setContent(content);
		answer.setModifydate(LocalDateTime.now()); //답변 수정한 일시
		answerRepository.save(answer);
	}
	
	public void delete(Answer answer) { //답변 삭제하기
		answerRepository.delete(answer);
	}
}
