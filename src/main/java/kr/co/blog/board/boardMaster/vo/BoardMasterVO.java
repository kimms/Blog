package kr.co.blog.board.boardMaster.vo;

import java.util.Date;

public class BoardMasterVO {
	
	private String boardId;
	private String boardName;
	private String boardDesc;
	private Date createDate;
	private Date modifyDate;
	
	
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardDesc() {
		return boardDesc;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public void setBoardDesc(String boardDesc) {
		this.boardDesc = boardDesc;
	}

}
