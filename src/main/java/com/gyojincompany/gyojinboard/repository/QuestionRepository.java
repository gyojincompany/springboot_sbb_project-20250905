package com.gyojincompany.gyojinboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.gyojinboard.entity.Question;
import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	public Question findBySubject(String subject); //Subject->테이블에 존재해야 하는 필드이름
	//Select * From Question Where Subject=?
	public Question findBySubjectAndContent(String subject, String content);
	//Select * From Question Where Subject=? And Content=?
	public List<Question> findBySubjectLike(String keyword); //제목에 특정 단어가 포함된 레코드 반환
	//Select * From Question Where Subject Like %?%
	
	
}
