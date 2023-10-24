package com.study.springboot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.dto.BoardDto;
import com.study.springboot.dto.ReplyDto;
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
		int hit_rs = 0;
		//조회수 증가
		hit_rs = boardSericeImple.hit(board_idx);
		if(hit_rs == 1) {
			System.out.println("조회수 증가!");
		}
		
		List<ReplyDto> r_list =  boardSericeImple.reply_list(board_idx);
		
		BoardDto dto = boardSericeImple.viewDto(board_idx);
		model.addAttribute("dto", dto);
		model.addAttribute("reply_list", r_list);
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
	
	
	@RequestMapping("/updateAction")
	@ResponseBody
	public String updateAction(HttpServletRequest request) {
		int result = 0;
		
		String board_idx = request.getParameter("board_idx");
		String board_hit = request.getParameter("board_hit");
		String board_name = request.getParameter("board_name");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		
		result = boardSericeImple.updateboard(board_idx, board_name, board_title, board_content, board_hit);
		if(result == 1) {
			System.out.println("성공적인 글수정입니다!");
			request.getSession().setAttribute("alert_message", "글 수정 성공!");
			return "<script>alert('글쓰기 성공!'); location.href='/listForm'</script>";
		}else {
			System.out.println("글수정 실패!");
			return "redirect:listForm";
		}
	}
	//댓글 등록
	@RequestMapping("/writeReplyAction")
	public String writeReplyAction(@RequestParam("board_idx") String board_idx,
								   @RequestParam("reply_content") String reply_content,
								   @RequestParam("reply_name") String reply_name) {
		boardSericeImple.replyWrite(reply_name,reply_content,board_idx);
		return "redirect:contentForm?board_idx=" + board_idx;
	}
	
	
//	deleteReplyAction?reply_idx=${reply_dto.reply_idx}&board_idx=${dto.board_idx}
	@RequestMapping("/deleteReplyAction")
	public String deleteReplyAction(@RequestParam("reply_idx") String reply_idx,
								    @RequestParam("board_idx") String board_idx) {
		boardSericeImple.deleteReply(reply_idx);
		return "redirect:contentForm?board_idx=" + board_idx;
	}
	
	
	
}
