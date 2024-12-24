package com.ashokit.prototype;

public class Test {//BusinessServiceImpl

	public static void main(String[] args) throws CloneNotSupportedException {
		Department d= new Department(567);
		Employee e= new Employee(123,"Karthik",d);
		Employee e1=(Employee) e.clone();
		
		System.out.println(e.dep.depId);//567
		System.out.println(e1.dep.depId);//567
		
		e.dep.depId=908;
		
				
		System.out.println(e.dep.depId);//908
		System.out.println(e1.dep.depId);//567-908
	}
}
