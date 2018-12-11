package com.zach.unittesting.business;

import java.util.Arrays;
import java.util.OptionalInt;

import com.zach.unittesting.data.SomeDataService;

public class Businesssimp {
	
	
	 private SomeDataService someDataService;
	 


	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculattesum(int[] data) {
	return	Arrays.stream(data).reduce(Integer::sum).orElse(0);
		
	}

	public int calculattesumUsingDataService() {
		int sum = 0;
		int[] data = someDataService.retrieveAllData();
		for(int value:data) {
			sum +=value;
		}
		
		//someDataService.storeSum(sum);
		return sum;
	}
	
	
	
}
