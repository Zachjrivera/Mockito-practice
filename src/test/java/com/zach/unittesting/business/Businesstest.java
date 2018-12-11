package com.zach.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.zach.unittesting.business.Businesssimp;

public class Businesstest {

	@Test
	public void CalcSum() {
		Businesssimp business = new Businesssimp();
		int actualresult = business.calculattesum(new int[] {1,2,3});
		int expectedresult =6 ;
		assertEquals(expectedresult, actualresult);
		
	}
	
	
	@Test
	public void CalcSumEmpty() {
		Businesssimp business = new Businesssimp();
		int actualresult = business.calculattesum(new int[] {});
		int expectedresult =0 ;
		assertEquals(expectedresult, actualresult);
	}
	

	@Test
	public void CalcSumOneValue() {
		Businesssimp business = new Businesssimp();
		int actualresult = business.calculattesum(new int[] {1});
		int expectedresult =1 ;
		assertEquals(expectedresult, actualresult);
	}
}
