package edu.showcase.rmi;

import java.util.List;

public interface AccountService {
	
	 public void insertAccount(Account account);
	 public List<Account> getAccounts(String name);
	 
}
