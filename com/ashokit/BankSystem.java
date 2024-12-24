package com.ashokit;

// Abstract Factory Interface
 interface TypeOfAccount {
    public SavingAccount createSavingAccount();
    public CurrentAccount createCurrentAccount();
}

// Concrete Factory for India
 class BankInIndia implements TypeOfAccount {
    public SavingAccount createSavingAccount() {
        return new IndiaSavingAccount();
    }
    public CurrentAccount createCurrentAccount() {
        return new IndiaCurrentAccount();
    }
}

// Concrete Factory for USA
 class BankInUSA implements TypeOfAccount {
    public SavingAccount createSavingAccount() {
        return new USASavingAccount();
    }
    public CurrentAccount createCurrentAccount() {
        return new USACurrentAccount();
    }
}

 class BankFactory{
	 static public TypeOfAccount getAccountType(String accntType) {
		 if(accntType.equalsIgnoreCase("INDIASAVINGS")) {
			 return new BankInIndia();
		 }
		 if(accntType.equalsIgnoreCase("USASAVINGS")) {
			 return new BankInUSA();
		 }
		 return null;
	 }
 }
// Abstract Product Class - Saving Account
 abstract class SavingAccount {
    public abstract String getAccountType();
    public abstract double getInterestRate();
}

// Concrete Product for India
 class IndiaSavingAccount extends SavingAccount {
    public String getAccountType() {
        return "India Saving Account";
    }
    public double getInterestRate() {
        return 5.0;
    }
}

// Concrete Product for USA
 class USASavingAccount extends SavingAccount {
    public String getAccountType() {
        return "USA Saving Account";
    }
    public double getInterestRate() {
        return 2.0;
    }
}

// Abstract Product Class - Current Account
 abstract class CurrentAccount {
    public abstract String getAccountType();
    public abstract double getInterestRate();
}

// Concrete Product for India
 class IndiaCurrentAccount extends CurrentAccount {
    public String getAccountType() {
        return "India Current Account";
    }
    public double getInterestRate() {
        return 3.0;
    }
}

// Concrete Product for USA
 class USACurrentAccount extends CurrentAccount {
    public String getAccountType() {
        return "USA Current Account";
    }
    public double getInterestRate() {
        return 1.0;
    }
}

// Client Code
public class BankSystem {
    public static void main(String[] args) {
    	
    	BankFactory.getAccountType();
        TypeOfAccount indiaBankFactory = new BankInIndia();
        TypeOfAccount usaBankFactory = new BankInUSA();

        SavingAccount indiaSavingAccount = indiaBankFactory.createSavingAccount();
        CurrentAccount indiaCurrentAccount = indiaBankFactory.createCurrentAccount();

        SavingAccount usaSavingAccount = usaBankFactory.createSavingAccount();
        CurrentAccount usaCurrentAccount = usaBankFactory.createCurrentAccount();

        System.out.println("India Bank Accounts: ");
        System.out.println(indiaSavingAccount.getAccountType() + ", Interest Rate: " + indiaSavingAccount.getInterestRate());
        System.out.println(indiaCurrentAccount.getAccountType() + ", Interest Rate: " + indiaCurrentAccount.getInterestRate());

        System.out.println("USA Bank Accounts: ");
        System.out.println(usaSavingAccount.getAccountType() + ", Interest Rate: " + usaSavingAccount.getInterestRate());
        System.out.println(usaCurrentAccount.getAccountType() + ", Interest Rate: " + usaCurrentAccount.getInterestRate());
    }
}

