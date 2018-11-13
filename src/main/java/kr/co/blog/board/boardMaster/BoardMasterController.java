package kr.co.blog.board.boardMaster;

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
import kr.co.blog.board.boardMaster.vo.BoardMasterVO;
import kr.co.blog.common.base.CommonController;
import kr.co.blog.common.error.CommonException;
import kr.co.blog.common.response.CommonResultDataVO;
import kr.co.blog.common.response.ResponseVO;

@Api(tags = "보드마스터 API")
@RestController

public class BoardMasterController extends CommonController {
	
	@Autowired
	private BoardMasterService boardMasterService;
	
	@ApiOperation(value = "등록")
	@RequestMapping(value = "/createBoardMaster", method = RequestMethod.POST, produces = "application/json")
	public ResponseVO<CommonResultDataVO> createBoardMaster(@RequestBody BoardMasterVO boardVO) {
		boolean result = false;
		
		try {
			result = boardMasterService.createBoard(boardVO);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		
		return super.makeResponseData(HttpStatus.OK, result ? super.getSuccessCode() : super.getFailCode());
	}
	
	@ApiOperation(value = "리스트조회")
	@RequestMapping(value = "/selectBoardMasters", method = RequestMethod.GET, produces = "application/json")
	public ResponseVO<BoardMasterVO> getBoard() {
		List<BoardMasterVO> result = null;
		
		try {
			result = boardMasterService.getBoards();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result);
	}
	
	@ApiOperation(value = "수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardId", value = "보드 아이디", dataType = "String", paramType = "path", required = true)
	})
	@RequestMapping(value = "/updateBoardMaster/{boardId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseVO<CommonResultDataVO> ModifyBoard(@PathVariable String boardId, @RequestBody BoardMasterVO boardVO) {
		boolean result = false;
		
		try {
			boardVO.setBoardId(boardId);
			result = boardMasterService.modifyBoard(boardVO);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result ? super.getSuccessCode() : super.getFailCode());
	}
	
	@ApiOperation(value = "삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardId", value = "보드아이디", dataType = "String", paramType = "path", required = true)
	})
	@RequestMapping(value = "/deleteBoardMaster/{boardId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseVO<CommonResultDataVO> removeBoard(@PathVariable String boardId) {
		boolean result = false;
		
		try {
			result = boardMasterService.removeBoard(boardId);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result ? super.getSuccessCode() : super.getFailCode());
	}
	
}
