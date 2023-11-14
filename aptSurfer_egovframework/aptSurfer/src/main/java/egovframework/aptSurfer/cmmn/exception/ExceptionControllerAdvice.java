package egovframework.aptSurfer.cmmn.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(PremierException.class)
	public ModelAndView exception(Exception e) {
		ModelAndView mav = new ModelAndView("exception");
		mav.addObject("exception", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		//mav.setStatus(HttpStatus.BAD_REQUEST);
		return mav;
	}
}
