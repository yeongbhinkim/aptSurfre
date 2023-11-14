package egovframework.aptSurfer.cmmn.util;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Http 요청 Tool
 * @author LTH
 */
public class HttpTools {
	public static String postRequest(String pURL, String param, String token) throws Exception {
		
		// 연결
		URL url = new URL(pURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST"); // 보내는 타입
		conn.setRequestProperty("Content-Type", "application/json;utf-8");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("token", token);
		
		OutputStream os = conn.getOutputStream();
		byte input[] = param.getBytes("utf-8");
		os.write(input,0,input.length);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
		StringBuilder response = new StringBuilder();
		String line = null;
		while((line = br.readLine())!=null) {
			response.append(line.trim());
		}
		String result = response.toString();
		
		return result;
	}
	public static String postRequest(String pURL, String param) throws Exception {
		// 연결
		URL url = new URL(pURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST"); // 보내는 타입
		conn.setRequestProperty("Content-Type", "application/json;utf-8");
		conn.setRequestProperty("Accept", "application/json");

		OutputStream os = conn.getOutputStream();
		byte input[] = param.getBytes("utf-8");
		os.write(input,0,input.length);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
		StringBuilder response = new StringBuilder();
		String line = null;
		while((line = br.readLine())!=null) {
			response.append(line.trim());
		}
		String result = response.toString();
		
		return result;
	}
	/**
	 * URL요청
	 * @param urlStr
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String getPageContent(String urlStr, String params) throws Exception{
		String pageContent = "";
		URLConnection conn = null;
		InputStream is = null;
		
		URL url = new URL(urlStr + params);
		conn = url.openConnection();
		conn.setReadTimeout(10000);
		conn.setConnectTimeout(10000);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		is = conn.getInputStream();
		pageContent = getHttpInputString(is);

		return pageContent;
	}
	
	/**
	 * 받은 데이터 가져오기
	 * @param is
	 * @return
	 * @throws Exception
	 */
	private static String getHttpInputString(InputStream is) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8 * 1024);
		StringBuilder sb = new StringBuilder();

		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
