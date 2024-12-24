package com.ashokit.iteratordesignpattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class InsuranceIteratorDesignPattern {
	
	public static void main(String[] args) {
		
		//What is the 
		List<Integer> l= new ArrayList<>();
		//List<InsurancePolicy> l1= new CopyOnWriteArrayList<>();
		l.add(10);//1
		l.add(20);//2
		l.add(30);//3
		l.add(40);//4= modcount
		l.add(10, 200);
		ListIterator<Integer> it= l.listIterator();//4
		int i=0;
		while (it.hasNext()) {
			i++;
			if(i>1) {
				l.add(1);
				Integer integer = (Integer) it.previous();
						//5
			}
		}
	}

}
