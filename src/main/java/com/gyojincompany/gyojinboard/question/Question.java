package com.gyojincompany.gyojinboard.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.gyojincompany.gyojinboard.answer.Answer;
import com.gyojincompany.gyojinboard.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //DB 테이블과 매핑할 entity 클래스로 설정
@Table(name = "question") //실제로 매핑될 데이터베이스의 테이블 이름 설정
@SequenceGenerator(
		name = "QUESTION_SEQ_GENERATOR", //JPA 내부 시퀀스 이름
		sequenceName = "QUESTION_SEQ", //실제 DB 시퀀스 이름 
		initialValue = 1, //시퀀스 시작값
		allocationSize = 1 //시퀀스 증가치
		)
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_SEQ_GENERATOR")
	private Integer id; //질문게시판의 글번호(기본키-자동증가 옵션)
	
	@Column(length = 200) //질문게시판의 제목은 200자 까지 가능
	private String subject; //질문게시판의 제목
	
	@Column(length = 500)
	private String content; //질문게시판의 내용	
	
	private LocalDateTime createdate; //질문게시판 글 등록일시
	
	//1:N 관계->질문:답변들->@OneToMany
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	//cascade->질문글(부모글)이 삭제될 경우 답변들(자식글들)이 함께 삭제되게 하는 설정
	private List<Answer> answerList;
	
	//N:1 관계->질문:작성자
	@ManyToOne
	private SiteUser author; //글쓴이(1명)
	
	private LocalDateTime modifydate; //질문 글 수정 일시
	
	//N:N 관계->질문:추천자
	@ManyToMany
	Set<SiteUser> voter; //추천한 유저가 중복 없이 여러 명의 유저가 저장->유저의 수->추천 수
	//Set->중복 제거용 컬렉션 사용->유저 한명 당 추천수 1개만 기록하기 위해
	

}
