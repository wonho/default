package edu.showcase.system.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

public class DefaultExceptionView extends AbstractView{

	Logger logger = LoggerFactory.getLogger(DefaultExceptionView.class);

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("DefaultExceptionView->renderMergedOutputModel {}",model);
		
	}

}
