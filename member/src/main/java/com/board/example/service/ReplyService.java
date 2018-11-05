package com.board.example.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.example.dao.ReplyDAO;
import com.board.example.dto.ReplyDTO;

@Service
public class ReplyService {
	
	@Inject
	ReplyDAO replyDao;
	
	public List<ReplyDTO> list(Integer boardId){
		return replyDao.list(boardId);
	}
	
	public void write(ReplyDTO dto) {
		replyDao.write(dto);
	}
	
	public void delete(Integer replyNo) {
		replyDao.delete(replyNo);
	}
	
}
