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
	
	
	/*private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	String url, user, pass;
	
	public MemberDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		url = "jdbc:mysql://localhost:3309/test";
		user = "test";
		pass = "1234";
	}
	
	public MemberDTO loginCheck(String userId) throws SQLException{
		String sql = "select password from member where userId = ?";
		MemberDTO dto = new MemberDTO();
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setUserId(rs.getString("userId"));
				dto.setPassword(rs.getString("password"));
			}
		}finally {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return dto;
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
