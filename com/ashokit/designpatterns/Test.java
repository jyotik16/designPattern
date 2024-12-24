package com.ashokit.designpatterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public class Test{

	//Logger l= Logger.getLogger(null)
	public static void main(String[] args) throws Exception {
		SingletonDesignPattern s= SingletonDesignPattern.getInstance();
		SingletonDesignPattern s1= SingletonDesignPattern.getInstance();
		SingletonDesignPattern s2= SingletonDesignPattern.getInstance();
		//Logger l = new Logger();
		
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		//In java which class 
		Runtime r= Runtime.getRuntime();
		//during run it checks magical number check
		
		//Reflection
		//Cloning
		//Serialization
		//MultiThreading
		
		//1. Serializable interface
		//Objectout.-> WriteObject, readObject
	
		/*
		 * FileOutputStream f= new
		 * FileOutputStream("C:\\Users\\Dell\\Desktop\\serializableDoc.txt");
		 * ObjectOutputStream obj=new ObjectOutputStream(f); obj.writeObject(s);
		 * s.empId=456; //DeSerialization FileInputStream f1= new
		 * FileInputStream("C:\\Users\\Dell\\Desktop\\serializableDoc.txt");
		 * ObjectInputStream in= new ObjectInputStream(f1); SingletonDesignPattern
		 * s4=(SingletonDesignPattern)in.readObject(); System.out.println(s4.name);
		 * System.out.println(s4.hashCode()); System.out.println(s4.empId);
		 */
		
		/*Constructor<SingletonDesignPattern> s7= SingletonDesignPattern.class.getDeclaredConstructor();
		s7.setAccessible(true);
		SingletonDesignPattern s9=(SingletonDesignPattern)s7.newInstance();
		System.out.println(s9.hashCode());*/
		
		
		//Cloning
		//Employee -> int, String, Dept (depId) -DEp d= new DEp(09)->EMp e= new EMp (124,"Karthik,d)
		//E1= E.clone
		//e.setEmpid(678);
		//d.setDepId=07
		//sysyout(e1.empId)
		//Sysout(e1.d.depId)=
		SingletonDesignPattern s10=(SingletonDesignPattern) s.clone();
		System.out.println(s10.hashCode());
		
		//Runtime
	}
}
