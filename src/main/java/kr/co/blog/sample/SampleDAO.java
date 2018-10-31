package kr.co.blog.sample;

import java.util.List;

import kr.co.blog.sample.vo.SampleVO;

public interface SampleDAO {
	public boolean insertSample(SampleVO sampleVO);
	
	public List<SampleVO> selectSampleList();
	
	public SampleVO selectSample(String sampleId);
	
	public boolean updateSample(SampleVO sampleVO);
	
	public boolean deleteSample(String sampleId);
}
