package com.ashokit.bridgePattern;


//Abstraction Interface
interface Payment1 {
 void makePayment(double amount);
 void setPaymentGateway(PaymentGateway1 paymentGateway);
}

//Refined Abstraction
class OnlinePayment1 implements Payment1 {
 private PaymentGateway1 paymentGateway;

 public void makePayment(double amount) {
     paymentGateway.processPayment(amount);
 }

 public void setPaymentGateway(PaymentGateway1 paymentGateway) {
     this.paymentGateway = paymentGateway;
 }
}

//Implementor Interface
interface PaymentGateway1 {
 void processPayment(double amount);
 void refundPayment(double amount);
}

//Concrete Implementor 1
class PayPalGateway1 implements PaymentGateway1 {
 public void processPayment(double amount) {
     System.out.println("Processing payment of " + amount + " using PayPal Gateway.");
 }
 public void refundPayment(double amount) {
     System.out.println("Refunding payment of " + amount + " using PayPal Gateway.");
 }
}

//Concrete Implementor 2
class StripeGateway1 implements PaymentGateway1 {
 public void processPayment(double amount) {
     System.out.println("Processing payment of " + amount + " using Stripe Gateway.");
 }
 public void refundPayment(double amount) {
     System.out.println("Refunding payment of " + amount + " using Stripe Gateway.");
 }
}

//Client Code
public class ModifyImplementationLayer {
 public static void main(String[] args) {
     PaymentGateway1 paypalGateway = new PayPalGateway1();
     PaymentGateway1 stripeGateway = new StripeGateway1();

     Payment1 onlinePaymentWithPaypal = new OnlinePayment1();
     onlinePaymentWithPaypal.setPaymentGateway(paypalGateway);
     onlinePaymentWithPaypal.makePayment(100.0);
     ((PayPalGateway1) paypalGateway).refundPayment(50.0);

     Payment1 onlinePaymentWithStripe = new OnlinePayment1();
     onlinePaymentWithStripe.setPaymentGateway(stripeGateway);
     onlinePaymentWithStripe.makePayment(150.0);
     ((StripeGateway1) stripeGateway).refundPayment(75.0);
 }
}


