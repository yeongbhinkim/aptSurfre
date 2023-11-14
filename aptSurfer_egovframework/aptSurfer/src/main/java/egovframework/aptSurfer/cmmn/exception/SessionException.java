package egovframework.aptSurfer.cmmn.exception;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

public class SessionException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private Collection<String> messages;
	
	public SessionException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);	
	}
	
	public SessionException(String msg, Exception cause){
        super(msg, cause);
    }


    public SessionException(Collection<String> messages){
        super();
        this.messages= messages;
    }


    public SessionException(Collection<String> messages, Exception cause){
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
