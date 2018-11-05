package com.board.example.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.example.dto.ReplyDTO;

@Repository
public class ReplyDAO {
	@Inject
	SqlSession sqlSession;
	
	// ´ñ±Û ¸ñ·Ï
	public List<ReplyDTO> list(Integer boardId){
		return sqlSession.selectList("reply.listReply", boardId);
	}
	
	// ´ñ±Û ÀÛ¼º
	public void write(ReplyDTO dto) {
		sqlSession.insert("reply.insertReply", dto);
	}
	
	// ´ñ±Û »èÁ¦
	public void delete(Integer replyNo) {
		sqlSession.delete("reply.deleteReply", replyNo);
	}
	
	
}
