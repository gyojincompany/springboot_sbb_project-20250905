package com.gyojincompany.gyojinboard.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	public Question findBySubject(String subject); //Subject->테이블에 존재해야 하는 필드이름
	//Select * From Question Where Subject=?
	public Question findBySubjectAndContent(String subject, String content);
	//Select * From Question Where Subject=? And Content=?
	public List<Question> findBySubjectLike(String keyword); //제목에 특정 단어가 포함된 레코드 반환
	//Select * From Question Where Subject Like %?%
	
	//페이징 관련
	//TODO:public Page<Question> findAll(Pageable pageable);
	@Query(
		      value = "SELECT * FROM ( " +
		              " SELECT q.*, ROWNUM rnum FROM ( " +
		              "   SELECT * FROM question ORDER BY createdate DESC " +
		              " ) q WHERE ROWNUM <= :endRow " +
		              ") WHERE rnum > :startRow",
		      nativeQuery = true)
    List<Question> findQuestionsWithPaging(@Param("startRow") int startRow,
                                           @Param("endRow") int endRow);	
	
}
