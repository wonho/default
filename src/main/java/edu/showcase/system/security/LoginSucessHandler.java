package edu.showcase.system.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSucessHandler implements  AuthenticationSuccessHandler {

	Logger logger = LoggerFactory.getLogger(LoginSucessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		
		logger.debug("LoginSucessHandler {}",req.getContextPath());
		
		res.sendRedirect(req.getContextPath()+"/auth/main.do");
		
	}

}
