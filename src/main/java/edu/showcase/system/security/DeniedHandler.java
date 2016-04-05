package edu.showcase.system.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class DeniedHandler implements AccessDeniedHandler {

	Logger logger = LoggerFactory.getLogger(DeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest arg0, HttpServletResponse arg1, AccessDeniedException arg2)
			throws IOException, ServletException {
		
		logger.debug("DeniedHandler {} ",arg2.getMessage());
		
	}

	
}
