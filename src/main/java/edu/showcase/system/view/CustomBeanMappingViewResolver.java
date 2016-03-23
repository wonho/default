package edu.showcase.system.view;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class CustomBeanMappingViewResolver implements ViewResolver {

	private Map<String, View> viewMapping;
	private View defaultView;
	
	
	public void setViewMapping(Map<String, View> viewMapping) {
		this.viewMapping = viewMapping;
	}

	public void setDefaultView(View defaultView) {
		this.defaultView = defaultView;
	}
	
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		View view =  viewMapping.get(viewName);
		
		if (view == null) {
			view = defaultView;
		}
		return view;
	}
}
