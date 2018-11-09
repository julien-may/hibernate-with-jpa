package ch.olmero.hibernatewithjpa.controller;

import ch.olmero.hibernatewithjpa.HibernateWithJpaApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HibernateWithJpaApplication.class)
@ActiveProfiles(profiles = {"test"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class AbstractMockMvcTest {
	private static final String TENANT = "localhost";

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private WebApplicationContext webApplicationContext;

	protected MockMvc mockMvc;

	@Autowired
	private OpenEntityManagerInViewFilter openEntityManagerInViewFilter;

	@Before()
	public void setUp() {
		mockMvc = createMockMvc();
	}

	private MockMvc createMockMvc() {
		return MockMvcBuilders.webAppContextSetup(webApplicationContext)
			.addFilter(openEntityManagerInViewFilter, "/*")
			.build();
	}
}
