package egovframework.aptSurfer.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.aptSurfer.main.service.MainService;
/**
 * @Class Name : egovframework.aptSurfer.main.mapper.MainController
 * @Description :  aptSurfer 공통
 * @Modification Information
 * @ 
 * @ 수정일 		 수정자 		수정내용
 * @ ---------- --------- ------------------------------- 
 * @
 * @ 2023.03.03  KIM 		최초생성
 * @author KIM
 * @since 2023.03.03
 * @version 1.0.0
 * @see
 * copyright (c) KIM.inc All rights reserved.
 */
@Controller
@RequestMapping("/MainController")
public class MainController {

	@Autowired
	private MainService mainService;

	/**
	 * 화면
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/mainView")
	public String mainView(HttpServletRequest request, ModelMap model) throws Exception {

		return mainService.mainView(request, model);
	}
	
}
