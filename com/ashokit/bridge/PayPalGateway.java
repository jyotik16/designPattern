package com.ashokit.bridge;

public class PayPalGateway implements PaymentGateway{

	@Override
	public void processPayment(double amount) {
		System.out.println("process payment of paypalgateway -processed amount "+amount);
		
	}

	@Override
	public void refundAmount(double amount) {
		// TODO Auto-generated method stub
		
	}

}
