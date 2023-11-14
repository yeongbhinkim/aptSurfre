package egovframework.aptSurfer.testORA.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;
import egovframework.aptSurfer.testORA.mapper.TESTORAMapper;
import egovframework.aptSurfer.testORA.service.TESTORAService;

@Service("TESTORAService")
public class TESTORAServiceImpl implements TESTORAService {


	@Autowired
	private TESTORAMapper tESTORAMapper;

	@Override
	public void setTESTInfoORA(JSONObject param) throws Exception {
		tESTORAMapper.insertTESTora(param);
		
	}



}
