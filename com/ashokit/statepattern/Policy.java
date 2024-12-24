package com.ashokit.statepattern;

public class Policy {

	private PolicyStatus policyStatus;
	
	public Policy(PolicyStatus policyStatus) {
		// TODO Auto-generated constructor stub
		this.policyStatus=policyStatus;
	}

	public void setPolicyStatus(PolicyStatus policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	public PolicyStatus getPolicyStatus() {
		return policyStatus;
	}
	
	public void expire() {
		policyStatus.expirePolicy(this);
	}
	public void cancel() {
		policyStatus.cancelPolicy(this);
	}
	public void renew() {
		policyStatus.renewPolicy(this);
	}
}
