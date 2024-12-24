package com.ashokit.designpatterns;

public class FactoryPatternExample {
//H2
	public static void main(String[] args) {
		Factory f= new Factory();
		Notification n= f.createNotification("SMS");
		n.notifi();
		Notification n1= f.createNotification("Email");
		n1.notifi();
		Notification n2= f.createNotification("Push");
		n2.notifi();
	}
}

interface Notification{
	public void notifi();//DBImplemtion()
}

class SMSNotification implements Notification{

	@Override
	public void notifi() {//H2 DB connection using JPA
		System.out.println("Triggering Notification through SMS");
		
	}
	
}

class EmailNotification implements Notification{

	@Override
	public void notifi() {//MOngo DB 
		System.out.println("Triggering Notification through Email");
		
	}	
}

class PushNotification implements Notification{

	@Override
	public void notifi() {
		System.out.println("Triggering Notification through Push");
		
	}	
}

class Factory {
	
	public Notification createNotification(String mode) {
		if(mode.equalsIgnoreCase("SMS")) {
			Notification n= new SMSNotification();
			return n;
		}
		if(mode.equalsIgnoreCase("Email")) {
			Notification n= new EmailNotification();
			return n;
		}
		if(mode.equalsIgnoreCase("Push")) {
			Notification n= new PushNotification();
			return n;
		}
		return null;
	}	
}

