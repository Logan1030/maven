package com.juvenxu.mvnbook.account.captcha;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountCaptchaServiceTest {
  private AccountCaptchaService service;
  
  @Before
  public void prepare(){
	  ApplicationContext context=new ClassPathXmlApplicationContext("account-captcha.xml");
	  service=(AccountCaptchaService) context.getBean("accountCaptchaService");
  }
  @Ignore
  public void testGenerateCaptcha()throws Exception{
	  String captchaKey=service.generateCaptchaKey();
	  assertNotNull(captchaKey);
	  
	  byte[] captchaImage=service.generateCaptchaImage(captchaKey);
	  assertTrue(captchaImage.length>0);
	  
	  File image=new File("target/"+captchaKey+".jpg");
	  OutputStream output=null;
	  
	  try {
		output=new FileOutputStream(image);
		output.write(captchaImage);
	  } finally{
	    if(output!=null){
	    	output.close();
	    }
	  }
	  assertTrue(image.exists()&&image.length()>0);
	  
  }
  @Test
  public void testValidateCaptchaCorrect()throws Exception{
	  
  }
}
