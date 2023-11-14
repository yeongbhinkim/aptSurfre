package egovframework.aptSurfer.testORA.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import net.sf.json.JSONObject;

public interface TESTORAService {

	/**
	 * 저장
	 * 
	 * @param param
	 * @throws Exception
	 */
	public void setTESTInfoORA(JSONObject param) throws Exception;

}
