package egovframework.aptSurfer.cmmn.exception;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;


public class PremierException extends RuntimeException {
	/**
	 * 사용예제 (다국어포함)
	 * import com.dbvalley.premier.common.exception.PremierException;
	 * import com.dbvalley.premier.common.message.MessageSource;
	 * 
	 * @Autowired
	 * private MessageSource messageSource;
	 * 
	 * throw new PremierException(messageSource.getMessage("fail.common.msg", ""));
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Collection<String> messages;
	
	public PremierException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);	
	}
	

    public PremierException(String msg, Exception cause){
        super(msg, cause);
    }


    public PremierException(Collection<String> messages){
        super();
        this.messages= messages;
    }


    public PremierException (Collection<String> messages, Exception cause){
        super(cause);
        this.messages= messages;
    }

    @Override
    public String getMessage(){
        String msg;

        if(this.messages!=null && !this.messages.isEmpty()){
            msg="[";

            for(String message : this.messages){
                msg+=message+",";
            }

            msg= StringUtils.removeEnd(msg, ",")+"]";

        }else msg= super.getMessage();

        return msg;
    }

}
