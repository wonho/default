package edu.showcase.system.util.guava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class FunctionTest {

	private Logger logger = LoggerFactory.getLogger(FunctionTest.class);

	List<Map<String,Object>> list = null;
	
	@Before
	public void setup() throws Exception {
		
		HashMap<String,Object> valueMap = null;
		
		list = Lists.newArrayList();
		
		valueMap = Maps.newHashMap();

		valueMap.put("key1", "data1");
		valueMap.put("key2", "data2");
		valueMap.put("key3", "data3");
		
		list.add(valueMap);
		
		valueMap = Maps.newHashMap();

		valueMap.put("key1", "data4");
		valueMap.put("key2", "data5");
		valueMap.put("key3", "data6");
		
		list.add(valueMap);
		
		valueMap = Maps.newHashMap();

		valueMap.put("key1", null);
		valueMap.put("key2", "data8");
		valueMap.put("key3", "data9");
		
		list.add(valueMap);
		
	}
	
	@Test
	public void transform() throws Exception {
		
		Function<Map<String,Object>,String> function = new Function<Map<String,Object>, String>() {
			
			@Override
			public String apply(Map<String, Object> input) {
				
				Object object = input.get("key1");
				
				logger.debug("function {}",object);
				
				return (String) object;
			}
		}; 
		
		List<String> transform = Lists.transform(list, function);
		
		logger.debug("{} {}", transform);
		
	}
	
	@Test
	public void iterables() throws Exception {
		
		Function<Map<String,Object>,String> function = new Function<Map<String,Object>, String>() {
			
			@Override
			public String apply(Map<String, Object> input) {
				
				Object object = input.get("key1");
				
				logger.debug("function {}",object);
				
				return (String) object;
			}
		}; 
		
		
		Iterable<String> transform = Iterables.transform(list, function);
		
		List<String> resultList = Lists.newArrayList(Iterables.filter(transform, Predicates.<String>notNull()));
		
		logger.debug("{}", resultList);
	}
	
}
