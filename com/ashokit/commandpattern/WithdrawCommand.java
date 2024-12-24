package com.ashokit.commandpattern;

public class WithdrawCommand implements Command{
	Account a=null;
	double amount=0;
	WithdrawCommand(Account a,double amount){
		this.a=a;
		this.amount=amount;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub		
		a.withdraw(amount);
	}

}
