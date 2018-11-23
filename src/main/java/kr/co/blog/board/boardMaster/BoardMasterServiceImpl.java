package kr.co.blog.board.boardMaster;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blog.board.boardMaster.error.BoardMasterErrorCode;
import kr.co.blog.board.boardMaster.vo.BoardMasterVO;
import kr.co.blog.common.base.CommonService;
import kr.co.blog.common.error.CommonErrorCode;
import kr.co.blog.common.error.CommonException;

@Service
public class BoardMasterServiceImpl extends CommonService implements BoardMasterService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardMasterService.class);
	
	@Autowired
	private BoardMasterDAO boardDao;
	
	@Override
	public boolean createBoard(BoardMasterVO boardMasterVO) throws Exception {
		
		boolean result = false;
		
		// TODO 금지단어 검증
		
		// 게시판 명 중복 체크
		if(boardDao.selectBoardNameDuplicate(boardMasterVO)) {
			System.err.println("이름 중복");
			throw new CommonException(BoardMasterErrorCode.BOARD_NAME_IS_DUPLICATE);
		}
		
		// 게시판 정보 등록
		result = boardDao.insertBoard(boardMasterVO);
		if(!result) {
			throw new CommonException(CommonErrorCode.INTERNAL_SERVER_ERROR);
		}
		
		// 게시판 테이블 생성
		boardDao.createBoardTable(boardMasterVO);
		
		// 댓글 테이블 생성
		boardDao.createReplyTable(boardMasterVO);
		
		return true;
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
