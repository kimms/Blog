package kr.co.blog.board.boardMaster;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blog.board.boardMaster.vo.BoardMasterVO;
import kr.co.blog.common.base.CommonService;

@Service
public class BoardMasterServiceImpl extends CommonService implements BoardMasterService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardMasterService.class);
	
	@Autowired
	private BoardMasterDAO boardDao;
	
	@Override
	public boolean createBoard(BoardMasterVO boardVO) throws Exception {
		return boardDao.insertBoard(boardVO);
	}
	
	@Override
	public List<BoardMasterVO> getBoards() throws Exception {
		LOGGER.debug("[DEBUG]select list");
		return boardDao.selectBoardList();
	}
	
	@Override
	public boolean modifyBoard(BoardMasterVO boardVO) throws Exception {
		return boardDao.updateBoard(boardVO);
	}
	
	@Override
	public boolean removeBoard(String boardId) throws Exception {
		return boardDao.deleteBoard(boardId);
	}

}
