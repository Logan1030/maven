package com.juvenxu.mvnbook.account.captcha;

import java.util.List;

public interface AccountCaptchaService {
 
	public String generateCaptchaKey() throws AccountCaptchaException;
	
	public byte[]generateCaptchaImage(String captchaKey)throws AccountCaptchaException;
	
	public boolean validateCaptcha(String captchaKey,String captchaValue)throws AccountCaptchaException;
	
	public List<String>getPreDefinedTexts();
	
	public void setpreDefinedTexts(List<String>preDefinedTexts);
}
