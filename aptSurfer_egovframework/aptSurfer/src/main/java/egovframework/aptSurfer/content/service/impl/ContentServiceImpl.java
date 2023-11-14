package egovframework.aptSurfer.content.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import egovframework.aptSurfer.cmmn.util.DevUtil;
import egovframework.aptSurfer.content.mapper.ContentMapper;
import egovframework.aptSurfer.content.service.ContentService;
import net.sf.json.JSONObject;
/**
 * @Class Name : egovframework.aptSurfer.content.mapper.contentServiceImpl
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
@Service("ContentService")
public class ContentServiceImpl implements ContentService {


	// 수입검사요청 맵퍼
	@Autowired
	private ContentMapper contentMapper;

	/**
	 * 화면
	 */
	@Override
	public String contentView(HttpServletRequest request, ModelMap model) throws Exception {

		JSONObject PARAM_INFO = DevUtil.getJsonFromRequestParameter(request);
		
		model.addAttribute("myHomePriceListForm", contentMapper.selectMyHomePriceDetailForm(PARAM_INFO));
		model.addAttribute("list", contentMapper.selectMyHomePriceDetail(PARAM_INFO));
	    model.addAttribute("chart", contentMapper.selectMyHomePriceScatterChart(PARAM_INFO));
	    
//	    System.out.println("PARAM_INFO = " + PARAM_INFO);
//	    System.out.println("myHomePriceListForm = " + contentMapper.selectMyHomePriceDetailForm(PARAM_INFO));
//	    System.out.println("list = " + contentMapper.selectMyHomePriceDetail(PARAM_INFO));
//	    System.out.println("chart = " + contentMapper.selectMyHomePriceScatterChart(PARAM_INFO));
		
		return "/content/contentView";
	}

}
