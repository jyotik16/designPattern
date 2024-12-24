package com.ashokit.oberserverpattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
	
	public static void main(String[] args) {
		
		Customer karthik=new Customer("Karthik");
		Customer Babu=new Customer("Babu");
		Customer Rajesh=new Customer("Rajesh");
		Customer Harish=new Customer("Harish");
		Customer Arnab=new Customer("Arnab");
		Customer Rashid=new Customer("Rashid");
		Customer SaiRaj=new Customer("SaiRaj");
		
		InsuranceCompany LIC= new InsuranceCompany("LIC");
		InsuranceCompany TATA= new InsuranceCompany("TATA AIA");
		
		LIC.addSubscriber(karthik);
		LIC.addSubscriber(Babu);
		LIC.addSubscriber(Rajesh);
		LIC.addSubscriber(Harish);
		LIC.addSubscriber(SaiRaj);
		
		TATA.addSubscriber(Arnab);
		TATA.addSubscriber(Rashid);
		TATA.addSubscriber(karthik);
		
		LIC.broadCastMessage("Hi EVeryone-> New Policy called Jeevan Ananad is interduced");
		TATA.broadCastMessage("Hey TATA Website is not available from 12 AM to 1 AM. please plan to pay your premium accordingly");
		
	}

}

//Insurance

interface NotifyCustomerInterface{
	void noftication(String tweet);
}

class Customer implements NotifyCustomerInterface{
	String name;
	Customer(String name){
		this.name=name;
	}
	@Override
	public void noftication(String tweet) {
		System.out.println(name+" has Notification received "+tweet);
		
	}
}

interface ManageSubscribersAndNotify{
	
	public void addSubscriber(NotifyCustomerInterface r);
	
	public void removeSubscriber(NotifyCustomerInterface r);
	
	public void notifyAllSubscribers(String message);
}

class InsuranceCompany implements ManageSubscribersAndNotify{
	
	String insuranceCompanyname;
	InsuranceCompany(String name){
		this.insuranceCompanyname=name;
	}
	
	List<NotifyCustomerInterface> subscriberList= new ArrayList<>();

	@Override
	public void addSubscriber(NotifyCustomerInterface r) {
		// TODO Auto-generated method stub
		subscriberList.add(r);
		
	}

	@Override
	public void removeSubscriber(NotifyCustomerInterface r) {
		// TODO Auto-generated method stub
		subscriberList.remove(r);
		
	}

	@Override
	public void notifyAllSubscribers(String message) {
		// TODO Auto-generated method stub
		subscriberList.forEach(f->f.noftication(message));
	}
	
	public void broadCastMessage(String message) {
		notifyAllSubscribers(message);
	}
	
	
}
