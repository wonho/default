package edu.showcase.system.util.guava;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapTest {

	private Logger logger = LoggerFactory.getLogger(BiMapTest.class);

	BiMap<String, String> biMap = null;
	
	@Before
	public void setup() throws Exception {
	
		biMap = HashBiMap.create();
		
		biMap.put("row1", "10");
		biMap.put("row2", "20");
		biMap.put("row3", "30");
		biMap.put("row4", "40");
		
		logger.debug("biMap init {}",biMap);
	}
	
	@Test
	public void inverse() throws Exception {
		
		BiMap<String,String> inverseMap = biMap.inverse();
		
		logger.debug("biMap inverse {}",inverseMap);
		
	}
	
	@Test
	public void contains() throws Exception {
		
		boolean containsKey = biMap.containsKey("20");
		
		logger.debug("{}",containsKey);
		
		BiMap<String,String> inverseMap = biMap.inverse();
		
		boolean containsKey2 = inverseMap.containsKey("20");
		
		logger.debug("{}",containsKey2);
	}

}
