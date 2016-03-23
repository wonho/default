package edu.showcase.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Maps;

import edu.showcase.simple.service.SimpleService;
import edu.showcase.system.exception.DaoException;
import edu.showcase.system.ux.XResponse;

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
	
	/**
	 * new SimpleException을 던지면 어떻게 될까?
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
	
	@RequestMapping("/getex2")
	public void getEx2(@RequestParam Map<String,Object> paramMap, XResponse res) {
		
		logger.debug("@RequestParam {}",paramMap);
		
		simpleService.getUser2();
		
	}

}

