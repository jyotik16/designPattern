package com.ashokit.templatedesignpattern;

public class TemplateDesignPattern {
	 public static void main(String[] args) {
		 Account a= new Account("Karthik", 10000);
		 Transaction t= new DebitTransaction(a);
		 t.templateMethod(2000);
		 Transaction t1= new CreditTransaction(a);
		 t1.templateMethod(3000);
		 
	}

}

abstract class Transaction {


	public final void templateMethod(double amt) {
		/*
		 * if(authenticate()) { if(validateInput()) { if(performTransaction(amt)) {
		 * if(updateLogsDB()) { notifyUser(); } } } }
		 */
		if(authenticate() && validateInput() && performTransaction(amt) && updateLogsDB()){
			notifyUser();		 
		}
	}

	public abstract boolean authenticate();
	public abstract boolean validateInput();
	public abstract boolean performTransaction(double amt);
	public  boolean updateLogsDB() {
		System.out.println("DB Update/Logs update");
		return true;
	}
	public  boolean notifyUser() {
		System.out.println("Successful/Failure Transaction");
		return true;
	}
}

class DebitTransaction extends Transaction{
	
	Account a;
	DebitTransaction(Account a){
		this.a=a;
	}

	@Override
	public boolean authenticate() {
		// TODO Auto-generated method stub
		System.out.println("DEBIT Authenticate");
		return true;
		
	}

	@Override
	public boolean validateInput() {
		// TODO Auto-generated method stub
		System.out.println("Validated and amount is not negative");
		return true;
		
	}

	@Override
	public boolean performTransaction(double amt) {
		// TODO Auto-generated method stub
		a.debitTransaction(amt);
		return true;
	}
	
	
	
}

class CreditTransaction extends Transaction{
	
	Account a;
	CreditTransaction(Account a){
		this.a=a;
	}

	@Override
	public boolean authenticate() {
		// TODO Auto-generated method stub
		System.out.println("CREDIT Authenticate");
		return true;
		
	}

	@Override
	public boolean validateInput() {
		// TODO Auto-generated method stub
		System.out.println("Validated and amount is not negative");
		return true;
		
	}

	@Override
	public boolean performTransaction(double amt) {
		// TODO Auto-generated method stub
		a.creditTransaction(amt);
		return true;
	}
	
	
	
}

class Account{
	String accountHolderName;
	double accountBalance;
	
	
	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Account(String name,double balance) {
		// TODO Auto-generated constructor stub
		this.accountHolderName=name;
		this.accountBalance=balance;
	}
	
	public void debitTransaction(double amtTobeDebited) {
		accountBalance=accountBalance-amtTobeDebited;
	}
	public void creditTransaction(double amtTobeDebited) {
		accountBalance=accountBalance+amtTobeDebited;
	}
}
