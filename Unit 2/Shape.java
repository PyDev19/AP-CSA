//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class is used to create a shape object that can be drawn on the screen. The shape object can be a rectangle or an oval. The shape object can be moved and drawn on the screen.

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
   private int xPos;
   private int yPos;
   private int width;
   private int height;
   private Color color;
   private int xSpeed;
   private int ySpeed;

   /*
    * The constructor is used to initialize all instance variables.
    * The constructor makes the object.
    */
   public Shape(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd) {
      xPos = x;
      yPos = y;
      width = wid;
      height = ht;
      color = col;
      xSpeed = xSpd;
      ySpeed = ySpd;
   }

   /*
    * The draw method draws the shape on the screen.
    */
   public void draw(Graphics window) {
      window.setColor(color);
      // make rectangle inside the oval
      window.fillRect(xPos, yPos, width, height);

      int r = (int)(Math.random() * 256);
      int g = (int)(Math.random() * 256);
      int b = (int)(Math.random() * 256);
      Color random_color = new Color(r, g, b);

      window.setColor(random_color);
      
      // make oval
      int diagonal = (int)Math.sqrt(width*width + height*height);
      int x_offset = (diagonal - width) / 2;
      int y_offset = (diagonal - height) / 2;

      window.drawOval(xPos - x_offset, yPos - y_offset, diagonal, diagonal);
   }

   /*
    * This draw method will be used to erase the shape.
    */
   public void draw(Graphics window, Color col) {
      window.setColor(col);
      window.fillRect(xPos, yPos, width, height);
   }

   public void moveAndDraw(Graphics window) {
      draw(window, Color.WHITE);

      xPos += xSpeed;

      yPos += ySpeed;

      draw(window);
   }

   public int getX() {
      return xPos;
   }

   public void setX(int x) {
      xPos = x;
   }

   public int getY() {
      return yPos;
   }

   public void setY(int y) {
      yPos = y;
   }

   public int getXSpeed() {
      return xSpeed;
   }

   public void setXSpeed(int x) {
      xSpeed = x;
   }

   public int getYSpeed() {
      return ySpeed;
   }

   public void setYSpeed(int y) {
      ySpeed = y;
   }

   public String toString() {
      return xPos + " " + yPos + " " + width + " " + height + " " + color + " " + xSpeed + " " + ySpeed;
   }
}