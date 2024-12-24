package t2;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {
		EcommerceFacade ecommerce = new EcommerceSystemFacade();

		// Add items to cart
		ecommerce.addToCart("1001", 2);
		ecommerce.addToCart("1002", 1);

		// Remove item from cart
		ecommerce.removeItemFromCart("1001");

		// Checkout
		ecommerce.checkout("Credit Card");

	}
}

 interface EcommerceFacade {
    void addToCart(String productId, int quantity);
    void removeItemFromCart(String productId);
    void checkout(String paymentMethod);
}

 class EcommerceSystemFacade implements EcommerceFacade {
    private final ProductCatalog catalog;
    private final ShoppingCart cart;
    private final OrderProcessor processor;

    public EcommerceSystemFacade() {
        this.catalog = new ProductCatalog();
        this.cart = new ShoppingCart();
        this.processor = new OrderProcessor();
    }

    @Override
    public void addToCart(String productId, int quantity) {
        Product product = catalog.getProduct(productId);
        cart.addItem(product, quantity);
    }

    @Override
    public void removeItemFromCart(String productId) {
        Product product = catalog.getProduct(productId);
        cart.removeItem(product);
    }

    @Override
    public void checkout(String paymentMethod) {
        Order order = new Order(cart.getItems());
        Payment payment = PaymentFactory.createPayment(paymentMethod);
        processor.processOrder(order, payment);
    }
}
 
class Product {
	    private final String id;
	    private final String name;
	    private final double price;

	    public Product(String id, String name, double price) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getPrice() {
	        return price;
	    }
	}


 class ProductCatalog {
    private final Map<String, Product> products;

    public ProductCatalog() {
        this.products = new HashMap<>();
        // Add some initial products to the catalog
        products.put("1001", new Product("1001", "Maggii", 10.0));
        products.put("1002", new Product("1002", "Santoor soap", 20.0));
        products.put("1003", new Product("1003", "Pasta", 30.0));
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }
}

 class ShoppingCart {
    private final Map<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        int currentQuantity = items.getOrDefault(product, 0);
        items.put(product, currentQuantity + quantity);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}

 class Order {
    private final Map<Product, Integer> items;
    private final LocalDateTime orderTime;

    public Order(Map<Product, Integer> items) {
        this.items = items;
        this.orderTime = LocalDateTime.now();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }
}

 class PaymentFactory {
    public static Payment createPayment(String paymentMethod) {
        // Create a payment object based on the payment method
        if (paymentMethod.equals("Credit Card")) {
            return new CreditCardPayment();
        } else if (paymentMethod.equals("PayPal")) {
            return new PayPalPayment();
        } else {
            throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
        }
    }
}

interface Payment {
    void pay(double amount);
}

 class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        // Process the payment using a credit card
        System.out.println("Payment of $" + amount + " processed using credit card");
    }
}

 class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        // Process the payment using PayPal
        System.out.println("Payment of $" + amount + " processed using PayPal");
    }
}

  class OrderProcessor {
	    public void processOrder(Order order, Payment payment) {
	        //Invoice invoice = new Invoice(order, payment);
	        // Process the order and generate the invoice
	        // ...
	        System.out.println("Order processed successfully!");
	        System.out.println("Invoice details: ");
	       // System.out.println(invoice);
	    }
	}

