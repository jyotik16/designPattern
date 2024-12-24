package t2;

//Subject interface
interface Policy {
 void getPolicyDetails();
}

//Real subject
class InsuranceCompany implements Policy {
 private String policyHolderName;
 private String policyType;
 private int coverageAmount;
 private int deductible;
 private String insuranceCompany;

 public InsuranceCompany(String policyHolderName, String policyType, int coverageAmount, int deductible, String insuranceCompany) {
     this.policyHolderName = policyHolderName;
     this.policyType = policyType;
     this.coverageAmount = coverageAmount;
     this.deductible = deductible;
     this.insuranceCompany = insuranceCompany;
 }

 @Override
 public void getPolicyDetails() {
     System.out.println("Policy details for " + policyHolderName + ":");
     System.out.println("Policy type: " + policyType);
     System.out.println("Coverage amount: " + coverageAmount);
     System.out.println("Deductible: " + deductible);
     System.out.println("Insurance company: " + insuranceCompany);
 }
}

//Proxy class
class InsuranceAgent implements Policy {
 private Policy insuranceCompany;

 public InsuranceAgent(String policyHolderName, String policyType, int coverageAmount, int deductible, String insuranceCompany) {
     this.insuranceCompany = new InsuranceCompany(policyHolderName, policyType, coverageAmount, deductible, insuranceCompany);
 }

 @Override
 public void getPolicyDetails() {
     System.out.println("Additional services provided by insurance agent:");
     System.out.println("- Policy recommendations");
     System.out.println("- Claims assistance");

     insuranceCompany.getPolicyDetails();
 }
}

//Client code
public class proxyExample {
 public static void main(String[] args) {
     Policy policy = new InsuranceAgent("John Doe", "Auto", 50000, 1000, "ABC Insurance");
     policy.getPolicyDetails();
 }
}

