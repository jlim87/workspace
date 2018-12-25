package com.board.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.example.dto.BoardDTO;

@Repository
public class BoardDAOImpl {
	@Autowired
	SqlSession sqlSession;	
	// 게시판 목록 불러오기
	public List<BoardDTO> boardList() throws Exception {
		return sqlSession.selectList("board.boardList"); 
	}
	// 게시물 작성
	public void write(BoardDTO dto) throws Exception {
		sqlSession.insert("board.write", dto);
	}
	// 게시물 상세내용
	public BoardDTO view(int boardId) throws Exception {
		return sqlSession.selectOne("board.view", boardId);
	}
	public void update(BoardDTO dto) throws Exception {
		sqlSession.update("board.update", dto);
	}
	public void delete(int boardId) throws Exception {
		sqlSession.delete("board.delete", boardId);		
	}
	
	public void insertFile(Map<String, Object> map) throws Exception{
		sqlSession.insert("board.insertFile", map);
	}
	
	
	
}
