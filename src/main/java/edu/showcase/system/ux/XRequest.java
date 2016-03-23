package edu.showcase.system.ux;

import java.util.List;

public interface XRequest {
	public <T> T getObject(Class<T> clazz) throws Exception;
	
	public <T> List<T> getList(Class<T> clazz) throws Exception;
	
}
