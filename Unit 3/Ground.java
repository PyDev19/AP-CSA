//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class creates the ground for the game.

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Ground {
	private ArrayList<Image> tiles;

	public Ground() throws IOException {
		// point the tiles at new array list
		tiles = new ArrayList<Image>();

		// add in each of the images for the grass.gif, gtoroad.gif, road.gif,
		// rtograss.gif
		tiles.add(ImageIO.read(new File("grass.gif")));
		tiles.add(ImageIO.read(new File("gtoroad.gif")));
		tiles.add(ImageIO.read(new File("road.gif")));
		tiles.add(ImageIO.read(new File("rtograss.gif")));
	}

	public void drawGround(Graphics2D g) {
		// top two rows are grass
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 20; j++) {
				g.drawImage(tiles.get(0), j * 40, i * 40, null);
			}
		}

		// third tile is grass roads
		for (int i = 2; i < 3; i++) {
			for (int j = 0; j < 20; j++) {
				g.drawImage(tiles.get(1), j * 40, i * 40, null);
			}
		}

		// middle tiles are roads
		for (int i = 3; i < 13; i++) {
			for (int j = 0; j < 20; j++) {
				g.drawImage(tiles.get(2), j * 40, i * 40, null);
			}
		}

		// second to last row is road grass
		for (int i = 13; i < 14; i++) {
			for (int j = 0; j < 20; j++) {
				g.drawImage(tiles.get(3), j * 40, i * 40, null);
			}
		}

		// last row is grass
		for (int i = 14; i < 15; i++) {
			for (int j = 0; j < 20; j++) {
				g.drawImage(tiles.get(0), j * 40, i * 40, null);
			}
		}
	}
}