package kr.co.blog.board.boardMaster;

import java.util.List;

import kr.co.blog.board.boardMaster.vo.BoardMasterVO;

public interface BoardMasterService {

	public boolean createBoard(BoardMasterVO boardVO) throws Exception;
	
	public List<BoardMasterVO> getBoardMasters() throws Exception;
	
	public BoardMasterVO getBoardMaster(String boardId) throws Exception;
	
	public boolean modifyBoard(BoardMasterVO boardVO) throws Exception;
	
	public boolean removeBoard(String boardId) throws Exception;
	
}
