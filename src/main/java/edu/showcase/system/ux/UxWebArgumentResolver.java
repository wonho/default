package edu.showcase.system.ux;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UxWebArgumentResolver implements HandlerMethodArgumentResolver{


	Logger logger = LoggerFactory.getLogger(UxWebArgumentResolver.class);

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		
		if (parameter.getParameterType() == XRequest.class) {
			return new WebRequest(request, response);
		} 
		
		if (parameter.getParameterType() == XResponse.class) {
			return new WebResponse(request, response);
		} 
		
//		return UNRESOLVED;
		return null;
	}
}
