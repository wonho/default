package edu.showcase.system.ux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebResponse implements XResponse {

	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	
	private Map<String,Object> dataSet = new HashMap<>();
	
	
	public WebResponse(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		
		request.setAttribute("DATASET_KEY",dataSet);

	}

	@Override
	public <T> void set(String key, T bean) {
		dataSet.put(key, bean);
	}

	@Override
	public <T> void setList(String key, List<T> data) {
		dataSet.put(key, data);
	}
}
