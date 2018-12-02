package kr.co.blog.board.boardMaster;

import java.util.ArrayList;
import java.util.List;

import javax.naming.CommunicationException;

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
		String boardName = boardMasterVO.getBoardName();
	    List<String> illegalWords = new ArrayList<>();
	    	illegalWords.add("delete");
	    	illegalWords.add("drop");
	    	illegalWords.add("select");
	    	illegalWords.add("insert");
	    	illegalWords.add("update");
	    	illegalWords.add(" ");
	    	illegalWords.add(";");
	    
	    for (int i = 0; i < illegalWords.size(); i++) {
	        if(boardName.contains(illegalWords.get(i))) {
	        System.err.println("boardName에 <" + boardName + "> 단어가 포함됨");
	        throw new CommonException(BoardMasterErrorCode.INCLUDED_ILLEGAL_WORD);
	        
	    }else{
	        System.err.println("boardName에 <" + boardName + "> 단어가 포함되지 않음");
	    }}
		
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
	public List<BoardMasterVO> getBoardMasters() throws Exception {
		LOGGER.debug("[DEBUG]select list");
		return boardDao.selectBoardMasters();
	}
	
	@Override
	public BoardMasterVO getBoardMaster(String boardId) throws Exception {
		return boardDao.selectBoardMaster(boardId);
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
