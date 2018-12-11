package com.zach.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.cache.interceptor.BeanFactoryCacheOperationSourceAdvisor;
import org.xmlunit.input.WhitespaceNormalizedSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.zach.unittesting.business.Businesssimp;
import com.zach.unittesting.data.SomeDataService;




@RunWith(MockitoJUnitRunner.class)
public class BusinesstestStubTestMocking {
	
	
	@InjectMocks
	Businesssimp business;
	
	@Mock
	SomeDataService dataservicemock;
	

	@Test
	public void CalcSumUsingDataService() {
		when(dataservicemock.retrieveAllData()).thenReturn(new int [] {1,2,3});
		assertEquals(6, business.calculattesumUsingDataService());
		
	}
	
	
	@Test
	public void CalcSumEmpty() {
		when(dataservicemock.retrieveAllData()).thenReturn(new int [] {});
		assertEquals(0, business.calculattesumUsingDataService());
	}
	
	

	@Test
	public void CalcSumOneValue() {
		when(dataservicemock.retrieveAllData()).thenReturn(new int [] {1});
		assertEquals(1, business.calculattesumUsingDataService());
	}
}
