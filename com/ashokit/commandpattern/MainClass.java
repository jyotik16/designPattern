package com.ashokit.commandpattern;

public class MainClass {
	
	public static void main(String[] args) {
		
		Account a= new Account();
		Account b= new Account();
		Command deposit=new DepositCommand(a, 1000);
		deposit.execute();
		Command withdraw=new WithdrawCommand(a, 100);
		withdraw.execute();		
		Command transfer = new TransferCommand(a, b, 350);
		transfer.execute();		
		
	}

}
