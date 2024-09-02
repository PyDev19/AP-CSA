//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - Showing the different types of variables in Java with their respective sizes in a table format

public class Variables{
	public static void main ( String[] args ) {
		byte byteOne = 127;
        short shortOne = -32123;
        int intOne = 90877;
        long longOne = 999999999;

        float floatOne = 38.5678f;
        double doubleOne = 923.234;

		System.out.println("/////////////////////////////////");
        System.out.println("*Atharva Mishra       08/18/2024*");
		System.out.println("*                               *");
		System.out.println("*        integer types          *");
		System.out.println("*                               *");
		System.out.println("*8 bit - byteOne = "+byteOne+"\t\t*");
        System.out.println("*16 bit - shortOne = "+shortOne+"\t*");
        System.out.println("*32 bit - intOne = "+intOne+"\t*");
        System.out.println("*64 bit - longOne = "+longOne+"\t*");
        System.out.println("*                               *");
        System.out.println("*        real types             *");
        System.out.println("*                               *");
        System.out.println("*32 bit - floatOne = "+floatOne+"\t*");
        System.out.println("*64 bit - doubleOne = "+doubleOne+"\t*");
        System.out.println("/////////////////////////////////");
	}
}