//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - takes a, b, and c input and calculates the roots of the quadratic equation

public class Quadratic {
	public static double getRootOne(int a, int b, int c) {
		double discriminant = Math.pow(b, 2) - 4 * a * c;

		if (discriminant < 0) {
			return 0;
		}

		return (-b + Math.sqrt(discriminant)) / (2 * a);
	}
	
	public static double getRootTwo(int a, int b, int c) {
		double discriminant = Math.pow(b, 2) - 4 * a * c;
		if (discriminant < 0) {
			return 0;
		}

		return (-b - Math.sqrt(discriminant)) / (2 * a);
	}
}