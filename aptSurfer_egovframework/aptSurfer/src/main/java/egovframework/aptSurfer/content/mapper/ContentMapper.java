package egovframework.aptSurfer.content.mapper;

import java.util.List;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import net.sf.json.JSONObject;

/**
 * @Class Name : egovframework.aptSurfer.content.mapper.ContentMapper
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

@Mapper("ContentMapper")
public interface ContentMapper {

	/**
	 * APT 상세조회 폼
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject selectMyHomePriceDetailForm(JSONObject param) throws Exception;
	/**
	 * APT 상세조회 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> selectMyHomePriceDetail(JSONObject param) throws Exception;
	/**
	 * APT 상세조회 ScatterChart
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject selectMyHomePriceScatterChart(JSONObject param) throws Exception;


}
