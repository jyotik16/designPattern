package com.ashokit.designpatterns;

public class Thread1 extends Thread{

	public static void main(String[] args) {
		Thread1 t1= new Thread1();
		Thread1 t2= new Thread1();
		//Thread 
		//Thread is nothing but a independent path of execution with in a program
		t1.setName("Thread1");
		t2.setName("Thread2");
		t1.start();
		t2.start();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		SingletonDesignPattern s= SingletonDesignPattern.getInstance();
		System.out.println(Thread.currentThread().getName());
	}
}
