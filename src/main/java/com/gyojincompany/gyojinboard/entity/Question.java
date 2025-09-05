package com.gyojincompany.gyojinboard.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //DB 테이블과 매핑할 entity 클래스로 설정
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //질문게시판의 글번호(기본키-자동증가 옵션)
	
	@Column(length = 200) //질문게시판의 제목은 200자 까지 가능
	private String subject; //질문게시판의 제목
	
	@Column(columnDefinition = "TEXT")
	private String content; //질문게시판의 내용
	
	@CreatedDate
	private LocalDateTime createDate;
	
	//1:N 관계->질문:답변들->@OneToMany
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	//cascade->질문글(부모글)이 삭제될 경우 답변들(자식글들)이 함께 삭제되게 하는 설정
	private List<Answer> answerList;

}
