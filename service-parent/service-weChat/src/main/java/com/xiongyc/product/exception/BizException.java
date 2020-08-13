package com.xiongyc.product.exception;

public class BizException extends RuntimeException {

	private static final long serialVersionUID = 8194358615981600779L;

	public BizException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BizException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}

	public BizException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public BizException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public BizException(String errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	protected String errorCode;

}
