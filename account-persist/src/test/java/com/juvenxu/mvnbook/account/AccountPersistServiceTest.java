package com.juvenxu.mvnbook.account;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.juvenxu.mvnbook.account.persist.Account;
import com.juvenxu.mvnbook.account.service.AccountPersistService;
import com.juvenxu.mvnbook.account.util.AccountPersistException;

public class AccountPersistServiceTest {
	 
	private AccountPersistService service;
	 
	 @Before
     public void persistTest() throws AccountPersistException, IOException {
       File persistDataFile = new File("target/test-classes/persist-data.xml" );

       if (persistDataFile.exists()) {
            persistDataFile.delete();
       }
       ApplicationContext ctx = new ClassPathXmlApplicationContext("account-persist.xml");
       service = (AccountPersistService) ctx.getBean("accountPersistService" );
       Account account = new Account();
       account.setId("007");
       account.setName("yubin");
       account.setPassword("123456789");
       account.setActivated(true);
       account.setEmail("598628744");
       service.createAccount(account);
     }
	 @Test
	 public void testReadAccount()throws Exception{
		 Account account=service.readAccount("007");
		 assertEquals("007", account.getId());
	 }
}   

 
