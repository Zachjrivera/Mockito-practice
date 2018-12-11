package com.zach.unittesting.business;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
	
	List<String> mock = mock(List.class);
	


	@Test
	public void size_Basic(){
		
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock);
		
	}
	
	@Test
	public void returnDiffrentValues() {
		
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
//	
	@Test
	public void returnDiffrentParameters() {
	when( mock.get(0)).thenReturn("In28Minutes");
	assertEquals("In28Minutes",mock.get(0));
	}
//	
	@Test
	public void returnWithGenericParameters() {
		//This is a generic
		when( mock.get(anyInt())).thenReturn("In28Minutes");
		assertEquals("In28Minutes",mock.get(0));
		assertEquals("In28Minutes",mock.get(5));
	}
	
	
	@Test
	public void VarificationBasics() {
		
		//SUT
		String value = mock.get(0);
		
		//Verify
		verify(mock).get(anyInt());
		//verifies that it is called 1 time
		verify(mock,times(1)).get(anyInt());
//		verify(mock,atLeast(1)).get(anyInt());
//		verify(mock,atMost(1)).get(anyInt());
//		verify(mock,never()).get(anyInt());

	}

	@Test
	public void multipleArgumentCaptureing() {
		mock.add("SomeString");
		mock.add("SomeString2");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		
		List<String> allvalues =captor.getAllValues();
		assertEquals("SomeString",allvalues.get(0));
		assertEquals("SomeString2",allvalues.get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList<String> arrayListMock = mock(ArrayList.class);
		arrayListMock.get(0);//null
		arrayListMock.size();//0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		arrayListMock.size();//0
		//Above is not storing anything below mocks data like its stored
		when(arrayListMock.size()).thenReturn(5);
		arrayListMock.size();//5
	}
	@Test
	public void spyingg() {
		ArrayList<String> arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		arrayListSpy.get(0);//positon 0
		arrayListSpy.size();//1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		arrayListSpy.size();//3
		
		when(arrayListSpy.size()).thenReturn(5);
		arrayListSpy.size();//5
		
		arrayListSpy.add("Test4");
		arrayListSpy.size();//5
		
		verify(arrayListSpy).add("Test4");
	}
	
	
	

}
