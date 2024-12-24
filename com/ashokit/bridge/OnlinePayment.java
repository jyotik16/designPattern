package com.ashokit.bridge;

public class OnlinePayment implements Payment{
	PaymentGateway paymentGateway=null;
	/*
	 * OnlinePayment(PaymentGateway paymentGateway){
	 * this.paymentGateway=paymentGateway; }
	 */

	@Override
	public void makePayment(double amount) {
		// TODO Auto-generated method stub
		paymentGateway.processPayment(amount);
		
	}

	@Override
	public void setPaymentGateway(PaymentGateway paymentGateway) {
		// TODO Auto-generated method stub
		this.paymentGateway=paymentGateway;
	}

}
