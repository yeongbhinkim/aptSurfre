package egovframework.aptSurfer.main.service.impl;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import egovframework.aptSurfer.cmmn.util.DevUtil;
import egovframework.aptSurfer.main.mapper.MainMapper;
import egovframework.aptSurfer.main.service.MainService;
import egovframework.aptSurfer.paging.FindCriteria;
import net.sf.json.JSONObject;
/**
 * @Class Name : egovframework.aptSurfer.main.mapper.MainServiceImpl
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
@Service("MainService")
public class MainServiceImpl implements MainService {


	// 수입검사요청 맵퍼
	@Autowired
	private MainMapper mainMapper;
	
	@Autowired
	@Qualifier("fc5") //동일한 타입의 객체가 여러개있을때 빈이름을 명시적으로 지정해서 주입받을때
	private FindCriteria fc;

	/**
	 * 화면
	 */
	@Override
	public String mainView(HttpServletRequest request, ModelMap model) throws Exception {

			JSONObject PARAM_INFO = DevUtil.getJsonFromRequestParameter(request);
			
		    //FindCriteria 값 설정
		    fc.getRc().setReqPage(PARAM_INFO.optString("ReqPage").equals("") ? 1 :  Integer.parseInt(PARAM_INFO.get("ReqPage").toString()));                     //요청페이지, 요청없으면 1
		    fc.setContractDate(PARAM_INFO.optString("CONTRACTDATE").equals("") ? "" : PARAM_INFO.get("CONTRACTDATE").toString());                  //시작 계약일자
		    fc.setContractDateTo(PARAM_INFO.optString("CONTRACTDATETO").equals("") ? "" : PARAM_INFO.get("CONTRACTDATETO").toString());              //종료 계약일자
		    fc.setSearchSidoCd(PARAM_INFO.optString("SEARCHSIDOCD").equals("") ? "" : PARAM_INFO.optString("SEARCHSIDOCD").toString());                  //시도
		    fc.setSearchGugunCd(PARAM_INFO.optString("SEARCHGUGUNCD").equals("") ? "" : PARAM_INFO.optString("SEARCHGUGUNCD").toString());                //시군구
		    fc.setSearchDongCd(PARAM_INFO.optString("SEARCHDONGCD").equals("") ? "" : PARAM_INFO.optString("SEARCHDONGCD").toString());                  //읍면동
		    fc.setSearchArea(PARAM_INFO.optString("SEARCHAREA").equals("") ? "" : PARAM_INFO.get("SEARCHAREA").toString());                      //면적
		    fc.setSearchAreaValue(PARAM_INFO.optString("SEARCHAREAVALUE").equals("") ? "0" : PARAM_INFO.get("SEARCHAREAVALUE").toString());                //시작 면적
		    fc.setSearchAreaValueTo(PARAM_INFO.optString("SEARCHAREAVALUETO").equals("") ? "10000" : PARAM_INFO.get("SEARCHAREAVALUETO").toString());          //종료 면적
		    fc.setSearchFromAmount(PARAM_INFO.optString("SEARCHFROMAMOUNT").equals("") ? "0" : PARAM_INFO.get("SEARCHFROMAMOUNT").toString());         //시작 금액
		    fc.setSearchToAmnount(PARAM_INFO.optString("SEARCHTOAMNOUNT").equals("") ? "100000000" : PARAM_INFO.get("SEARCHTOAMNOUNT").toString());   //종료 금액
			
		    JSONObject json = new JSONObject();
		    
			json.put("STARTREC", fc.getRc().getStartRec());
			json.put("ENDREC", fc.getRc().getEndRec());
			json.put("CONTRACTDATE", PARAM_INFO.optString("CONTRACTDATE"));
			json.put("CONTRACTDATETO", PARAM_INFO.optString("CONTRACTDATETO"));
			json.put("SEARCHSIDOCD", PARAM_INFO.optString("SEARCHSIDOCD"));
			json.put("SEARCHGUGUNCD", PARAM_INFO.optString("SEARCHGUGUNCD"));
			json.put("SEARCHDONGCD", PARAM_INFO.optString("SEARCHDONGCD"));
			json.put("SEARCHAREAVALUE", PARAM_INFO.optString("SEARCHAREAVALUE").equals("") ? "0" : PARAM_INFO.optString("SEARCHAREAVALUE").toString());
			json.put("SEARCHAREAVALUETO", PARAM_INFO.optString("SEARCHAREAVALUETO").equals("") ? "10000" : PARAM_INFO.optString("SEARCHAREAVALUETO").toString());
			json.put("SEARCHFROMAMOUNT", PARAM_INFO.optString("SEARCHFROMAMOUNT").equals("") ? "0" : PARAM_INFO.optString("SEARCHFROMAMOUNT").toString());
			json.put("SEARCHTOAMNOUNT", PARAM_INFO.optString("SEARCHTOAMNOUNT").equals("") ? "100000000" : PARAM_INFO.optString("SEARCHTOAMNOUNT").toString());
			
			//FindCriteria 전체건수 값 설정
			fc.setTotalRec(mainMapper.totalCount(json));
			
			//페이징
		    model.addAttribute("fc", fc);
			
			//목록, 차트
		    model.addAttribute("list", mainMapper.selectMyHomePriceList(json));
		    
//		    System.out.println("PARAM_INFO = " + PARAM_INFO);
//		    System.out.println("fc = " + fc);
//			System.out.println("json = " + json);
//			System.out.println("list = " + mainMapper.selectMyHomePriceList(json));
		    
		
		return "/main/mainView";
	}
	
}
