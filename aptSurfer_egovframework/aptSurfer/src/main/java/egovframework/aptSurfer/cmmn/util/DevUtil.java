package egovframework.aptSurfer.cmmn.util;



import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;

import net.sf.json.JSONObject;
import net.sf.json.JSONString;

public class DevUtil {

	public static String ObjectToJsonString(Object obj)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString = "";
		
		try 
		{ 
			jsonString = mapper.writeValueAsString(obj); 
		} 
		catch (Exception e) { }
		
		return jsonString;
	}
	
	public static class JSONFunction implements JSONString {
	    private String string;

	    public JSONFunction(String string) {
	        this.string = string;
	    }

	    @Override
	    public String toJSONString() {
	        return string;
	    }
	}
	
	public static String GetValueJSONArray(org.json.JSONArray array, String key, String keyValue, String valueKey) {
		for (int i = 0; i < array.length(); i++)
	    {
			org.json.JSONObject item = array.getJSONObject(i);
	        
	        String keyVal = item.getString(key);
	        
	        if (keyVal.equals(keyValue)) {
	        	return item.getString(valueKey);
	        }
	    }
		return "";
	}
	
	public static JSONObject getJsonFromRequestParameter(HttpServletRequest request) {
		JSONObject result = new JSONObject();
		Enumeration<String> keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = request.getParameter(key);
			result.put(key, value);
		}
		
		return result;
	}
}
