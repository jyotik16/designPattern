package com.ashokit.bridge;

public class MainClass {

	public static void main(String[] args) {
		
		Payment app= new OnlinePayment();
		app.setPaymentGateway(new PayPalGateway());		
		app.makePayment(100);
		
		
		app.setPaymentGateway(new BillDeskPaymentGateway());		
		app.makePayment(100);
				
	}
}
