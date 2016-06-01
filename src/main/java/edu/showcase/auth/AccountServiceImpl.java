package edu.showcase.auth;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

import edu.showcase.rmi.Account;
import edu.showcase.rmi.AccountService;

public class AccountServiceImpl implements AccountService {

	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Override
	public void insertAccount(Account account) {
		logger.debug("account.getName()-> {}",account.getName());
	}

	@Override
	public List<Account> getAccounts(String name) {
		
		ArrayList<Account> list = Lists.newArrayList();
		
		Account account = new Account();
		
		account.setName("18놈팡");
		
		list.add(account);
		return list;
	}

}
