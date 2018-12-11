package com.zach.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.omg.PortableServer.THREAD_POLICY_ID;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	
	@Test
	public void learning() {
		String responseFromService = "[" + 
				"{\"id\":10000, \"name\":\"Pencil\", \"quantity\":5}," + 
				"{\"id\":10001, \"name\":\"Pen\", \"quantity\":15}," + 
				"{\"id\":10002, \"name\":\"Eraser\", \"quantity\":10}" + 
				"]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		
		
		//Gives you the array length
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		
		//finds all the ids 
		List<Integer> ids = context.read("$..id");

		assertThat(ids).containsExactly(10000,10001,10002);
		
		
		
		//finds index
		
		System.out.println(context.read("$.[1]").toString());
		//finds 2 elements
		System.out.println(context.read("$.[0:2]").toString());
		
		//finds name that contains
		System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
		
		//finds quantity 
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());
		
	}

}
