package com.hundsun.jresplus.quickstart.common.security;

/**
 * 
 * @author zhangsen
 * 
 */
public class UserAccessDeniedException extends RuntimeException {

	private static final long serialVersionUID = -4757581999998896852L;

	public UserAccessDeniedException() {
		super();
	}

	public UserAccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAccessDeniedException(String message) {
		super(message);
	}

	public UserAccessDeniedException(Throwable cause) {
		super(cause);
	}

}
