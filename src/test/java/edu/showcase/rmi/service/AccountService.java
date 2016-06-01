package edu.showcase.rmi.service;

import java.util.List;

import edu.showcase.rmi.Account;

public interface AccountService {
	
	 public void insertAccount(Account account);
	 public List<Account> getAccounts(String name);
	 
}
