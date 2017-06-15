package by.epam.classloaderex;

public class Car {
	public Car() {
		System.out.println("Car is created");
	}
	static{
		Car anCar = new Car(){
			public int getYear(){return year;}
			Car anCar2 = new Car(){
				public double getDoors(){return doors;}
			};
		};
	}
	int year;
	double doors;
	static int quantity = 0;

	public static class Engine {
		{
			System.out.println("logical block Engine instantiated");
		}
		static {
			System.out.println("static block Engine instantiated");
		}
		
		double volume;
	}

	class InnerCar {
		{
			System.out.println("InnerCar is instantiated "+getClass().getClassLoader());	
		}
		public int a;

		public InnerCar(int a) {
			this.a = a;
		}
	}

}
