package com.ashokit;

public class Test {

}

interface Location{
	public void location();
}

class USA implements Location{

	@Override
	public void location() {
		// TODO Auto-generated method stub
		
	}
	
}

class India implements Location{

	@Override
	public void location() {
		// TODO Auto-generated method stub
		
	}
	
}

class USABankFactory{
	static ServiceType buildAccountService(String typeOfService) {
		if(typeOfService.equalsIgnoreCase("BANKACCNTSERVICE")) {
			return new BankAccntService();
		}
		return null;
	}
}

class Factory{
	static ServiceType buildBank(String location) {
		if(location.equalsIgnoreCase("USA"))
        {
        
        	ServiceType s= USABankFactory.buildAccountService("BANKACCNTSERVICE");
        	return s;
        }else if(location.equalsIgnoreCase("India")) {
        	ServiceType s1 = IndiaBankFactory.buildAccountService("BANKACCNTSERVICE");
            return s;
        }
		return null;
	}
}

interface ServiceType{
	public void typeOfService();
	public void interestRate();
}

class BankAccntService implements ServiceType{

	@Override
	public void typeOfService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interestRate() {
		// TODO Auto-generated method stub
		
	}
	
}
class CreditAccntService implements ServiceType{

	@Override
	public void typeOfService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interestRate() {
		// TODO Auto-generated method stub
		
	}
	
}
class PersonalAccntService implements ServiceType{

	@Override
	public void typeOfService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interestRate() {
		// TODO Auto-generated method stub
		
	}
	
}


