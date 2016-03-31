package edu.showcase.auth;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.showcase.auth.service.User;

@Controller
@RequestMapping("/com")
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/main")
	public String processMain(@RequestParam Map<String,Object> paramMap) throws Exception {
		
		logger.debug("@RequestParam {}",paramMap);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Object details = authentication.getDetails();
		
		logger.debug("details {} ",details);
		
		User user = (User) authentication.getPrincipal();

		logger.debug("principal {} ",user);
		
		Object credentials = authentication.getCredentials();

		logger.debug("credentials {} ",credentials);
		
		
		return null;
		
	}

}
