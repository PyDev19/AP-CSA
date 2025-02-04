//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to create a piece object that can be used in the game of chess. It has a name and a color. It extends the Cell class and implements the Nameable interface.

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Piece extends Cell implements Nameable {
	private String name;
	private Color color;

	public Piece() {
		super(5, 5, 5, 5);
		setName("empty");
		setColor(Color.BLUE);
	}

	public Piece(String n) {
		super(5, 5, 5, 5);
		name = n;
		setColor(Color.BLUE);
	}

	public Piece(int x, int y, String n) {
		super(x, y, 5, 5);
		name = n;
		setColor(Color.BLUE);
	}

	public Piece(int x, int y, int w, int h, String n) {
		super(x, y, w, h);
		name = n;
		setColor(Color.BLUE);
	}

	public Piece(int x, int y, int w, int h, String n, Color c) {
		super(x, y, w, h);
		name = n;
		color = c;
	}

	public void setName(String n) {
		name = n;
	}

	public void setColor(Color c) {
		color = c;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public void draw(Graphics window) {
		window.setFont(new Font("TAHOMA", Font.BOLD, 28));
		window.setColor(getColor());
		window.drawString(getName(), getX(), getY());
	}

	public String toString() {
		return super.toString() + " " + getName() + " " + getColor();
		
	}
}