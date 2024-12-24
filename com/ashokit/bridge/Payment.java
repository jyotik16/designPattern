package com.ashokit.bridge;



public interface Payment {
	void makePayment(double amount);
	 void setPaymentGateway(PaymentGateway paymentGateway);
}
