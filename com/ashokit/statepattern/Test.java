package com.ashokit.statepattern;

public class Test {

	public static void main(String[] args) {
		Address adr= new Address(890);
		Employee e= new Employee(123,"karthik",adr);
		System.out.println(e.getEmpId());
		System.out.println(e.getName());
		System.out.println(e.address.addressId);
		adr.addressId=765;
		System.out.println(e.getAddress().addressId);
	
		
		
	}
}
