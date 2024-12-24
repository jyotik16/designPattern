package com.ashokit.bridge;

public class BillDeskPaymentGateway implements PaymentGateway {

	@Override
	public void processPayment(double amount) {
		// TODO Auto-generated method stub
		System.out.println("process payment of BillDeskPaymentGateway -processed amount "+amount);

		
	}

	@Override
	public void refundAmount(double amount) {
		// TODO Auto-generated method stub
		
	}

}
