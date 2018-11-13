package kr.co.blog.board.boardMaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.blog.board.boardMaster.vo.BoardMasterVO;
import kr.co.blog.common.base.CommonDAO;

@Repository
public class BoardMasterDAOImpl extends CommonDAO implements BoardMasterDAO {
	
	@Override
	public boolean insertBoard(BoardMasterVO boardVO) {
		
//		return true;
		return super.getSqlSession().insert("board.board.boardMaster.insertBoardMaster", boardVO) > 0 ? true : false;
	}
	
	
	@Override
	public List<BoardMasterVO> selectBoardList() {
		List<BoardMasterVO> list = new ArrayList<BoardMasterVO>();
		
		return super.getSqlSession().selectList("board.board.boardMaster.selectBoardMasters");
	}
	
	@Override
	public boolean updateBoard(BoardMasterVO boardVO) {
		
		return true;
//		return super.getSqlSession().update("board.board.boardMastser.updateBoardMaster", boardVO) > 0 ? true : false;
	
	}
	@Override
	public boolean deleteBoard(String boardId) {
		Map<String, Object> params = new HashMap<>();
		params.put("boardId", boardId);
		
		return true;
//		return super.getSqlSession().delete("board.board.deleteBoard", params) > 0 ? true : false;
	}
	
}
