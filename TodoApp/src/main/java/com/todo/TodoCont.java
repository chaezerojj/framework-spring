package com.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

// 주소 받아서 서비스로 연결하는 역할 (코드 많이 생성하는 곳이 아님)

@Controller
@RequiredArgsConstructor
public class TodoCont {

	@Autowired
	TodoService tService;

	@GetMapping("/")
//	@RequestMapping(value = "/", method = RequestMethod.GET) // 주소 Mapping하는 또 다른 방법
	public String getTodos(Model model) {
//		for (TodoEntity tEntity : tService.getTodos()) {
//			System.out.println(tEntity);
//		}
//		List<TodoEntity> todos = tService.getTodos();
		model.addAttribute("todos", tService.getTodos());
		return "todos";
	}
	
//	get: 주소창에 데이터 노출됨
//	post: 주소창에 데이터 노출 안됨
	
	@PostMapping("/put")
//	public String putTodo(@RequestParam TodoEntity tEntity) {
	public String putTodo(TodoEntity tEntity) {
		if(tEntity.getCompleted() == null) {
			tEntity.setCompleted(false);
		}
		tService.putTodo(tEntity);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTodo(@PathVariable Integer id) {
		tService.deleteTodo(id);
		return "redirect:/";
	}
	@GetMapping("/update/{id}")
	public String updateTodo(@PathVariable Integer id, Model model) {
		// id값 이용하여 1개의 todo값 가져오기
		TodoEntity tEntity = tService.getTodo(id);
		model.addAttribute("todo", tEntity);
		return "update-todo";
	}
	
	@RequestMapping("/updateCompleted")
	public String updateCompleted(TodoEntity tEntity) {
		tEntity.setCompleted(!tEntity.getCompleted());
		tService.putTodo(tEntity);
		return "redirect:/";
	}
}
