package com.ashokit.statepattern;

final public class Employee {
	
	private final int empId;
	private final String name;
	Address address;
	public Address getAddress() {
		return this.address;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public String getName() {
		return name;
	}


	public Employee(int empId,String name,Address address) {
		// TODO Auto-generated constructor stub
		
		Address ad= new Address(address.addressId);
		this.address=ad;
		this.empId=empId;
		this.name=name;
		
	}
	
	

}
