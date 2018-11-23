package kr.co.blog.board.boardMaster;

import java.util.List;

import kr.co.blog.board.boardMaster.vo.BoardMasterVO;

public interface BoardMasterDAO {
	
	public boolean selectBoardNameDuplicate(BoardMasterVO boardMasterVO);
	
	public boolean createBoardTable(BoardMasterVO boardMasterVO);
	
	public boolean createReplyTable(BoardMasterVO boardMasterVO);

	public boolean insertBoard(BoardMasterVO boardVO);
	
	public List<BoardMasterVO> selectBoardMasters();
	
	public BoardMasterVO selectBoardMaster(String boardId);
	
	public boolean updateBoard(BoardMasterVO boardVO);
	
	public boolean deleteBoard(String boardId);
	
}
