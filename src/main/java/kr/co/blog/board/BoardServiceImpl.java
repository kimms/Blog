package kr.co.blog.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blog.board.vo.BoardVO;
import kr.co.blog.common.base.CommonService;

@Service
public class BoardServiceImpl extends CommonService implements BoardService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	private BoardDAO boardDao;
	
	
	
	@Override
	public boolean createBoard(BoardVO boardVO) throws Exception {
		return boardDao.insertBoard(boardVO);
	}
	
	@Override
	public List<BoardVO> getBoards() throws Exception {
		LOGGER.debug("[DEBUG]select list");
		return boardDao.selectBoardList();
	}
	
	@Override
	public BoardVO getBoard(String postId) throws Exception {
		BoardVO boardVO = boardDao.selectBoard(postId);
		boardDao.updateSelectCount(postId);
		
		return boardVO;
	}
	
	@Override
	public boolean modifyBoard(BoardVO boardVO) throws Exception {
		return boardDao.updateBoard(boardVO);
	}
	
	@Override
	public boolean removeBoard(String boardId) throws Exception {
		return boardDao.deleteBoard(boardId);
	}

}
