package edu.showcase.system.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author Administrator
 * 
 * MyBatis Common Dao Å×½ºÆ®
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class CommonDaoTest {

	Logger logger = LoggerFactory.getLogger(CommonDaoTest.class);
	
	@Autowired
	CommonDao commonDao; 

	@Test
	public void select() throws Exception {
		List<?> queryForList = commonDao.queryForList("user.select",  null);
		
		logger.debug("select {} ",queryForList);
		
	}

}
