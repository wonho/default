package edu.showcase.simple;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 
 * Spring MVC Test
 *  - Spring MVC Test에서 standalone 방식으로 MockMvc 생성
 *  - StandAlone는 단순히 Servlet 즉 Conterller 테스트만 가능 , @autowired Service생성시 NUll이 됨
 * @author Administrator
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
//@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/config/default-servlet.xml","classpath:spring/applicationContext-root.xml","classpath:spring/applicationContext-dao.xml"})
public class SimpleControllerStandAloneTest {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = standaloneSetup(new SimpleController()).alwaysExpect(status().isOk()).build();
	}

	@Test
	public void getUser() throws Exception {
		this.mockMvc.perform(get("/simple/getuser?number=3&date=2029-07-04"))
				.andExpect(content().string("No errors"));
	}
}
