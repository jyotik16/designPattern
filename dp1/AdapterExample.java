
public class AdapterExample {

	public static void main(String[] args) {
		NewPaymentGateway newPaymentGateway = new NewPaymentGatewayImpl();

		//Create an adapter for the legacy payment gateway
		LegacyPaymentGateway legacyPaymentGateway = new PaymentGatewayAdapter(newPaymentGateway);

		//Use the legacy payment gateway interface to process payments
		boolean paymentProcessed = legacyPaymentGateway.processPayment("1234-5678-9012-3456", 100.0);

	}
}


//Legacy Payment Gateway interface
interface LegacyPaymentGateway {
 public boolean processPayment(String creditCardNumber, double amount);
}

//New Payment Gateway interface
interface NewPaymentGateway {
 public boolean authorize(String creditCardNumber, double amount);
}

//Adapter class
class PaymentGatewayAdapter implements LegacyPaymentGateway {
 private NewPaymentGateway newPaymentGateway;

 PaymentGatewayAdapter(NewPaymentGateway newPaymentGateway) {
     this.newPaymentGateway = newPaymentGateway;
 }

 public boolean processPayment(String creditCardNumber, double amount) {
     boolean authorized = newPaymentGateway.authorize(creditCardNumber, amount);
     if (authorized) {
         System.out.println("Payment authorized and processed by the new payment gateway");
         return true;
     } else {
         System.out.println("Payment authorization failed");
         return false;
     }
 }
}

class NewPaymentGatewayImpl implements NewPaymentGateway {
    public boolean authorize(String accountNumber, double amount) {
        System.out.println("Initiating payment using New payment gateway...");
        // Implementation details...
        return true;
    }

	
}

//Usage
//Create a new instance of the new payment gateway
