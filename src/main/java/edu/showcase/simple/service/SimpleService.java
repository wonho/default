package edu.showcase.simple.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.showcase.system.dao.CommonDao;

@Service
public class SimpleService {
	
	Logger logger = LoggerFactory.getLogger(SimpleService.class);
	
	@Autowired
	CommonDao dao;
	
	public List<?> getUser() {
		
		List<?> userList = dao.queryForList("user.select",  null);
		
		logger.debug("userList {} ",userList);
		
		return userList;
		
	}

}
