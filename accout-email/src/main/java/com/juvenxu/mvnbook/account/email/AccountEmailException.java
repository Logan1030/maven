package com.juvenxu.mvnbook.account.email;
/**
 * 账号邮件异常处理
 * <p>
 * Description:<br />
 * </p>
 * @title AccountEmailException.java
 * @package com.juvenxu.mvnbook.account.email 
 * @author yubin
 * @version 0.1 2016年5月5日
 */
public class AccountEmailException extends Exception{
	
	private static final long serialVersionUID = -2370837281069903164L;

	public AccountEmailException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountEmailException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccountEmailException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountEmailException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountEmailException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
  
	
}
