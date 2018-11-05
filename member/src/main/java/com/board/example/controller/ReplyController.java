package com.board.example.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.board.example.dto.ReplyDTO;
import com.board.example.service.ReplyService;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	ReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(@ModelAttribute ReplyDTO dto, HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		dto.setReplyer(userId);
		replyService.write(dto);
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam int boardId, ModelAndView mav) {
		List<ReplyDTO> list = replyService.list(boardId);
		mav.setViewName("board/replyList");
		mav.addObject("list",list);
		return mav;
	}
	
	@RequestMapping("listJson.do")
	@ResponseBody
	public List<ReplyDTO> listJson(@RequestParam int boardId){
		List<ReplyDTO> list = replyService.list(boardId);
		return list;
	}	
	
	
}
