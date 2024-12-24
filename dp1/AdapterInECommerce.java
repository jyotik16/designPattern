
public class AdapterInECommerce {

}


//Payment gateway interface
interface PaymentGateway {
 public void processPayment(String paymentToken, double amount);
}

//New e-commerce system interface
interface EcommerceSystem {
 public void createOrder(String orderId, double amount);
}

//Payment gateway implementation
class PaymentGatewayImpl implements PaymentGateway {
 public void processPayment(String paymentToken, double amount) {
     System.out.println("Processing payment of " + amount + " using payment gateway...");
     // Implementation details...
 }
}

//Adapter class
class EcommerceSystemPaymentGatewayAdapter implements EcommerceSystem {
 private PaymentGateway paymentGateway;

 public EcommerceSystemPaymentGatewayAdapter(PaymentGateway paymentGateway) {
     this.paymentGateway = paymentGateway;
 }

 public void createOrder(String orderId, double amount) {
     String paymentToken = generatePaymentToken(orderId, amount);
     paymentGateway.processPayment(paymentToken, amount);
 }

 private String generatePaymentToken(String orderId, double amount) {
     // Implementation details...
     return "PAYMENT_TOKEN";
 }
}

