package com.zach.unittesting.business;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.zach.unittesting.business.Businesssimp;
import com.zach.unittesting.data.SomeDataService;


class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
	
		return new int[] {1,2,3};
	}
}

class SomeDataServiceStubEmpty implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
	
		return new int[] {};
	}
}

class SomeDataServiceStubOneNumber implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
	
		return new int[] {1};
	}
}


public class BusinesstestStubTest {

	@Test
	public void CalcSumUsingDataService() {
		Businesssimp business = new Businesssimp();
		business.setSomeDataService(new SomeDataServiceStub()); 
		
		int actualresult = business.calculattesumUsingDataService();
		int expectedresult =6 ;
		assertEquals(expectedresult, actualresult);
		
	}
	
	
	@Test
	public void CalcSumEmpty() {
		Businesssimp business = new Businesssimp();
		business.setSomeDataService(new SomeDataServiceStubEmpty()); 
		int actualresult = business.calculattesumUsingDataService();
		int expectedresult =0 ;
		assertEquals(expectedresult, actualresult);
	}
	

	@Test
	public void CalcSumOneValue() {
		Businesssimp business = new Businesssimp();
		business.setSomeDataService(new SomeDataServiceStubOneNumber()); 
		int actualresult = business.calculattesumUsingDataService();
		int expectedresult =1 ;
		assertEquals(expectedresult, actualresult);
	}
}
