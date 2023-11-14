package egovframework.aptSurfer.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.aptSurfer.home.service.HomeService;
import net.sf.json.JSONObject;
/**
 * @Class Name : egovframework.aptSurfer.home.mapper.HomeController
 * @Description :  aptSurfer 공통
 * @Modification Information
 * @ 
 * @ 수정일 		 수정자 		수정내용
 * @ ---------- --------- ------------------------------- 
 * @
 * @ 2023.02.27  KIM 		최초생성
 * @author KIM
 * @since 2023.02.27
 * @version 1.0.0
 * @see
 * copyright (c) KIM.inc All rights reserved.
 */

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private HomeService homeService;
	
	/**
	 * 화면
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/homeView")
	public String homeView(HttpServletRequest request, ModelMap model) throws Exception {
		
		return homeService.homeView(request, model);
	}

	/**
	 * 시군구 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRegionCounty")
	@ResponseBody
	public List<JSONObject> getRegionCounty(@RequestBody JSONObject param) throws Exception {
		
		return homeService.getRegionCounty(param);
	}
	
	/**
	 * 읍면동 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRegionDistricts")
	@ResponseBody
	public List<JSONObject> getRegionDistricts(@RequestBody JSONObject param) throws Exception {
		
		return homeService.getRegionDistricts(param);
	}

}
