package edu.showcase.system.ux;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebRequest implements XRequest{

	private HttpServletRequest request = null;
	private ObjectMapper mapper = new ObjectMapper();

	public WebRequest(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
	}

	@Override
	public <T> T getObject(Class<T> clazz) throws Exception {
		
		T readValue = mapper.readValue(this.request.getReader(), clazz);
		
		return readValue;
	}

	@Override
	public <T> List<T> getList(Class<T> clazz) throws Exception {
		
	    JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
	    		  
	    List<T> readValue = mapper.readValue(this.request.getReader(), type);

	    return readValue;
	}
	
}
