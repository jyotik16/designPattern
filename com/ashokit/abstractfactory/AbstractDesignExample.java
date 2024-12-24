package com.ashokit.abstractfactory;






public class AbstractDesignExample {
	public static void main(String[] args)
    {
        CarFactory.buildCar(CarType.SEDAN).construct();// Customer came to SKODA web SITE and request or placed an order for SEDAN car
        CarFactory.buildCar(CarType.SUV).construct();
       // System.out.println(CarFactory.buildCar(CarType.LUXURY));
    }

}

enum CarType
{
    SEDAN, SUV, LUXURY
}


enum Location
{
  DEFAULT, USA, INDIA
}


abstract class Car
{
    Car(CarType model, Location location)
    {
        this.model = model;
        this.location = location;
    }
  
    abstract void construct();
  
    CarType model = null;
    Location location = null;
  
    CarType getModel()
    {
        return model;
    }
  
    void setModel(CarType model)
    {
        this.model = model;
    }
  
    Location getLocation()
    {
        return location;
    }
  
    void setLocation(Location location)
    {
        this.location = location;
    }
  
    @Override
    public String toString()
    {
        return "CarModel - "+model + " located in "+location;
    }
}

class LuxuryCar extends Car
{
    LuxuryCar(Location location)
    {
        super(CarType.LUXURY, location);
        //construct();
    }
    @Override
    protected void construct()
    {
        System.out.println("Connecting to luxury car");
    }
}
 
class SEDANCar extends Car
{
    SEDANCar(Location location)
    {
        super(CarType.SEDAN, location);
       // construct();
    }
    @Override
    protected void construct()
    {
        System.out.println("Connecting to SEDAN Car ");
        
    }
}
 
class SUVCar extends Car
{
    SUVCar(Location location)
    {
        super(CarType.SUV,location );
        //construct();
    }
     
    @Override
    void construct()
    {
        System.out.println("Connecting to SUV car");
    }
}

class INDIACarFactory
{
    static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case SEDAN:
                car = new SEDANCar(Location.INDIA);
                break;
             
            case SUV:
                car = new SUVCar(Location.INDIA);
                break;
                 
            case LUXURY:
                car = new LuxuryCar(Location.INDIA);
                break;
                 
                default:
                break;
             
        }
        return car;
    }
}
 
class DefaultCarFactory
{
    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case SEDAN:
                car = new SEDANCar(Location.DEFAULT);
                break;
             
            case SUV:
                car = new SUVCar(Location.DEFAULT);
                break;
                 
            case LUXURY:
                car = new LuxuryCar(Location.DEFAULT);
                break;
                 
                default:
                break;
             
        }
        return car;
    }
}
 
 
class USACarFactory
{
    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case SEDAN:
                car = new SEDANCar(Location.USA);
                break;
             
            case SUV:
                car = new SUVCar(Location.USA);
                break;
                 
            case LUXURY:
                car = new LuxuryCar(Location.USA);
                break;
                 
                default:
                break;
             
        }
        return car;
    }
}

class CarFactory
{
    private CarFactory()
    {
         
    }
    public static Car buildCar(CarType type)
    {
        Car car = null;
        // We can add any GPS Function here which
        // read location property somewhere from configuration
        // and use location specific car factory
        // Currently I'm just using INDIA as Location
        //gps();
        Location location = Location.USA;
         
        switch(location)
        {
            case USA:
                car = USACarFactory.buildCar(type);
                break;
                 
            case INDIA:
                car = INDIACarFactory.buildCar(type);
                break;
                     
            default:
                car = DefaultCarFactory.buildCar(type);
 
        }
         
        return car;
 
    }
}