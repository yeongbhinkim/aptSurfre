package egovframework.aptSurfer.mysql.testMY.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import net.sf.json.JSONObject;

public interface TESTMYService {

	/**
	 * 저장
	 * 
	 * @param param
	 * @throws Exception
	 */
	public void setTESTInfoMY(JSONObject param) throws Exception;

}
