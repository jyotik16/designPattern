package t2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Constructor<ProxyPolicyBazar> c= ProxyPolicyBazar.class.getDeclaredConstructor();
		c.setAccessible(true);
		c.newInstance();
	}

}
