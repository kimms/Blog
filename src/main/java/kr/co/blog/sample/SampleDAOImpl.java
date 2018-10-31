package kr.co.blog.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.blog.common.base.CommonDAO;
import kr.co.blog.sample.vo.SampleVO;

@Repository
public class SampleDAOImpl extends CommonDAO implements SampleDAO{

	@Override
	public boolean insertSample(SampleVO sampleVO) {
		return super.getSqlSession().insert("sample.sample.insertSample", sampleVO) > 0 ? true : false;
	}
	
	@Override
	public List<SampleVO> selectSampleList() {
		return super.getSqlSession().selectList("sample.sample.selectSample");
	}
	
	@Override
	public SampleVO selectSample(String sampleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("sampleId", sampleId);
		
		return super.getSqlSession().selectOne("sample.sample.selectSample", params);
	}
	
	@Override
	public boolean updateSample(SampleVO sampleVO) {
		return super.getSqlSession().update("sample.sample.updateSample", sampleVO) > 0 ? true : false;
	}
	
	@Override
	public boolean deleteSample(String sampleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("sampleId", sampleId);
		
		return super.getSqlSession().delete("sample.sample.deleteSample", params) > 0 ? true : false;
	}
}
