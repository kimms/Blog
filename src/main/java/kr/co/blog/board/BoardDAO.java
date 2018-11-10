package kr.co.blog.board;

import java.util.List;

import kr.co.blog.board.vo.BoardVO;

public interface BoardDAO {
	
	public boolean insertBoard(BoardVO boardVO);
	
	public List<BoardVO> selectBoardList();
	
	public BoardVO selectBoard(String BoardId);
	
	public boolean updateBoard(BoardVO boardVO);
	
	public boolean deleteBoard(String boardId);

}
