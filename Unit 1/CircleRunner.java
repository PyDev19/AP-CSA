//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Program to take input from user and print area of circle

import java.util.*;

public class CircleRunner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while (true) {
			System.out.print("Enter the radius (type 'exit' to exit): ");
			String radius = scanner.nextLine();
			double r = 0.0;
 
			if (radius == "exit") {
				break;
			} else {
				r = Double.parseDouble(radius);
			}

			double area = Math.PI*Math.pow(r, 2);
			System.out.printf("Area of Circle: %.02f\n", area);
			System.out.println();
		}

		scanner.close();
	}
}