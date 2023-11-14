package egovframework.aptSurfer.mysql.testMY.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.aptSurfer.mysql.testMY.mapper.TESTMYMapper;
import egovframework.aptSurfer.mysql.testMY.service.TESTMYService;
import net.sf.json.JSONObject;

@Service("TESTMYService")
public class TESTMYServiceImpl implements TESTMYService {

	@Autowired
	private TESTMYMapper tESTMapper;

	@Override
	public void setTESTInfoMY(JSONObject param) throws Exception {
		tESTMapper.insertTESTmy(param);

	}

}
