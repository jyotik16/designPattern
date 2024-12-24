package com.ashokit.statepattern;

public interface PolicyStatus {

	void expirePolicy(Policy policy);
	void cancelPolicy(Policy policy);
	void renewPolicy(Policy policy);
}
