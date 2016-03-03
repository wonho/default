package edu.showcase.system.util.guava;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MultiMapTest {

	Logger logger = LoggerFactory.getLogger(MultiMapTest.class);
	
	Multimap<String, String> multiMap = null;
	
	@Before
	public void setup() throws Exception {
		multiMap = ArrayListMultimap.create();
		
		multiMap.put("key1", "data1");
		multiMap.put("key1", "data2");
		multiMap.put("key3", "data3");
		multiMap.put("key4", "data4");
	}
	
	@Test
	public void print() throws Exception {
	
		Collection<String> data = multiMap.get("key1");
		
		logger.debug("multiMap data {} ",data);
	}
}
