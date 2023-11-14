package egovframework.aptSurfer.content.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

/**
 * @Class Name : egovframework.aptSurfer.content.mapper.ContentService
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

public interface ContentService {

	/**
	 * 화면
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String contentView(HttpServletRequest request, ModelMap model) throws Exception;

}
