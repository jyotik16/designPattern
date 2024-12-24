package com.ashokit.commandpattern;

public class TransferCommand implements Command{
	Account fromAccount=null;
	Account toAccount=null;
	double amount=0;
	TransferCommand(Account fromAccount,Account toAccount,double amount){
		this.fromAccount=fromAccount;
		this.toAccount=toAccount;
		this.amount=amount;
	}
//KARTHIK is transfering 350 to BABU
	//from  account is :karthik ->
	//to account is :babu
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		fromAccount.withdraw(amount);
		toAccount.deposit(amount);
		System.out.println(" Amount "+amount+" is transferred from "+fromAccount+" to "+toAccount);
		
	}

}
