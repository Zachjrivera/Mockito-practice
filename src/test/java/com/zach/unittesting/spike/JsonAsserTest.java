package com.zach.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAsserTest {
	
	String actualresponse = "{\"id\":1,\"name\":\"Ball\",\"quantity\":100}";
	
	//Allows spaces but needs all data structured
	@Test
	public void jsonAssert_StrictTrue() throws JSONException {
		String expectedRespones = "{\"id\":1,\"name\":\"Ball\",\"quantity\":100}";
		JSONAssert.assertEquals(expectedRespones, actualresponse, true);
	}
	
	@Test
	public void jsonAssert() throws JSONException {
		String expectedRespones = "{\"id\":1,\"name\":\"Ball}";
		JSONAssert.assertEquals(expectedRespones, actualresponse, false);
	}
	
	@Test
	public void jsonAssert_WithoutEscape() throws JSONException {
		String expectedRespones = "{id : 1 , name : Ball }";
		JSONAssert.assertEquals(expectedRespones, actualresponse, false);
	}

}
