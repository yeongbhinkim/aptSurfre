package egovframework.aptSurfer.content.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.aptSurfer.content.service.ContentService;
/**
 * @Class Name : egovframework.aptSurfer.content.mapper.ContentController
 * @Description :  aptSurfer 공통
 * @Modification Information
 * @ 
 * @ 수정일 		 수정자 		수정내용
 * @ ---------- --------- ------------------------------- 
 * @
 * @ 2023.03.05  KIM 		최초생성
 * @author KIM
 * @since 2023.03.05	
 * @version 1.0.0
 * @see
 * copyright (c) KIM.inc All rights reserved.
 */
@Controller
@RequestMapping("/ContentController")
public class ContentController {

	@Autowired
	private ContentService contentService;

	/**
	 * 화면
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/contentView")
	public String contentView(HttpServletRequest request, ModelMap model) throws Exception {

		return contentService.contentView(request, model);
	}

}
