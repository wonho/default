package edu.showcase.system.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.view.AbstractView;

import edu.showcase.system.exception.DaoException;

public class SimpleExceptionView extends AbstractView implements MessageSourceAware {

	Logger logger = LoggerFactory.getLogger(SimpleExceptionView.class);
	
	private MessageSourceAccessor messageSource;
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = new MessageSourceAccessor(messageSource);
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		DaoException exception = (DaoException) model.get("exception");
		
		if (exception == null) {
			exception = new DaoException("예외 미설정됨");
		}
		
		logger.debug("SimpleExceptionView->renderMergedOutputModel  {}",model);
	}

}
