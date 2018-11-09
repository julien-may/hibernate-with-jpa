package ch.olmero.hibernatewithjpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClientControllerTest extends AbstractMockMvcTest {
	@Test
	public void test() throws Exception {
		MockHttpServletRequestBuilder builder = post("/clients")
			.contentType(MediaType.APPLICATION_JSON_VALUE);

		ResultActions actions = mockMvc.perform(builder)
			.andExpect(status().isOk());
	}
}