package com.ashokit.chainofresponsibility;

import java.util.Scanner;

public class ChainOfRespATMExample {//BFSI
	//Life Sciences
	DispenceChain rack2000;
	ChainOfRespATMExample(){
		this.rack2000=new Notes2000Rack();		
		 DispenceChain rack500= new Notes500Rack();
		 DispenceChain rack100= new Notes100Rack();			
		 rack2000.chain(rack500); 
		 rack500.chain(rack100);
		
	}
	
	public static void main(String[] args) {
		ChainOfRespATMExample c= new ChainOfRespATMExample();
		while(true) {
			System.out.println(" Please enter the amount to be withdrawn");
			Scanner s= new Scanner(System.in);//2800
			int amount=s.nextInt();
			if(amount!=0) {				
				if(amount%100!=0) {
					System.out.println("Please enter multiples of 100");
					return;
				}else {
					c.rack2000.dispence(new Currency(amount));
				}
			}
		}
		
	}

}

class Currency{
	Currency(int amt){
		this.amount=amt;
	}
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}	
}

interface DispenceChain{
	void dispence(Currency currency);
	void chain(DispenceChain nextChain);
}

class Notes2000Rack implements DispenceChain{
	DispenceChain chain=null;
	@Override
	public void dispence(Currency currency) {
		// TODO Auto-generated method stub
		int noOf2000Notes=(int)currency.getAmount()/2000;
		System.out.println("Dispencing "+noOf2000Notes +" 2000 notes");
		int remainder=(int)currency.getAmount()%2000;
		if(remainder!=0) {
			this.chain.dispence(new Currency(remainder));
		}		
	}
	@Override
	public void chain(DispenceChain chain) {
		// TODO Auto-generated method stub		
		this.chain=chain;
		//DispenceChain chain=new Notes500Rack();
		
	}	
}

class Notes500Rack implements DispenceChain{
	DispenceChain chain=null;
	@Override
	public void dispence(Currency currency) {
		// TODO Auto-generated method stub
		int noOf500Notes=(int)currency.getAmount()/500;
		System.out.println("Dispencing "+noOf500Notes +" 500 notes");
		int remainder=(int)currency.getAmount()%500;
		if(remainder!=0) {
			chain.dispence(new Currency(remainder));
		}		
	}
	@Override
	public void chain(DispenceChain chain) {
		// TODO Auto-generated method stub		
		this.chain=chain;
		
	}		
}

class Notes100Rack implements DispenceChain{
	DispenceChain chain;
	@Override
	public void dispence(Currency currency) {
		// TODO Auto-generated method stub
		int noOf100Notes=(int)currency.getAmount()/100;
		System.out.println("Dispencing "+noOf100Notes +" 100 notes");
		int remainder=(int)currency.getAmount()%100;
		if(remainder!=0) {
			chain.dispence(currency);;
		}		
	}
	@Override
	public void chain(DispenceChain chain) {
		// TODO Auto-generated method stub		
		this.chain=chain;
		
	}		
}
