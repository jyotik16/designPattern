package com.ashokit.strategydesignpattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StrategyPatternExample1 {
	
	public static void main(String[] args) {
		List<Integer> l= new ArrayList<>();
		l.add(1);
		l.add(100);
		l.add(11);
		l.add(14);
		l.add(21);
		l.add(13);
		System.out.println(l);//[1,100,11,14,21,13]
		//Write a program to sort the above numbers in Ascending
		//Write a program to sort the above numbers in Descending
		Collections.sort(l);
		Collections.sort(l,new Test());
		
		Collections.sort(l,new Comparator<Integer>() {

			
			@Override
			public int compare(Integer x, Integer y) {
				// TODO Auto-generated method stub
				return (x < y) ? 1 : ((x == y) ? 0 : -1);
				
			}
			
		});
		System.out.println(l);
		
		List<Employee> empList= new ArrayList<>();
		Collections.sort(empList);
	}

}
