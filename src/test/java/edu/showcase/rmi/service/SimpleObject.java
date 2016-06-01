package edu.showcase.rmi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.showcase.rmi.Account;

public class SimpleObject {
	
		Logger logger = LoggerFactory.getLogger(SimpleObject.class);
	
		AccountService accountService;

		 public void setAccountService(AccountService accountService) {
			 this.accountService = accountService;
		}
		 
		 
		 
		 public void getAccounts() {
			 List<Account> accounts = accountService.getAccounts("18nom client");

			 for (Account account : accounts) {
				 logger.debug("SimpleObject -> getAccounts{}",account.getName());				
			}
		 }
}