package com.ashokit.statepattern;


public class CancelPolicyStatus implements PolicyStatus{

	@Override
	public void expirePolicy(Policy policy) {
		// TODO Auto-generated method stub
		System.out.println("Policy status is changed to Expired");
	}

	@Override
	public void cancelPolicy(Policy policy) {
		// TODO Auto-generated method stub
		System.out.println("Policy status is changed to Cancel");
		
	}

	@Override
	public void renewPolicy(Policy policy) {
		// TODO Auto-generated method stub
	     policy.setPolicyStatus(new ActivePolicyStatus());

	}

}
