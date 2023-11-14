package egovframework.aptSurfer.main.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import net.sf.json.JSONObject;

/**
 * @Class Name : egovframework.aptSurfer.main.mapper.MainMapper
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

@Mapper("MainMapper")
public interface MainMapper {

	/**
	 * APT 조건조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> selectMyHomePriceList(JSONObject param) throws Exception;
	/**
	 * 전체건수 조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int totalCount(JSONObject param) throws Exception;
	
}
