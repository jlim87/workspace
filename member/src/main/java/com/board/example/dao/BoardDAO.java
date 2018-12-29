package com.board.example.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.board.example.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	SqlSession sqlSession;	
	
	public List<BoardDTO> boardList() throws Exception {
		return sqlSession.selectList("board.boardList"); 
	}

	public void write(BoardDTO dto, HttpServletRequest request) throws Exception {
		sqlSession.insert("board.write", dto);
		
		
	}

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
