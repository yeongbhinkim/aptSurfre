package com.ybkim.AptPrice.domain.AptScheduler;

import com.ybkim.AptPrice.domain.AptScheduler.svc.AptApiDbSVC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class AptScheduler {

    @Autowired
    AptApiDbSVC aptApiDbSVC;

//    @Scheduled(cron = "*/5 * * * * *")
//    public void myScheduledMethod() throws IOException, ParseException {
//
//        LocalDate startDate = LocalDate.of(2006, 1, 1);
//        LocalDate currentDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
//
////        for (LocalDate date = startDate; date.isBefore(currentDate.plusMonths(1)); date = date.plusMonths(1)) {
////            String formattedDate = date.format(formatter);
////            System.out.println(formattedDate);
////
//
//        List<CountyCode> apiRegionCounty = aptApiDbSVC.apiRegionCounty();
//
////            for (int i = 0; i < apiRegionCounty.size(); i++) {
//        for (int i = 0; i < 1; i++) {
//            CountyCode county = apiRegionCounty.get(i);
//            System.out.println("county.getCounty_code() = " + county.getCounty_code());
//
//            StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*URL*/
//            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=GIzL%2BzqBUKfyHh3o%2F38ufLPiq5P%2FReUOx6NCLFEcP7rqQei%2FPIM3QbUw3rLU1gYOQfdeIREA1cLZF7lRIP5zTg%3D%3D"); /*Service Key*/
//            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1000000", "UTF-8")); /*한 페이지 결과 수*/
//            urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode("11110", "UTF-8")); /*지역코드*/
////            urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode(county.getCounty_code(), "UTF-8")); /*지역코드*/
//            urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode("200601", "UTF-8")); /*계약월*/
////                urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode(formattedDate, "UTF-8")); /*계약월*/
//            URL url = new URL(urlBuilder.toString());
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Content-type", "application/json");
//            System.out.println("Response code: " + conn.getResponseCode());
//            BufferedReader rd;
//
//
//            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            } else {
//                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//            }
//
////            String result = "";
////            result = rd.readLine();
////
////            System.out.println("result = " + result);
////
////            JSONParser jsonParser = new JSONParser();
////            JSONObject jsonObject = null;
////            jsonObject = (JSONObject) jsonParser.parse(result);
////            JSONObject CardSubwayStatsNew = (JSONObject) jsonObject.get("CardSubwayStatsNew");
////            Long totalCount = (Long) CardSubwayStatsNew.get("list_total_count");
////
////            JSONObject subResult = (JSONObject) CardSubwayStatsNew.get("RESULT");
////            JSONArray infoArr = (JSONArray) CardSubwayStatsNew.get("row");
////
////            for (int k = 0; k < infoArr.size(); k++) {
////                JSONObject tmp = (JSONObject) infoArr.get(k);
////                AptApiDb AptApi = new AptApiDb(k + (long) 1, (String) tmp.get("city"), (String) tmp.get("street"), (String) tmp.get("bon_bun"),
////                        (String) tmp.get("bu_bun"), (String) tmp.get("dan_gi_myeong"), (String) tmp.get("square_meter"), (String) tmp.get("contract_date"),
////                        (String) tmp.get("contract_day"), (String) tmp.get("amount"), (String) tmp.get("layer"), (String) tmp.get("construction_date"),
////                        (String) tmp.get("road_name"), (String) tmp.get("reason_cancellation_date"), (String) tmp.get("transaction_type"),
////                        (String) tmp.get("location_agency"));
////                System.out.println("AptApiDb = " + AptApi);
////            }
//
//
//                if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//                    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                } else {
//                    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//                }
//                StringBuilder sb = new StringBuilder();
//                String line;
//                while ((line = rd.readLine()) != null) {
//                    sb.append(line);
//                }
//                rd.close();
//                conn.disconnect();
//                System.out.println(sb);
//                System.out.println(sb.toString());
////                aptApiDbSVC.ApiDb(sb);
//        }
//    }
//    }

}
