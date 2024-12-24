package com.ashokit.builderdesignpattern;

public class UserWithoutBUilder {
	
	final private String firstName;//required
	private String lastName;//required
	private int age;//not required
	private long mobile;//not required
	//15 files -19 fileds
	// User - as Immutable class
	
	public UserWithoutBUilder(String firstName, String lastName, int age, int mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;//NULL<->0
		this.mobile = mobile;
	}
	

	public UserWithoutBUilder(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}




	public UserWithoutBUilder(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}




	public UserWithoutBUilder(String firstName, String lastName, long mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
	}




	public static void main(String[] args) {
		//fn,ln,age and mobile
		//fn ln -
		//fn ln,age
		//fn, ln ,mobile
		
		UserWithoutBUilder u= new UserWithoutBUilder("karthik", "sdsdsd", 03232232323, 12);
	}

}
