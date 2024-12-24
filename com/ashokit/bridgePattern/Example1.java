package com.ashokit.bridgePattern;

public class Example1 {

	public static void main(String[] args) {

	     PaymentGateway paypalGateway = new PayPalGateway();
	     PaymentGateway stripeGateway = new StripeGateway();

	     Payment onlinePaymentWithPaypal = new OnlinePayment();
	     onlinePaymentWithPaypal.setPaymentGateway(paypalGateway);
	     onlinePaymentWithPaypal.makePayment(100.0);

	     Payment onlinePaymentWithStripe = new OnlinePayment();
	     onlinePaymentWithStripe.setPaymentGateway(stripeGateway);
	     onlinePaymentWithStripe.makePayment(150.0);
	 
	}
}

//Abstraction Interface
interface Payment {
 void makePayment(double amount);
 void setPaymentGateway(PaymentGateway paymentGateway);
}

//Refined Abstraction
class OnlinePayment implements Payment {
 private PaymentGateway paymentGateway;

 public void makePayment(double amount) {
     paymentGateway.processPayment(amount);
 }

 public void setPaymentGateway(PaymentGateway paymentGateway) {
     this.paymentGateway = paymentGateway;
 }
}

//Implementor Interface
interface PaymentGateway {
 void processPayment(double amount);
}

//Concrete Implementor 1
class PayPalGateway implements PaymentGateway {
 public void processPayment(double amount) {
     System.out.println("Processing payment of " + amount + " using PayPal Gateway.");
 }
}

//Concrete Implementor 2
class StripeGateway implements PaymentGateway {
 public void processPayment(double amount) {
     System.out.println("Processing payment of " + amount + " using Stripe Gateway.");
 }
}

//Client Code
/*
 * public class EcommerceClient { public static void main(String[] args) {
 * PaymentGateway paypalGateway = new PayPalGateway(); PaymentGateway
 * stripeGateway = new StripeGateway();
 * 
 * Payment onlinePaymentWithPaypal = new OnlinePayment();
 * onlinePaymentWithPaypal.setPaymentGateway(paypalGateway);
 * onlinePaymentWithPaypal.makePayment(100.0);
 * 
 * Payment onlinePaymentWithStripe = new OnlinePayment();
 * onlinePaymentWithStripe.setPaymentGateway(stripeGateway);
 * onlinePaymentWithStripe.makePayment(150.0); } }
 */

