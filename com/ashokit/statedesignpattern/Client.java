package com.ashokit.statedesignpattern;

//State interface
 interface PolicyState {
 void expirePolicy(Policy policy);
 void cancelPolicy(Policy policy);
 void renewPolicy(Policy policy);
}

//Concrete states
 class ActivePolicyState implements PolicyState {
 @Override
 public void expirePolicy(Policy policy) {
     // Expire active policy
     policy.setPolicyState(new ExpiredPolicyState());
 }

 @Override
 public void cancelPolicy(Policy policy) {
     // Cancel active policy
     policy.setPolicyState(new CancelledPolicyState());
 }

 @Override
 public void renewPolicy(Policy policy) {
     // Renew active policy
     policy.setPolicyState(new ActivePolicyState());
 }
}

 class ExpiredPolicyState implements PolicyState {
 @Override
 public void expirePolicy(Policy policy) {
     // Do nothing, already expired
 }

 @Override
 public void cancelPolicy(Policy policy) {
     // Do nothing, already expired
 }

 @Override
 public void renewPolicy(Policy policy) {
     // Renew expired policy
     policy.setPolicyState(new ActivePolicyState());
 }
}

 class CancelledPolicyState implements PolicyState {
 @Override
 public void expirePolicy(Policy policy) {
     // Do nothing, already cancelled
 }

 @Override
 public void cancelPolicy(Policy policy) {
     // Do nothing, already cancelled
 }

 @Override
 public void renewPolicy(Policy policy) {
     // Renew cancelled policy
     policy.setPolicyState(new ActivePolicyState());
 }
}

//Context class
 class Policy {
 private PolicyState state;

 public Policy(PolicyState state) {
     this.state = state;
 }

 public void setPolicyState(PolicyState state) {
     this.state = state;
 }

 public void expirePolicy() {
     state.expirePolicy(this);
 }

 public void cancelPolicy() {
     state.cancelPolicy(this);
 }

 public void renewPolicy() {
     state.renewPolicy(this);
 }
}

//Client code
public class Client {
 public static void main(String[] args) {
     Policy policy = new Policy(new ActivePolicyState());
     policy.expirePolicy();

     policy.setPolicyState(new ExpiredPolicyState());
     policy.renewPolicy();

     policy.setPolicyState(new CancelledPolicyState());
     policy.renewPolicy();
 }
}

