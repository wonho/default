package edu.showcase.system.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomDefaultView extends AbstractView{

	Logger logger = LoggerFactory.getLogger(CustomDefaultView.class);
	
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.debug("CustomDefaultView->renderMergedOutputModel  {}",model);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> dataSet = (Map<String, Object>) request.getAttribute("DATASET_KEY");

		logger.debug("CustomDefaultView->renderMergedOutputModel  {}",dataSet);
		
		mapper.writeValue(response.getOutputStream(), dataSet);
		
//		setList(dsName, Collections.singletonList(dto));

	}

}
	