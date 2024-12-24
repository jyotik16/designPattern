package com.ashokit.prototype;

public class Employee implements Cloneable{
	int empId;
	String empName;
	
	Department dep;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName,Department dep) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dep=dep;
	}
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e= new Employee(124, "dssd", new Department(124));
		Employee e1=(Employee)e.clone();
		Employee e2= new Employee();
		System.out.println(e1.empName);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Department d= new Department(this.dep.depId);
		Employee e= new Employee(this.empId,this.empName,d);
		// TODO Auto-generated method stub
		return e;//shallow clonning
	}
	

}
