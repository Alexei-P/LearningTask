package by.epam.classloaderex;

public class Main {
	public static void main(String[] args) {
		System.out.println(Main.class.getClassLoader());
		CustomClassLoader ccl = new CustomClassLoader(Main.class.getClassLoader());
		try {
			Class innerCar = ccl.loadClass("by.epam.classloaderex.Car$InnerCar");
			System.out.println("______________________________________");
			/*Class zClass = ccl.loadClass("by.epam.classloaderex.Car");
			System.out.println("______________________________________");
			Class engineClass = ccl.loadClass("by.epam.classloaderex.Car$Engine");
			System.out.println("______________________________________");
			Class anonymousClass = ccl.loadClass("by.epam.classloaderex.Car$1");
			System.out.println("______________________________________");
			Class anonymousClass = ccl.loadClass("by.epam.classloaderex.Car$1$1");
			System.out.println("______________________________________");*/
			//Car car = new Car();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
