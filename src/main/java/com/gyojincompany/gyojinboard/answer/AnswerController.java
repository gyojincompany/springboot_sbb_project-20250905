package com.gyojincompany.gyojinboard.answer;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gyojincompany.gyojinboard.question.Question;
import com.gyojincompany.gyojinboard.question.QuestionService;
import com.gyojincompany.gyojinboard.user.SiteUser;
import com.gyojincompany.gyojinboard.user.UserService;

import jakarta.validation.Valid;

@RequestMapping("/answer")
@Controller
public class AnswerController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("isAuthenticated()") //로그인한(인증 받은) 유저만 해당 메서드가 실행되게 함
	@PostMapping(value = "/create/{id}") //답변 등록 요청->오는 파라미터 값 : 부모 질문글의 번호
	public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
		Question question = questionService.getQuestion(id);
		
		//principal.getName();//로그인한 유저의 아이디 얻기		
		SiteUser siteUser = userService.getUser(principal.getName());
		//principal.getName() -> (String)session.getAttribute("sessionId");
		//->세션에 올라가 있는 로그인한 유저의 아이디 가져오기 
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("question", question);
			return "question_detail";
		}
		
		answerService.create(question, answerForm.getContent(), siteUser); //DB에 답변 등록
		
		return String.format("redirect:/question/detail/%s", id);
	}

}
