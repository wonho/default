package edu.showcase.system.util.gson;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * Menu to MenuItem define of one to many
 * 
 * User�� json Array�̳� key ���� ����  �׽�Ʈ ������
 * 
 * @author Administrator
 *
 */
public class GsonTest {

	Logger logger = LoggerFactory.getLogger(GsonTest.class);
	
	Reader reader = null;
	Gson gson = null;
	
	private void setup(String fileName) {
		this.reader = new InputStreamReader(GsonTest.class.getResourceAsStream(fileName));
		this.gson = new GsonBuilder().create();
	}
	
	
	/**
	 * JSON ������ ���°� ����Ʈ�� ���ƿ��� ��� group id �� ���� ���
	 * @throws Exception
	 */
	@Test
	public void getUser() throws Exception {
		
		setup("User.json");
		
//		Type typeOfList = new TypeToken<List<Map<String,Object>>>(){}.getType();

		Type typeOfList = new TypeToken<List<User>>(){}.getType();

		Object fromJson = gson.fromJson(this.reader, typeOfList);
		
		logger.debug("fromJson {}",fromJson);
	}

	/**
	 * JSON ������ ���°� ����Ʈ�� ���ƿ��� ��� group id �� �ִ� ���
	 * @throws Exception
	 */
	@Test
	public void getUserById() throws Exception {
		
		setup("UserGruop.json");

//		Type typeOfList = new TypeToken<List<User>>(){}.getType();

//		Type typeOfList = new TypeToken<Map<String,List<Map<String,Object>>>>(){}.getType();

		Type typeOfList = new TypeToken<Map<String,List<User>>>(){}.getType();
		
		
		Object fromJson = gson.fromJson(this.reader, typeOfList);
		
		logger.debug("fromJson {}",fromJson);
	}
	

}
