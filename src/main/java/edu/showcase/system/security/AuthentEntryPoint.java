package edu.showcase.system.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class AuthentEntryPoint implements AuthenticationEntryPoint{

	Logger logger = LoggerFactory.getLogger(AuthentEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException arg2)
			throws IOException, ServletException {
		
		logger.info("{}",arg2.getMessage());
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/com/main.do");
		
		requestDispatcher.forward(req, res);
		
	}

}
