package com.ashokit.decoratordesignpattern;

import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DecoratorPatternExample {

	public static void main(String[] args) {
		BasicPlan karthikPolicy= new BasePolicy();
		System.out.println(karthikPolicy.getPremium());
		System.out.println(karthikPolicy.policyDetails());
		
		BasicPlan AjayPolicy= new BasePolicy();
		System.out.println(AjayPolicy.getPremium());
		System.out.println(AjayPolicy.policyDetails());
		
		BasicPlan rahulPolicy= new BasePolicy();//1566+
		System.out.println(rahulPolicy.getPremium());
		System.out.println(rahulPolicy.policyDetails());
		
		AjayPolicy =new AccidentalBenefit(AjayPolicy);
		System.out.println(AjayPolicy.getPremium());
		System.out.println(AjayPolicy.policyDetails());
		
		System.out.println(karthikPolicy.getPremium());
		System.out.println(karthikPolicy.policyDetails());
		
		
		
		AjayPolicy=new CriticalBenefit(AjayPolicy);
		System.out.println(AjayPolicy.getPremium());
		System.out.println(AjayPolicy.policyDetails());
		
		System.out.println(karthikPolicy.getPremium());
		System.out.println(karthikPolicy.policyDetails());
		
	}
}

interface BasicPlan{
	int getPremium();
	String policyDetails();
}

class BasePolicy implements BasicPlan{

	@Override
	public int getPremium() {
		// TODO Auto-generated method stub
		return 1566;
	}

	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		
		return "This is a Basic cover ";
	}
	
}

abstract class PolicyDecorator implements BasicPlan{
	BasicPlan basicPlan;
	PolicyDecorator(BasicPlan basicPlan){
		this.basicPlan=basicPlan;
	}
	
	@Override
	public int getPremium() {
		// TODO Auto-generated method stub
		return basicPlan.getPremium();
	}
	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return basicPlan.policyDetails();
	}
	
}

class AccidentalBenefit extends PolicyDecorator{

	AccidentalBenefit(BasicPlan basicPlan) {
		super(basicPlan);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getPremium() {
		// TODO Auto-generated method stub
		return super.getPremium()+58;
	}
	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return super.policyDetails()+ "Extra Accidental cover is provided";
	}
	
}

class CriticalBenefit extends PolicyDecorator{

	CriticalBenefit(BasicPlan basicPlan) {
		super(basicPlan);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getPremium() {
		// TODO Auto-generated method stub
		return super.getPremium()+650;
	}
	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return super.policyDetails()+ "Another Critical illness cover is provided";
	}
	
}
