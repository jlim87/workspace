package com.board.example.dto;

import java.util.Date;

public class ReplyDTO {
	private Integer replyNo;	// 댓글 번호
	private Integer boardId;	// 게시글 번호
	private String replyContent;	// 댓글 내용
	private String replyer;	// 댓글 작성자
	private String userId;	// 댓글 작성자의 이름
	private Date regDate;	// 댓글 작성일자
	private Date modDate;	// 댓글 수정일자
	
	public Integer getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(Integer replyNo) {
		this.replyNo = replyNo;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}	
}
