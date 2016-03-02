package edu.showcase.simple;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.showcase.simple.service.SimpleService;

@Controller
@RequestMapping("/simple")
public class SimpleController {

	Logger logger = LoggerFactory.getLogger(SimpleController.class);

	@Autowired
	SimpleService simpleService;
	
	@RequestMapping("/getuser")
	public String getUser(@RequestParam Map<String,Object> paramMap) {
		
		logger.debug("@RequestParam {}",paramMap);
		
		List<?> userList = simpleService.getUser();
		
		logger.debug("getUser {} ",userList);
		
		return "user";
	}
		
}

