package com.ashokit.compositepattern;

public class MainClass {
	
	public static void main(String[] args) {
		Faculty hod= new Faculty("Karthik", 123, 100000.00, "ECE");
		
		Faculty prof1= new Faculty("Nilesh", 124, 50000, "ECE");
		Faculty prof2= new Faculty("Babu", 125, 75000, "ECE");
		Faculty asstProf1= new Faculty("Ajay", 126, 20000, "ECE");
		Faculty asstProf2= new Faculty("Rahul", 127, 10000, "ECE");
		Faculty asstProf3= new Faculty("Ravi", 128, 5000, "ECE");
		
		hod.addFaculty(prof1);
		hod.addFaculty(prof2);
		
		prof1.addFaculty(asstProf1);
		prof1.addFaculty(asstProf2);
		
		prof2.addFaculty(asstProf3);
		System.out.println(" Faculty reporting to HOD are *****");
		hod.printAllReportees();
		System.out.println(" Faculty reporting to Prof 1 are *****");
		prof1.printAllReportees();
		System.out.println(" Faculty reporting to Prof 2 are *****");
		prof2.printAllReportees();
		
		prof1.removeFaculty(asstProf2);
		System.out.println(" Faculty reporting to Prof 1 are *****");
		prof1.printAllReportees();
		
	}

}
