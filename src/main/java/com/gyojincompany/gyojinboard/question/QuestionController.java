package com.gyojincompany.gyojinboard.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {
	
//	@Autowired
//	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping(value = "/") //root 요청 처리
	public String root() {
		return "redirect:/question/list";
	}
	
	@GetMapping(value = "/question/list")
	//@ResponseBody
	public String list(Model model) {
		
		//List<Question> questionList = questionRepository.findAll(); //모든 질문글 불러오기
		List<Question> questionList = questionService.getList();
		model.addAttribute("questionList", questionList);
		
		return "question_list";
	}	
	
	@GetMapping(value = "/question/detail/{id}") //파라미터이름 없이 값만 넘어왔을때 처리
	public String detail(Model model, @PathVariable("id") Integer id) {
		
		//service에 3을 넣어서 호출
		Question question = questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail"; //타임리프 html의 이름
	}
	
	
	
	
}
