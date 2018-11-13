package kr.co.blog.board.boardMaster;

import java.util.List;

import kr.co.blog.board.boardMaster.vo.BoardMasterVO;

public interface BoardMasterDAO {

	public boolean insertBoard(BoardMasterVO boardVO);
	
	public List<BoardMasterVO> selectBoardList();
	
//	public BoardMasterVO selectBoard(String boardId);
	
	public boolean updateBoard(BoardMasterVO boardVO);
	
	public boolean deleteBoard(String boardId);
	
}
