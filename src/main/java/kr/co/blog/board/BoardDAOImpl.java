package kr.co.blog.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.blog.board.vo.BoardVO;
import kr.co.blog.common.base.CommonDAO;

@Repository
public class BoardDAOImpl extends CommonDAO implements BoardDAO {
	
	@Override
	public boolean insertBoard(BoardVO boardVO) {
		return true;
//		return super.getSqlSession().insert("board.baord.insertBoard", boardVO) > 0 ? true : false;
	}
	
	@Override
	public List<BoardVO> selectBoardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		return super.getSqlSession().selectList("board.board.selectBoards");
	}
	
	@Override
	public BoardVO selectBoard(String boardId) {
		Map<String, Object> params = new HashMap<>();
		params.put("postId", boardId);
		
		return super.getSqlSession().selectOne("board.board.selectBoard", params);
	}
	
	@Override
	public boolean updateBoard(BoardVO boardVO) {
		
		return true;
//		return super.getSqlSession().update("board.board.updateBoard", boardVO) > 0 ? true : false;
	}
	
	@Override
	public boolean deleteBoard(String boardId) {
		Map<String, Object> params = new HashMap<>();
		params.put("boardId", boardId);
		
		return true;
//		return super.getSqlSession().delete("board.board.deleteBoard", params) > 0 ? true : false;
	}
}
