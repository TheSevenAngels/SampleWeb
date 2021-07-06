package egovframework.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleService;
import egovframework.sample.service.SampleVO;

@Service("sampleService")
public class SampleServiceImpl extends EgovAbstractServiceImpl implements SampleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);
	@Resource(name = "daoMyBatis")
	private SampleDAO sampleDAO;

	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	public void insertSample(SampleVO vo) throws Exception {
		LOGGER.trace("TRACE Level Logging");
		LOGGER.debug("DEBUG Level Logging");
		LOGGER.info("INFO Level Logging");
		LOGGER.warn("WARN Level Logging");
		LOGGER.error("ERROR Level Logging");

		String id = egovIdGnrService.getNextStringId();
		vo.setId(id);
		sampleDAO.insertSample(vo);
	}

	public void updateSample(SampleVO vo) throws Exception {
		sampleDAO.updateSample(vo);
	}

	public void deleteSample(SampleVO vo) throws Exception {
		sampleDAO.deleteSample(vo);
	}

	public SampleVO selectSample(SampleVO vo) throws Exception {
		return sampleDAO.selectSample(vo);
	}

	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		return sampleDAO.selectSampleList(vo);
	}
}