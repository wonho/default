package edu.showcase.simple;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Maps;

import edu.showcase.simple.service.SimpleService;
import edu.showcase.system.log.LogService;
import edu.showcase.system.ux.XResponse;

@Controller
@RequestMapping("/simple")
public class SimpleController {

	Logger logger = LoggerFactory.getLogger(SimpleController.class);

	@Autowired
	SimpleService simpleService;
	
	@Autowired
	LogService<String> logService;
	
	@RequestMapping("/getuser")
	public String getUser(@RequestParam Map<String,Object> paramMap) throws Exception {
		
		logger.debug("@RequestParam {}",paramMap);
		
		List<?> userList = simpleService.getUser();
		
		return "login/main";
	}
	
	/**
	 * new SimpleException 고민 필요함
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("/getex")
	public void getEx(@RequestParam Map<String,Object> paramMap, XResponse res) {
		
//		DefaultHandlerExceptionResolver
//		AbstractHandlerExceptionResolver
//		SimpleMappingExceptionResolver
		
		logger.debug("@RequestParam {}",paramMap);
		
		Map<String,Object> exceptMap = Maps.newHashMap();
		
		exceptMap.put("getEx1", "111111111");
		exceptMap.put("getEx2", "222222222");
		
		
		
		res.set("value1", exceptMap);
		
		List<Map<String,Object>> dataList = new ArrayList<>();
		
		Map<String,Object> dataMap1 = Maps.newHashMap();
		
		dataMap1.put("data1", "111111111");
		dataMap1.put("data2", exceptMap);


		Map<String,Object> dataMap2 = Maps.newHashMap();
		
		dataMap2.put("data3", "111111111");
		dataMap2.put("data4", "444444444");
		
		dataList.add(dataMap1);
		dataList.add(dataMap2);
		
		
		res.setList("dataList", dataList);
	}	
	
	
	
	@RequestMapping("/getfile")
	public void getEx2(@RequestParam Map<String,Object> paramMap, HttpServletResponse resp) throws Exception {
		
		File file = new File("c:/imsi/spring-framework-reference.pdf");
		InputStream input = new FileInputStream(file);
		
		
		byte[] byteArray = IOUtils.toByteArray(input);
		
		ByteArrayInputStream bis  = new ByteArrayInputStream(byteArray);
		
		resp.setContentType("application/octet;charset=utf-8");
		String fileName= "aaa.pdf";
		
		IOUtils.copy(bis, resp.getOutputStream());
	}
	

	

}

