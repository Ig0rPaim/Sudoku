package Exeptions;

public class NatimortoException extends Exception{
	public NatimortoException (String msg) {
		super(msg);
	}
	
	public NatimortoException (String msg, Throwable cause) {
		super(msg, cause);
	}
}
