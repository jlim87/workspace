package com.board.example.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.board.example.dao.BoardDAOImpl;
import com.board.example.dto.BoardDTO;
import com.board.util.FileUtils;

@Service
public class BoardServiceImpl{
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	BoardDAOImpl boardDao;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	/*public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
		return boardDao.selectBoardList(map);
	}*/
	
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
        boardDao.insertFile(map);
         
        List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request);
        for(int i=0, size=list.size(); i<size; i++){
        	boardDao.insertFile(list.get(i));
        }
    }


	public List<BoardDTO> boardList() throws Exception {
		return boardDao.boardList(); 
	}

	public void write(BoardDTO dto) throws Exception {
		boardDao.write(dto);		
	}

	public BoardDTO view(int boardId) throws Exception {
		return boardDao.view(boardId);
	}

	public void update(BoardDTO dto) throws Exception {
		boardDao.update(dto);		
	}

	public void delete(int boardId) throws Exception {
		boardDao.delete(boardId);		
	}
	
	
}
