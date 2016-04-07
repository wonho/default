package edu.showcase.system.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailHandler implements AuthenticationFailureHandler {

	Logger logger = LoggerFactory.getLogger(LoginFailHandler.class);
	
	/**
	 * throw Exception을 할 경우 ExceptionResolver에서 처리가 가능한지 확인 필요함
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException auth)
			throws IOException, ServletException {
		
		
		logger.debug("LoginFailHandler {}",req.getContextPath());
		
		res.sendRedirect(req.getContextPath()+"/auth/login.do");
		
	}

}
