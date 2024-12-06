//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class creates a person object that can move up, down, left, and right. The person can also collide with other objects.

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Person {
	private ArrayList<Image> list;
	private int x, y, current;

	public Person(int x, int y) throws IOException {
		this.x = x;
		this.y = y;
		this.current = 0;

		// point the array list at a new ArrayList
		list = new ArrayList<Image>();

		// add all images to the list
		list.add(ImageIO.read(new File("dude.gif")));
		list.add(ImageIO.read(new File("dudeL.gif")));
		list.add(ImageIO.read(new File("dudeR.gif")));
		list.add(ImageIO.read(new File("dudeU.gif")));
	}

	// will return true if person collides with another object
	public boolean collide(int x, int y) {
		Rectangle a = new Rectangle(this.x, this.y, 50, 50);
		Rectangle b = new Rectangle(x, y, 50, 50);
		return a.intersects(b);
	}

	public void drawPerson(Graphics2D g) {
		// draw the current image on the screen
		g.drawImage(list.get(current), x, y, null);
	}

	public Image getCurrent() {
		// return the current image
		return list.get(current);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void moveRight() {
		x += 5;
		current = 2;
	}

	public void moveLeft() {
		x -= 5;
		current = 1;
	}

	public void moveUp() {
		y -= 5;
		current = 3;
	}

	public void moveDown() {
		y += 5;
		current = 0;
	}
}
