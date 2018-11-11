package kr.co.blog.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.co.blog.board.vo.BoardVO;
import kr.co.blog.common.base.CommonController;
import kr.co.blog.common.error.CommonException;
import kr.co.blog.common.response.CommonResultDataVO;
import kr.co.blog.common.response.ResponseVO;

@Api(tags = "보드 API")
@RestController
public class BoardController extends CommonController {
	
	@Autowired
	private BoardService boardService;
	
	@ApiOperation(value = "등록")
	@RequestMapping(value = "/board", method = RequestMethod.POST, produces = "application/json")
	public ResponseVO<CommonResultDataVO> createsample(@RequestBody BoardVO boardVO) {
		boolean result = false;
		
		try {
			result = boardService.createBoard(boardVO);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		
		return super.makeResponseData(HttpStatus.OK, result ? super.getSuccessCode() : super.getFailCode());
	}
	
	@ApiOperation(value = "리스트조회")
	@RequestMapping(value = "/boards", method = RequestMethod.GET, produces = "application/json")
	public ResponseVO<BoardVO> getBoard() {
		List<BoardVO> result = null;
		
		try {
			result = boardService.getBoards();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result);
	}
	
	@ApiOperation(value = "상세 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardId", value = "보드 아이디", dataType = "String", paramType = "path", required = true)
	})
	@RequestMapping(value = "/board/{postId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseVO<BoardVO> getBoard(@PathVariable String postId) {
		BoardVO result = null;
		
		try {
			result = boardService.getBoard(postId);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result);
	}
	
	@ApiOperation(value = "수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "postId", value = "보드 아이디", dataType = "String", paramType = "path", required = true)
	})
	@RequestMapping(value = "/board/{postId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseVO<CommonResultDataVO> ModifyBoard(@PathVariable String postId, @RequestBody BoardVO boardVO) {
		boolean result = false;
		
		try {
			boardVO.setPostId(postId);
			result = boardService.modifyBoard(boardVO);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result ? super.getSuccessCode() : super.getFailCode());
	}
	
	@ApiOperation(value = "삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardId", value = "보드아이디", dataType = "String", paramType = "path", required = true)
	})
	@RequestMapping(value = "/board/{boardId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseVO<CommonResultDataVO> removeBoard(@PathVariable String boardId) {
		boolean result = false;
		
		try {
			result = boardService.removeBoard(boardId);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result ? super.getSuccessCode() : super.getFailCode());
	}
	
}
