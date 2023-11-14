package egovframework.aptSurfer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import egovframework.aptSurfer.mysql.testMY.service.TESTMYService;
import egovframework.aptSurfer.testORA.service.TESTORAService;
import net.sf.json.JSONObject;

@Configuration
public class PremierPmsScheduler {
	
	Logger logger = Logger.getLogger(PremierPmsScheduler.class);
	
	@Autowired
	private TESTMYService tESTMYService;
	
	@Autowired
	private TESTORAService tESTORAService;

	// 초, 분, 시, 일, 월, 년
	@Scheduled(cron="0/5 * * * * *")
	public void testSchedule() {
	
		System.out.println("test1");
		JSONObject param = new JSONObject();
		try {
<<<<<<< HEAD
//			tESTMYService.setTESTInfoMY(param);
//			tESTORAService.setTESTInfoORA(param);
=======
			tESTMYService.setTESTInfoMY(param);
			tESTORAService.setTESTInfoORA(param);
>>>>>>> origin/master
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test2");
		
	}
	
}
