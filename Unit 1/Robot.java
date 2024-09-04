// (c) A+ Computer Science
// www.apluscompsci.com
// Name - Atharva Mishra
// Class - Patterson 3B
// Description - Makes a Robot object with a head, upper body, and lower body

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas {
   public Robot() {
      setSize(800, 600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint(Graphics window) {
      window.setColor(Color.BLUE);
      window.drawString("Robot LAB", 35, 35);

      head(window);
      upperBody(window);
      lowerBody(window);
   }

   public void head(Graphics window) {
      // Head
      window.setColor(Color.YELLOW);
      window.fillOval(300, 100, 200, 100);

      // Eyes
      window.setColor(Color.BLACK);
      window.fillOval(340, 130, 30, 30);  // Left eye
      window.fillOval(430, 130, 30, 30);  // Right eye

      // Mouth
      window.setColor(Color.RED);
      window.fillRect(370, 170, 60, 20);
   }

   public void upperBody(Graphics window) {
      // Body
      window.setColor(Color.BLUE);
      window.fillRect(300, 250, 200, 150);

      // Arms
      window.setColor(Color.GRAY);
      window.fillRect(240, 260, 50, 20);  // Left arm
      window.fillRect(510, 260, 50, 20);  // Right arm
   }

   public void lowerBody(Graphics window) {
      // Legs
      window.setColor(Color.GREEN);
      window.fillRect(330, 400, 50, 100); // Left leg
      window.fillRect(420, 400, 50, 100); // Right leg
   }
}