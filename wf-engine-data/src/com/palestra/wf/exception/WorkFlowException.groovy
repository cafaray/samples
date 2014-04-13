package com.palestra.wf.exception

class WorkFlowException extends Exception {

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

	public WorkFlowException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
