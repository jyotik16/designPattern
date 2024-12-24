package com.ashokit.strategydesignpattern;

public class StrategyDesignPatternBankExample {
	
	public static void main(String[] args) {
		Customer c= new Customer(new PreferredCustomer());
		c.showInterestRate();
		
		Customer c1= new Customer(new RegularCustomer());
		c1.showInterestRate();
		
		Customer c2= new Customer(new BankEmployee());
		c2.showInterestRate();
	}
	
	/*void interestType(CustomerType c) {
		boolean flag=false;
		if(c instanceof PreferredCustomer)
		{
			flag=true;
		} if(c instanceof RegularCustomer) {
			
		}else if(c instanceof BankEmployee) {
			
		}
	}*/

}

interface CustomerType{
	public void interestRate();
}

class PreferredCustomer implements CustomerType{
	@Override
	public void interestRate() {
		System.out.println("Interest Rate is 9.7%");
		
	}
}

class BankEmployee implements CustomerType{
	@Override
	public void interestRate() {
		System.out.println("Interest Rate is 5%");
		
	}
}

class RegularCustomer implements CustomerType {

	@Override
	public void interestRate() {
		System.out.println("Interest Rate is 10%");		
	}
	
}

class Customer {
	private CustomerType c;
	public Customer(CustomerType c) {
		// TODO Auto-generated constructor stub
		this.c=c;
	}
	
	void showInterestRate() {
		c.interestRate();
	}
}