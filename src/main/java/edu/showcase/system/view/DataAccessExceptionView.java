package edu.showcase.system.view;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.view.AbstractView;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataAccessExceptionView extends AbstractView implements MessageSourceAware {

	Logger logger = LoggerFactory.getLogger(DataAccessExceptionView.class);
	
	public MessageSourceAccessor messageSource;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = new MessageSourceAccessor(messageSource);
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			Map<String,Object> exceptionMap = new HashMap<>();
			
			Locale locale = Locale.getDefault();
			
			DataAccessException exception = (DataAccessException) model.get("exception");
			
			exceptionMap.put("rootMessage",exception.getRootCause().getMessage());
			exceptionMap.put("detailMessage",exception.getMessage());
			
			logger.debug("1 {}",exception.getMessage());
			
			logger.debug("2 {}",exception.getRootCause().getMessage());
			
			String message = messageSource.getMessage("exception.DataIntegrityViolationException");

			logger.debug("3 {}",message);


			if (exception instanceof DataIntegrityViolationException ) {
				
			} else {
				
			}
			
			mapper.writeValue(response.getOutputStream(), exceptionMap);
			
			System.out.println("asfsadfd");
	}


}
