package kr.co.blog.board.boardMaster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.blog.board.boardMaster.vo.BoardMasterVO;
import kr.co.blog.common.base.CommonDAO;

@Repository
public class BoardMasterDAOImpl extends CommonDAO implements BoardMasterDAO {
	
	@Override
	public boolean selectBoardNameDuplicate(BoardMasterVO boardMasterVO) {
		int result = super.getSqlSession().selectOne("board.board.boardMasters.selectBoardNameDuplicate", boardMasterVO);
		return result > 0 ? true : false;
	}
	
	@Override
	public boolean createBoardTable(BoardMasterVO boardMasterVO) {
		super.getSqlSession().insert("board.board.boardMasters.createBoardTable", boardMasterVO);
		return true;
	}
	
	@Override
	public boolean createReplyTable(BoardMasterVO boardMasterVO) {
		super.getSqlSession().insert("board.board.boardMasters.createReplyTable", boardMasterVO);
		return true;
	}
	
	@Override
	public boolean insertBoard(BoardMasterVO boardVO) {
		return super.getSqlSession().insert("board.board.boardMasters.insertBoardMaster", boardVO) > 0 ? true : false;
	}
	
	@Override
	public List<BoardMasterVO> selectBoardMasters() {
		
		return super.getSqlSession().selectList("board.board.boardMasters.selectBoardMasters");
	}
	
	@Override
	public BoardMasterVO selectBoardMaster(String boardId) {
		Map<String, String> map = new HashMap<>();
		map.put("boardId", boardId);
		return super.getSqlSession().selectOne("board.board.boardMasters.selectBoardMaster", map);
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
