package com.ashokit.abstractfactory;

public class ECommerceAbstractFactory {
	
	public static void main(String[] args) {
		AbstactProductFamily p= new AbstactProductFamily();
		p.getProductFamily("Electionices");
	}

}

interface ProductFamily{
	Product createProduct();
}

interface Product{
	public void info();
	public void price();
}

class ProdctFactory {
	
	Product getProduct(String type){
		if("Mobile".equalsIgnoreCase(type)) {
			return new Mobile();
		}
		if("Television".equalsIgnoreCase(type)) {
			return new Television();
		}
		if("Dishwasher".equalsIgnoreCase(type)) {
			return new DishWasher();
		}
		return null;
	}
}

class DishWasher implements Product{

	@Override
	public void info() {
		System.out.println("DishWasher ");		
	}

	@Override
	public void price() {
		System.out.println("DishWasher  price is 31000");
	}
	
}
class Mobile implements Product{

	@Override
	public void info() {
		System.out.println("Mobile phone");		
	}

	@Override
	public void price() {
		System.out.println("Mobile phone price is 10000");
	}
	
}

class Television implements Product{

	@Override
	public void info() {
		System.out.println("Television ");		
	}

	@Override
	public void price() {
		System.out.println("Television phone price is 20000");
	}
	
}
class AbstactProductFamily{
	Product getProductFamily(String category){
		if("Electronics".equals(category)) {
			switch () {
			case value:"Mobile";
				
				break;

			default:
				break;
			}
		}
		if("KitchenAppliances".equals(category)) {
			//return new KitchenAppliances();
		}
		//return null;
	}
}

class Electronics implements ProductFamily{
	Product p;
	Electronics(Product p){
		this.p=p;
	}

	@Override
	public Product createProduct() {
		return p;
		
	}
	
}

class KitchenAppliances implements ProductFamily{
	Product p;
	KitchenAppliances(Product p){
		this.p=p;
	}

	@Override
	public Product createProduct() {
		return p;
		
	}
	
}
