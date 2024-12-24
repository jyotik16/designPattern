package com.ashokit.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
	
	private String name;
	private int id;
	private double salary;
	private String depName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	List<Faculty> directReportees=null;
	public Faculty(String name, int id, double salary, String depName) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.depName = depName;
		directReportees=new ArrayList<>();
	}
	
	void addFaculty(Faculty f){
		directReportees.add(f);
	}
	void removeFaculty(Faculty f){
		directReportees.remove(f);
	}
	
	void printAllReportees(){
		System.out.println("Reporttes are ");
		for (int i = 0; i < directReportees.size(); i++) {
			System.out.println(directReportees.get(i).getName()+" and facult id is "+directReportees.get(i).getId());
		}
	}
	

}
