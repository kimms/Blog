package kr.co.blog.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blog.common.base.CommonService;
import kr.co.blog.sample.vo.SampleVO;

@Service
public class SampleServiceImpl extends CommonService implements SampleService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleService.class);
	
	@Autowired
	private SampleDAO sampleDao;
	
	@Override
	public boolean createSample(SampleVO sampleVO) throws Exception {
		return sampleDao.insertSample(sampleVO);
	}
	
	@Override
	public List<SampleVO> getSamples() throws Exception {
		LOGGER.debug("[DEBUG]select list");
		return sampleDao.selectSampleList();
	}
	
	@Override
	public SampleVO getSample(String sampleId) throws Exception {
		return sampleDao.selectSample(sampleId);
	}
	
	@Override
	public boolean modifySample(SampleVO sampleVO) throws Exception {
		return sampleDao.updateSample(sampleVO);
	}
	
	@Override
	public boolean removeSample(String sampleId) throws Exception {
		return sampleDao.deleteSample(sampleId);
	}
}
