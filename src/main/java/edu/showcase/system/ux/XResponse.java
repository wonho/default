package edu.showcase.system.ux;

import java.util.List;

public interface XResponse {

	public <T> void set(String key, T bean);
	
	public <T> void setList(String key, List<T> data);
	
}
