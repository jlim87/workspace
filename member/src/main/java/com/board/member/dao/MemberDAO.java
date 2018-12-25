package com.board.member.dao;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public boolean loginCheck(MemberDTO dto) {
		String userId = sqlSession.selectOne("member.loginCheck", dto);
		return (userId == null) ? false : true;
	}
	
	public MemberDTO viewMember(MemberDTO dto) {
		return sqlSession.selectOne("member.viewMember", dto);
	}
	
	public void logout(HttpSession session) {
		
	}

}
