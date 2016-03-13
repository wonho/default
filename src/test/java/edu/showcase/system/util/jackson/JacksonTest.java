package edu.showcase.system.util.jackson;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	private Logger logger = LoggerFactory.getLogger(JacksonTest.class);
	
	private ObjectMapper mapper = null;
	private InputStream input = null;
	
	@Before
	public void setup() throws Exception{
		this.mapper = new ObjectMapper();
	}
	
	public void init(String fileNmae) throws Exception {
		this.input = JacksonTest.class.getResourceAsStream(fileNmae);
	}
	
	@Test
	public void read() throws Exception {
		init("UserGruop.json");
		
		JsonNode readTree = mapper.readTree(input);
		
		logger.debug("readTree {} ",readTree);
		
		JsonNode jsonNode = readTree.get("menuitem");
		
		logger.debug("jsonNode {} ",jsonNode);
	}
	
	@Test
	public void read2() throws Exception {
		init("UserGruop.json");
		
		JsonNode jsonNode = mapper.readTree(input);

		logger.debug("jsonNode {} ",jsonNode);
		
		JsonNode jsonNode2 = jsonNode.get("menuitem");
		
		logger.debug("jsonNode2 {} ",jsonNode2);
	}
	
	@Test
	public void read3() throws Exception {
		init("UserGruop.json");
		
		TreeNode treeNode = mapper.readTree(input);
		
		logger.debug("treeNode {} ",treeNode);

//		TreeNode treeNode2 = treeNode.get("menuitem").get("").get(index);

//		logger.debug("treeNode2 {} ",treeNode2);

	}
	
	@Test
	public void read4() throws Exception {
		init("UserGruop.json");
		
//		new Builder(input).expect("menuitem").asList(User.class);
//		new Builder(input).expect("menuitem").asList(Map.class);
	}
	
	@Test
	public void read5() throws Exception {
		init("UserGruop.json");
		new Builder(input).asObject(Map.class);
	}
	
	@Test
	public void finalTest() throws Exception {
		init("UserGruop.json");
		
		Builder builder = new Builder(input);
		
		Map asObject = null;
		
//		asObject = builder.asObject(Map.class);
		
		builder.expect("menuitem").asObject(List.class);
		
				
	}
	

	
	

	public class Builder {
		
		ObjectMapper mapper = new ObjectMapper();
		
		TreeNode treeNode = null;
		
		public Builder() {
		}
		
		public Builder(InputStream in) {
			
			try {
				this.treeNode = mapper.readTree(input);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		public Builder expect(String key) {
			this.treeNode = treeNode.get(key);
			return this;
		}
		
		public <E> E asObject(Class<E> clazz) {
			
			E readValue = null;
			
			try {
				readValue = mapper.readValue(treeNode.toString(), clazz);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);								
			}
			
			logger.debug("readValue {} ",readValue);
			
			return readValue;
		}

		@SuppressWarnings("unchecked")
		public <E> List<E> asList(Class<E> clazz) {
			
			JavaType javaType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
			
			Object readValue = null;
			
			try {
				readValue = mapper.readValue(treeNode.toString(), javaType);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
			
			logger.debug("readValue {} ",readValue);

			return (List<E>) readValue;
		}
		
	}
}
