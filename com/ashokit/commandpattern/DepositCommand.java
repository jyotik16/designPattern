package com.ashokit.commandpattern;

public class DepositCommand implements Command{
	Account a=null;
	double amount=0;
	DepositCommand(Account a,double amount){
		this.a=a;
		this.amount=amount;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub		
		a.deposit(amount);
	}

}
