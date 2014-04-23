package com.palestra.wf.exception;

public class WorkFlowException extends Exception{

	private static final long serialVersionUID = 3500898695146828298L;

	public WorkFlowException() {
		super();
	}

	public WorkFlowException(String message) {
		super(message);
	}

	public WorkFlowException(Throwable cause) {
		super(cause);
	}

	public WorkFlowException(String message, Throwable cause) {
		super(message, cause);
	}

}
