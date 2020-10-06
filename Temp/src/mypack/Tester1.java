package mypack;

import mypack.Car.Engine;

public class Tester1
{
	public static void main(String[] args)
	{
		/*Car car=new Car();
		Engine obj=car.new Engine(20);*/
		Engine obj=new Car().new Engine(50);
		obj.show();
	}
}