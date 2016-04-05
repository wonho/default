package edu.showcase.system.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

public class ExceptionViewFilter extends OncePerRequestFilter{
	
	Logger logger = LoggerFactory.getLogger(ExceptionViewFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		logger.debug("ExceptionViewFilter->doFilterInternal");
		
		try {
			filterChain.doFilter(request, response);
		} catch (RuntimeException e) {
			logger.debug("ExceptionViewFilter->doFilterInternal {}", e.getMessage());			

		}
		
	}
	

}
