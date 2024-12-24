package com.ashokit.bridge;

public interface PaymentGateway {
	void processPayment(double amount);
	void refundAmount(double amount);
}
