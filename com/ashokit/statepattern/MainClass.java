package com.ashokit.statepattern;

public class MainClass {

	public static void main(String[] args) {
		Policy p= new Policy(new ActivePolicyStatus());
		p.cancel();
		
		Policy p1= new Policy(new CancelPolicyStatus());
		p.renew();
	}
}
