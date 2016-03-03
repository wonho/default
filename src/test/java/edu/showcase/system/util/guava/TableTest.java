package edu.showcase.system.util.guava;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableTest {
	
	Logger logger = LoggerFactory.getLogger(TableTest.class);

	private Table<String, String, String> table = null;
	
	@Before
	public void setup() throws Exception {
		
		table = HashBasedTable.create();
		
		table.put("row1", "col1", "10");
		table.put("row2", "col2", "20");
		table.put("row3", "col3", "30");
		table.put("row4", "col4", "40");
	}
	
	
	@Test
	public void getValueByRowCol() throws Exception {
		
		String value1 = table.get("row1", "col1");
		
		logger.debug("row1, col1 {}",value1);
		
		String value2 = table.get("row1", "col2");
		
		logger.debug("row1, col2 {}",value2);
	}
	
	@Test
	public void getRowValueByColumn() throws Exception {
		
		Map<String, String> column1 = table.column("col2");
		
		logger.debug("{}", column1);
		
		Map<String, Map<String, String>> columnMap = table.columnMap();
		
		logger.debug("{}",columnMap);
		
		Set<String> keySet = table.columnKeySet();
	
		logger.debug("{}",keySet);
	}
	
}