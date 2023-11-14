package egovframework.aptSurfer.testORA.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import net.sf.json.JSONObject;


@Mapper("TESTORAMapper")
public interface TESTORAMapper {
	
	public void insertTESTora(JSONObject param) throws Exception;

}
