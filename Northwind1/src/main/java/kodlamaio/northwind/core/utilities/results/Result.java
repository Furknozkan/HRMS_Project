package kodlamaio.northwind.core.utilities.results;

import org.apache.logging.log4j.message.Message;

import com.sun.net.httpserver.Authenticator.Success;

public class Result {
	private boolean success;
	private String message;
	
	public Result(Boolean success) {
		this.success=success;
		
	}
	
	public Result(Boolean success, String message) {
		this(success);
		this.message=message;
	}
	
	public Boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}

}
