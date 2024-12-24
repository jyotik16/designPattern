

public class DecoratorExample {

	public static void main(String[] args) {
		BasicPolicy b= new SimpleBasicPolicy();
		BasicPolicy b1= new SimpleBasicPolicy();
		System.out.println(b.getCost() +" "+b.policyDetails());
		
		b=new AccidentalInsuranceRider(b);
		System.out.println(b.getCost() +" "+b.policyDetails());
		b=new CriticalIllnessRider(b);
		System.out.println(b.getCost() +" "+b.policyDetails());
		
	}
}

interface BasicPolicy{
	double getCost();
	String policyDetails();
}

class InsuranceDecorator implements BasicPolicy{
	
	BasicPolicy bs=null;
	InsuranceDecorator(BasicPolicy b){
		this.bs=b;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return bs.getCost();
	}

	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return bs.policyDetails();
	}
	
}

class SimpleBasicPolicy implements BasicPolicy{

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return "Basic Cover";
	}
	
}

class AccidentalInsuranceRider extends InsuranceDecorator{

	AccidentalInsuranceRider(BasicPolicy b) {
		super(b);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return super.getCost()+1000;
	}
	
	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return super.policyDetails()+" Accidental Rider";
	}
	
}

class CriticalIllnessRider extends InsuranceDecorator{

	CriticalIllnessRider(BasicPolicy b) {
		super(b);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return super.getCost()+10000;
	}
	
	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return super.policyDetails()+" Critical Illness Rider";
	}
	
}