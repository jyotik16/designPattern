package t1;

import java.io.Serializable;

public class SingletonDesignPattern implements Serializable,Cloneable{
	
	String name="Karthik";
	static int empId=123;
	//static SingletonDesignPattern s= new SingletonDesignPattern();//Eagar Initializtion
	//Lazy initialization
	static SingletonDesignPattern s=null;
	
	public static void main(String[] args) {
		//magical number check
		//load the class -> Class Loader
		//load, link ,initialize
		//3bootstrap-> rt.jar, system, extension->lib/ext
		//link->flag->true
	}
	private SingletonDesignPattern() throws Exception {
		//DB connection
		//getProperties.getInstance();
		if(s!=null) {
			throw new Exception();
		}
	}
	
	 static SingletonDesignPattern getInstance() throws Exception{
		System.out.println("hi");
		System.out.println("hi");
		System.out.println("hi");//Double Checked Locking
		if(s==null) {
			synchronized (SingletonDesignPattern.class) {
				if(s==null)
					s= new SingletonDesignPattern();
				return s;
			}
		}
		return s;
		
	}
	

	  Object readResolve(){ 
		  return s; 
		  }
	 
	  @Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return s;
		
	}

}
