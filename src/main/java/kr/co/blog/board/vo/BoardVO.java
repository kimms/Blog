package kr.co.blog.board.vo;

import io.swagger.annotations.ApiModelProperty;

public class BoardVO{
	
	@ApiModelProperty(value = "보드 아이디", example = "0001")
	private String boardId;
	@ApiModelProperty(value = "보드 이름", example = "테스트 보드")
	private String boardName;
	private String title;
	private String postId;
	private int selectCount;
	private String content;
	
	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public int getSelectCount() {
		return selectCount;
	}
	public void setSelectCount(int selectCount) {
		this.selectCount = selectCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
