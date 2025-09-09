package com.gyojincompany.gyojinboard.answer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
	
	@NotEmpty(message = "내용은 필수 항목입니다.")
	@Size(min = 5, message = "제목은 최소 5글자 이상입니다.") //제목이 최소 5글자 이상만 허용
	private String content;
}
