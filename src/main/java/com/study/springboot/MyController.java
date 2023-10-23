package com.study.springboot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.dto.BoardDto;
import com.study.springboot.service.BoardSericeImple;

@Controller
public class MyController {

	@Autowired
	BoardSericeImple boardSericeImple;

	// 루트에 대해서 매핑해주는 @RequestMapping
	@RequestMapping("/")
	public String root() {
		System.out.println("listForm으로 리다이렉트 됨");
		return "redirect:listForm";
		// redirect 됨
	}

	// ui가 있는 애는 form으로 지정
	// 데이터를 listForm.jsp에 넣어주기 위해서는
	// request객체나 session Scope을 사용할 수 있는 Model을
	// 넣어주면 된다.
	// model.addAttribute() 를 통해 받아온 list를 넣어준다.
	// Model 객체는
	@RequestMapping("/listForm")
	public String listForm(Model model) {
		List<BoardDto> list = boardSericeImple.showList();
		model.addAttribute("list", list);

		return "listForm"; // listFrom.jsp 디스패치해줌
	}

	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm"; // writeForm.jsp를 디스패치함
	}

	@RequestMapping("/writeAction")
	public String writeAction(HttpServletRequest request) {
		String board_name = request.getParameter("board_name");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		int result = boardSericeImple.write(board_name, board_title, board_content);
		if (result == 1) {
			System.out.println("글쓰기 성공!");
			
		} else {
			System.out.println("글쓰기 실패");
		}

		return "redirect:listForm";
	}
//    <td><a href="contentForm?board_idx=${dto.board_idx}">

	@RequestMapping("/contentForm")
	public String contentForm(@RequestParam("board_idx") String board_idx, Model model) {

		BoardDto dto = boardSericeImple.viewDto(board_idx);
		model.addAttribute("dto", dto);
		return "contentForm"; // contentFrom으로 디스패치
	}

	@RequestMapping("/deleteAction")
	public String deleteAction(@RequestParam("board_idx") String board_idx ) {
		int result = boardSericeImple.delete(board_idx);
		
		if(result == 1) {
			System.out.println("글이 삭제되었어요");
		}else {
			System.out.println("글 삭제가 안되었어요");
		}
		
		return "redirect:listForm";
	}
	
	
	
	
	
	
	
	
	
}
