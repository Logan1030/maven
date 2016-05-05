package com.juvenxu.mvnbook.account.service;

import com.juvenxu.mvnbook.account.persist.Account;
import com.juvenxu.mvnbook.account.util.AccountPersistException;

public interface AccountPersistService {
  void createAccount(Account account) throws AccountPersistException;
  Account readAccount(String id)throws AccountPersistException;
  Account updateAccount(Account account)throws AccountPersistException;
  void deleteAccount(String id)throws AccountPersistException;
}
