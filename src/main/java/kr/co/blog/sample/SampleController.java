package kr.co.blog.sample;

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
import kr.co.blog.common.base.CommonController;
import kr.co.blog.common.error.CommonException;
import kr.co.blog.common.response.CommonResultDataVO;
import kr.co.blog.common.response.ResponseVO;
import kr.co.blog.sample.vo.SampleVO;

@Api(tags = "샘플 API")
@RestController
public class SampleController extends CommonController{
	
	@Autowired
	private SampleService sampleService;
	
	@ApiOperation(value = "등록")
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseVO<CommonResultDataVO> createSample(@RequestBody SampleVO sampleVO) {
		boolean result = false;

		try {
			result = sampleService.createSample(sampleVO);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		
		return super.makeResponseData(HttpStatus.OK, result ? super.getSuccessCode() : super.getFailCode());
	}
	
	@ApiOperation(value = "리스트 조회")
	@RequestMapping(value = "/selectlist", method = RequestMethod.GET, produces = "application/json")
	public ResponseVO<SampleVO> getSamples() {
		List<SampleVO> result = null;
		
		try {
			result = sampleService.getSamples();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result);
	}
	
	@ApiOperation(value = "상세 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "sampleId", value = "샘플 아이디", dataType = "String", paramType = "path", required = true)
	})
	@RequestMapping(value = "/select/{sampleId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseVO<SampleVO> getSample(@PathVariable String sampleId) {
		SampleVO result = null;
		
		try {
			result = sampleService.getSample(sampleId);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result);
	}
	
	@ApiOperation(value = "수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "sampleId", value = "샘플 아이디", dataType = "String", paramType = "path", required = true)
	})
	@RequestMapping(value = "/modify/{sampleId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseVO<CommonResultDataVO> modifySample(@PathVariable String sampleId, @RequestBody SampleVO sampleVO) {
		boolean result = false;
		
		try {
			sampleVO.setSampleId(sampleId);
			result = sampleService.modifySample(sampleVO);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result ? super.getSuccessCode() : super.getFailCode());
	}
	
	@ApiOperation(value = "삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "sampleId", value = "샘플 아이디", dataType = "String", paramType = "path", required = true)
	})
	@RequestMapping(value = "/delete/{sampleId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseVO<CommonResultDataVO> removeSample(@PathVariable String sampleId) {
		boolean result = false;
		
		try {
			result = sampleService.removeSample(sampleId);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		return super.makeResponseData(HttpStatus.OK, result ? super.getSuccessCode() : super.getFailCode());
	}
	
}
