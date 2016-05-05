package com.juvenxu.mvnbook.account.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.juvenxu.mvnbook.account.persist.Account;
import com.juvenxu.mvnbook.account.util.AccountPersistException;

public class AccountPersistServiceImpl implements AccountPersistService {
	private String file;
	private SAXReader reader=new SAXReader();
	public void createAccount(Account account) throws AccountPersistException {
		 File dataFile=new File(file);
		 Document document=DocumentFactory.getInstance().createDocument();;
		 if(!dataFile.exists()){
			 dataFile.getParentFile().mkdirs();
		 }
		 Element root=document.addElement("account-persist");
		 Element accounts=root.addElement("accounts");
		 Element acc=accounts.addElement("account");
		 Class cla=account.getClass();
		 Field[] fields=cla.getDeclaredFields();
		 try {
			for(int i = 0 ; i < fields.length; i++){  
			       Field f = fields[i];
			       f.setAccessible(true);
			       acc.addElement(f.getName()).addText(f.get(account).toString());
			   }
		} catch (SecurityException e) {
		
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
		 
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			 
			e.printStackTrace();
		}
		 writeDocument(document);
	}

	@SuppressWarnings("unchecked")
	public Account readAccount(String id) throws AccountPersistException {
		Document document=readDocument();
		Element accounts=document.getRootElement().element("accounts");
		for(Element element:(List<Element>)accounts.elements()){
			if(id.equals(element.elementText("id"))){
				return buildAccount(element);
			}
		}
		return null;
	}

	public Account updateAccount(Account account) throws AccountPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAccount(String id) throws AccountPersistException {
		// TODO Auto-generated method stub
		
	}
	private Document readDocument()throws AccountPersistException{
		 File dataFile=new File(file);
		 if(!dataFile.exists()){
			 dataFile.getParentFile().mkdirs();
			 Document document=DocumentFactory.getInstance().createDocument();
			 Element root=document.addElement("account-persist");
			 root.addElement("accounts");
			 writeDocument(document);
		 }
		try {
			return reader.read(dataFile);
		} catch (DocumentException e) {
			throw new AccountPersistException("unable to read persist data.xml",e);
		}
	 }
	 public void writeDocument(Document document)throws AccountPersistException{
		 Writer writer=null;
		 try {
			writer=new OutputStreamWriter(new FileOutputStream(file),"utf-8");
			XMLWriter xmlWriter=new XMLWriter(writer,OutputFormat.createPrettyPrint());
			xmlWriter.write(document);
		 } catch (IOException e) {
			throw new AccountPersistException("unable to write",e);
		 }finally {
		    try {
				if(writer!=null){
				  writer.close();
				}
			} catch (IOException e) {
				throw new AccountPersistException("unable to close persist data",e);
			}
		 }
		 
	 }
	 public Account buildAccount(Element element){
		 Account account=new Account();
		 account.setId(element.elementText("id"));
		 account.setEmail(element.elementText("email"));
		 account.setName(element.elementText("name"));
		 account.setPassword(element.elementText("password"));
		 account.setActivated("true".equals(element.elementText("activate")));
		 return account;
	 }

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	 
}
