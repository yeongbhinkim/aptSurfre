package egovframework.aptSurfer.mysql.testMY.mapper;



import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import net.sf.json.JSONObject;


@Mapper("TESTMYMapper")
public interface TESTMYMapper {

	
	public void insertTESTmy(JSONObject param) throws Exception;

}
