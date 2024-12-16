//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to run and test the Picture class to see if it functions as intended. It tests each method in the Picture class to see if it works as intended.

import java.awt.*;

public class PictureTester {
	public static void main(String[] args) {
		Picture blue_mark_1 = new Picture("blue-mark.jpg");
		blue_mark_1.view();
		blue_mark_1.zeroBlue();
		blue_mark_1.view();

		Picture moon_surface = new Picture("moon-surface.jpg");
		moon_surface.view();
		moon_surface.keepOnlyBlue();
		moon_surface.view();

		Picture beach = new Picture("beach.jpg");
		beach.view();
		beach.negate();
		beach.view();

		Picture arch = new Picture("arch.jpg");
		arch.view();
		arch.solarize(100);
		arch.view();

		Picture gorge = new Picture("gorge.jpg");
		gorge.view();
		gorge.grayscale();
		gorge.view();

		Picture koala = new Picture("koala.jpg");
		koala.view();
		koala.tint(0.5, 0.7, 0.9);
		koala.view();

		Picture beach_2 = new Picture("beach.jpg");
		beach_2.view();
		beach_2.posterize(80);
		beach_2.view();

		Picture waterlilies = new Picture("waterlilies.jpg");
		waterlilies.view();
		waterlilies.mirrorVertical();
		waterlilies.view();

		Picture red_motorcycle = new Picture("redMotorcycle.jpg");
		red_motorcycle.view();
		red_motorcycle.mirrorRightToLeft();
		red_motorcycle.view();

		Picture blue_motorcycle = new Picture("blueMotorcycle.jpg");
		blue_motorcycle.view();
		blue_motorcycle.mirrorHorizontal();
		blue_motorcycle.view();

		Picture swan = new Picture("swan.jpg");
		swan.view();
		swan.verticalFlip();
		swan.view();

		Picture temple = new Picture("temple.jpg");
		temple.view();
		temple.fixRoof();
		temple.view();

		Picture swan_2 = new Picture("swan.jpg");
		swan_2.view();
		swan_2.edgeDetection(20);
		swan_2.view();

		Picture swan_3 = new Picture("swan.jpg");
		swan_3.view();
		swan_3.simpleBlur().view();

		Picture arch_1 = new Picture("arch.jpg");
		arch_1.view();
		arch_1.blur(3).view();

		Picture waterlilies_2 = new Picture("waterlilies.jpg");
		waterlilies_2.view();
		waterlilies_2.glassFilter(5).view();

		Picture red_motorcycle_2 = new Picture("redMotorcycle.jpg");
		red_motorcycle_2.view();
		red_motorcycle_2.motionBlur(15).view();

		Picture beach_3 = new Picture("beach.jpg");
		beach_3.view();
		beach_3.vignette().view();

		Picture swan_4 = new Picture("swan.jpg");
		swan_4.view();
		swan_4.gaussianBlur(3).view();

		testChromakey();
		testSteganography();
	}

	/**
	 * this method is static, you don't need to call it on an object (just
	 * "testChromekey()")
	 */
	public static void testChromakey() {
		Picture one = new Picture("blue-mark.jpg");
		Picture two = new Picture("moon-surface.jpg");

		one.view(); // show original mustache guy picture
		two.view(); // show the untouched moon's surface pic

		one.chromakey(two, new Color(10, 40, 75), 60); // replace this color if within 60

		one.view();
	}

	/**
	 * this method is static, you don't need to call it on an object (just
	 * "testSteganography()")
	 */
	public static void testSteganography() {
		Picture msg = new Picture("msg.jpg");
		Picture beach = new Picture("beach.jpg");

		beach.encode(msg); // hide message in beach picture
		beach.view(); // beach w/ hidden message inside, shouldn't look different

		beach.decode().view(); // see the hidden message in the beach picture
	}
}
