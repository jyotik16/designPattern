package com.ashokit.designpatterns;

public class ChainOfResponsibilityExample {
	
	public static void main(String[] args) {
		m1();
	}
	static void m1() {
		try {
		m2();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
static void m2() {
		m3();
	}
static void m3() {
	int c=10/0;
}

	

}
