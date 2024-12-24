package com.ashokit.statepattern;


public class ActivePolicyStatus implements PolicyStatus{

	
	@Override
	public void expirePolicy(Policy policy) {
		System.out.println(" current policy statis is "+this.toString()); 
		policy.setPolicyStatus(new ExpiredPolicyState());
		System.out.println(" current policy status is changed to "+this.toString());
		
	}

	@Override
	public void cancelPolicy(Policy policy) {
		// TODO Auto-generated method stub
		System.out.println(" current policy statis is "+this.toString()); 
	     policy.setPolicyStatus(new CancelPolicyStatus());
	     System.out.println(" current policy statis is "+policy.getPolicyStatus()); 
	}

	@Override
	public void renewPolicy(Policy policy) {
		System.out.println(" current policy statis is "+this.toString()); 
		// TODO Auto-generated method stub
	     policy.setPolicyStatus(new ActivePolicyStatus());
	     System.out.println(" current policy statis is "+this.toString()); 

	}

}
