package com.zach.unittesting.controller;

import static org.junit.Assert.assertEquals;

import java.awt.PageAttributes.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.zach.unittesting.controller.HelloWorldController;

import ch.qos.logback.core.status.Status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	 private MockMvc mockMvc;
	
	
	@Test
	public void helloWorldTest() throws Exception {
	
		//call Get "/hello-world" with Application/json
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-world")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
				//Why wont this work
	ResultActions result = mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string("Hello World"));

	
	}

}
