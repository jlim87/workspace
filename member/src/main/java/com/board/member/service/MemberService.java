package com.board.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.member.dao.MemberDAO;
import com.board.member.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	MemberDAO memberDao;
	
	public boolean loginCheck(MemberDTO dto, HttpSession session) {
		boolean result = memberDao.loginCheck(dto);
		if(result) {
			MemberDTO dto2 = viewMember(dto);
			session.setAttribute("userId", dto2.getUserId());
		}
		return result;
	}
	
	public MemberDTO viewMember(MemberDTO dto) {
		return memberDao.viewMember(dto);
	}
	
	public void logout(HttpSession session) {
		session.invalidate();
	}
		
}
