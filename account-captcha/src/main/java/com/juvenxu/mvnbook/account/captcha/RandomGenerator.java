package com.juvenxu.mvnbook.account.captcha;

import java.util.Random;

public class RandomGenerator {
  
	private static String rangs="0123456789qwertyuiopasdfghjklzxcvbnm";
	
	public static synchronized String getRandomString(){
		Random random=new Random();
		StringBuffer result=new StringBuffer();
		for(int i=0;i<8;i++){
			result.append(rangs.charAt(random.nextInt(rangs.length())));
		}
		return result.toString();
	}
}
