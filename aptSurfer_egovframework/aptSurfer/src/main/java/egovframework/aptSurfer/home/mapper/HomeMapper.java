package egovframework.aptSurfer.home.mapper;


import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import net.sf.json.JSONObject;

/**
 * @Class Name : egovframework.aptSurfer.home.mapper.HomeMapper
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

@Mapper("HomeMapper")
public interface HomeMapper {

	/**
	 * 시도 조회
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> selectRegionCity() throws Exception;
	
	/**
	 * 시군구 조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> selectRegionCounty(JSONObject param) throws Exception;
	
	/**
	 * 읍면동 조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> selectRegionDistricts(JSONObject param) throws Exception;

}
