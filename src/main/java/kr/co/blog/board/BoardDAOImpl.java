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
		
//		return true;
		return super.getSqlSession().insert("board.board.insertBoard", boardVO) > 0 ? true : false;
	}
	
	
	@Override
	public List<BoardVO> selectBoardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		return super.getSqlSession().selectList("board.board.selectBoards");
	}
	
	@Override
	public BoardVO selectBoard(String postId) {
//		Map<String, Object> params = new HashMap<>();
//		params.put("postId", postId);
		
		BoardVO boardVO = new BoardVO();
		boardVO.setPostId(postId);
		
		return super.getSqlSession().selectOne("board.board.selectBoard", boardVO);
	}
	
	@Override
	public boolean updateBoard(BoardVO boardVO) {
		
//		return true;
		return super.getSqlSession().update("board.board.updateBoard", boardVO) > 0 ? true : false;
	}
	
	@Override
	public boolean updateSelectCount(String postId) {
		BoardVO boardVO = new BoardVO();
		boardVO.setPostId(postId);
				
		return super.getSqlSession().update("board.board.updateSelectCount", boardVO) > 0 ? true : false;
	}
	
	@Override
	public boolean deleteBoard(String postId) {
		Map<String, Object> params = new HashMap<>();
		params.put("postId", postId);
		
		return true;
//		return super.getSqlSession().delete("board.board.deleteBoard", params) > 0 ? true : false;
	}
}
