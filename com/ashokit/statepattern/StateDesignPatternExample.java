package com.ashokit.statepattern;


public class StateDesignPatternExample {

	public static void main(String[] args) 
    {
        DeliveryContext ctx = new DeliveryContext(null, "Test123");
                      
        ctx.update();
        ctx.update();
        ctx.update();
        ctx.update();
        ctx.update();
    }
}


interface OrderState 
{
    public void updateState(DeliveryContext ctx);
}

class RefundOrReturn implements OrderState {

    private static RefundOrReturn instance = new RefundOrReturn();

	@Override
	public void updateState(DeliveryContext ctx) {
		System.out.println(" Status is Refunded or Returned");
		
	}
	public static RefundOrReturn instance() {
        return instance;
    }
	
}
class OrderConfirmed implements OrderState 
{
    //Singleton
    private static OrderConfirmed instance = new OrderConfirmed();
 
    private OrderConfirmed() {}
 
    public static OrderConfirmed instance() {
        return instance;
    }
     
    //Business logic and state transition
    @Override
    public void updateState(DeliveryContext ctx) 
    {
        System.out.println("Order is Confirmed !!");
        ctx.setCurrentState(Shipped.instance());
    }
}

class Shipped implements OrderState 
{
    //Singleton
    private static Shipped instance = new Shipped();
 
    private Shipped() {}
 
    public static Shipped instance() {
        return instance;
    }
     
    //Business logic and state transition
    @Override
    public void updateState(DeliveryContext ctx) 
    {
        System.out.println("Order is shipped !!");
        ctx.setCurrentState(InTransition.instance());
    }
}

class InTransition implements OrderState 
{
    //Singleton
    private static InTransition instance = new InTransition();
 
    private InTransition() {}
 
    public static InTransition instance() {
        return instance;
    }
     
    //Business logic and state transition
    @Override
    public void updateState(DeliveryContext ctx) 
    {
        System.out.println("Order is in transition !!");
        ctx.setCurrentState(OutForDelivery.instance());
    }
}

class OutForDelivery implements OrderState 
{
    //Singleton
    private static OutForDelivery instance = new OutForDelivery();
 
    private OutForDelivery() {}
 
    public static OutForDelivery instance() {
        return instance;
    }
     
    //Business logic and state transition
    @Override
    public void updateState(DeliveryContext ctx) 
    {
        System.out.println("Order is out of delivery !!");
        ctx.setCurrentState(Delivered.instance());
    }
}

class Delivered implements OrderState 
{
    //Singleton
    private static Delivered instance= new Delivered();
 
    public Delivered() {
		// TODO Auto-generated constructor stub
	}
    public static Delivered instance() {
        return instance;
    }
     
    //Business logic
    @Override
    public void updateState(DeliveryContext ctx) 
    {
        System.out.println("Order is delivered!!");
        //if the product is damaged
        ctx.setCurrentState(RefundOrReturn.instance());
    }
}

class DeliveryContext {
    
    private OrderState currentState;
    private String orderName;
     
    public DeliveryContext(OrderState currentState, String orderName) 
    {
        super();
        this.currentState = currentState;
        this.orderName = orderName;
         
        if(currentState == null) {
            this.currentState = OrderConfirmed.instance();
        }
    }
 
    public OrderState getCurrentState() {
        return currentState;
    }
 
    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
    }
     
    public String getOrderName() {
        return orderName;
    }
 
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
 
    public void update() {
        currentState.updateState(this);
    }
}
