package kr.co.blog.sample;

import java.util.List;

import kr.co.blog.sample.vo.SampleVO;

public interface SampleService {
	public boolean createSample(SampleVO sampleVO) throws Exception;
	
	public List<SampleVO> getSamples() throws Exception;
	
	public SampleVO getSample(String sampleId) throws Exception;
	
	public boolean modifySample(SampleVO sampleVO) throws Exception;
	
	public boolean removeSample(String sampleId) throws Exception;
}
