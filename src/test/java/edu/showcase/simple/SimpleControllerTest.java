package edu.showcase.simple;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import edu.showcase.AbstractContextControllerTests;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/applicationContext-test.xml")
@ContextConfiguration(locations ={"classpath:spring/applicationContext-root.xml","classpath:spring/applicationContext-dao.xml"})
public class SimpleControllerTest extends AbstractContextControllerTests {
	
	private static String URI = "/simple";
	
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		mockMvc = webAppContextSetup(wac).alwaysExpect(status().isOk()).build();
	}
	
	@Test
	public void getUser() throws Exception {
		this.mockMvc.perform(get("/simple/getuser?number=3&date=2029-07-04"))
				.andExpect(content().string("No errors"));
	}
}
