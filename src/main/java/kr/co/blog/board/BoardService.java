package kr.co.blog.board;

import java.util.List;

import kr.co.blog.board.vo.BoardVO;

public interface BoardService {
	
	public boolean createBoard(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> getBoards() throws Exception;
	
	public BoardVO getBoard(String boardId) throws Exception;
	
	public boolean modifyBoard(BoardVO boardVO) throws Exception;
	
	public boolean removeBoard(String boardId) throws Exception;

}
