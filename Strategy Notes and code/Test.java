package com.ashokit.strategydesignpattern;

import java.util.Comparator;

public class Test implements Comparator<Integer>{

	@Override
	public int compare(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return (x < y) ? 1 : ((x == y) ? 0 : -1);
	}

}
