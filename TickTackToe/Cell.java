//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class defines a cell on the tictactoe gameboard and implements locatable interface

import java.awt.Graphics;

public abstract class Cell implements Locatable {
	private int x_pos;
	private int y_pos;
	private int width;
	private int height;

	public Cell() {
		setPos(5, 5);
		setWidth(5);
		setHeight(5);
	}

	public Cell(int x, int y) {
		setPos(x, y);
	}

	public Cell(int x, int y, int w, int h) {
		setPos(x, y);
		setWidth(w);
		setHeight(h);
	}

	public void setPos(int x, int y) {
		x_pos = x;
		y_pos = y;
	}

	public void setX(int x) {
		x_pos = x;
	}

	public void setY(int y) {
		y_pos = y;
	}

	public void setWidth(int w) {
		width = w;
	}

	public void setHeight(int h) {
		height = h;
	}

	public int getX() {
		return x_pos;
	}

	public int getY() {
		return y_pos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public abstract void draw(Graphics window);

	public String toString() {
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
	}
}