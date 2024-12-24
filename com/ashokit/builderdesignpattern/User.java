package com.ashokit.builderdesignpattern;

public class User {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FirstName is "+firstName+" LastName is "+lastName;
	}
	
	User(UserBuilder ub){
		this.firstName=ub.firstName;
		this.lastName=ub.lastName;
		this.age=ub.age;
		this.mobile=ub.mobile;
	}

	final private String firstName;//required
	final private String lastName;//required
	final private int age;//not required
	final private long mobile;//not required
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public long getMobile() {
		return mobile;
	}
	
	
	static class UserBuilder{
		
		private String firstName;
		private String lastName;
		private int age;
		private long mobile;
		public UserBuilder(String firstName,String lastName) {
			// TODO Auto-generated constructor stub
			this.firstName=firstName;
			this.lastName=lastName;
		}
		
		public  UserBuilder age(int age) {
			this.age=age;
			return this;
		}
		public  UserBuilder mobile(long mobile) {
			this.mobile=mobile;
			return this;
		}
		
		 User build() {
			// TODO Auto-generated method stub

			 User u= new User(this);
			 return u;
		}
		
		
	}
	
	public static void main(String[] args) {
		//fn,ln,age and mobile
		User u= new User.UserBuilder("Karthik", "ABC").age(10).mobile(89898989).build();
		//u.firstName="dfdfdf";
		System.out.println(u+" hashcode is "+u.hashCode());
		//fn ln -
		User u1= new User.UserBuilder("Rajesh", "fdfdf").build();
		System.out.println(u1+" hashcode is "+u1.hashCode());
		//fn ln,age
		User u2= new User.UserBuilder("Shankar", "fdfdf").age(32).build();
		System.out.println(u2+" hashcode is "+u2.hashCode());
				//fn, ln ,mobile
		User u3= new User.UserBuilder("Harish", "fdfdf").mobile(32434343).build();
		System.out.println(u3+" hashcode is "+u3.hashCode());
	}
	
	
}
