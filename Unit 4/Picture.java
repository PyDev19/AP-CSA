//Name - Atharva Mishra
//Class - Patterson 3B
//Description - This class contains methods to modify a picture with different effects

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture {

    /** The 2D array of pixels that comprise this picture */
    private Pixel[][] pixels;

    /**
     * Creates a Picture from an image file in the "images" directory
     * 
     * @param picture The name of the file to load
     */
    public Picture(String picture) {
        File file = new File(picture);
        BufferedImage image;
        if (!file.exists())
            throw new RuntimeException("No picture at the location " + file.getPath() + "!");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        pixels = new Pixel[image.getHeight()][image.getWidth()];
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                int rgb = image.getRGB(x, y);
                /*
                 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal
                 * integer
                 * The below extracts the individual values using bit-shifting and bit-wise
                 * ANDing with all 1's
                 */
                pixels[y][x] = new Pixel((rgb >> 16) & 0xff, (rgb >> 8) & 0xff, rgb & 0xff);
            }
        }
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * 
     * @param red    The red value of the color
     * @param green  The green value of the color
     * @param blue   The blue value of the color
     * @param height The height of the Picture
     * @param width  The width of the Picture
     */
    public Picture(int red, int green, int blue, int height, int width) {
        pixels = new Pixel[height][width];
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }
    }

    /**
     * Creates a solid white Picture of a given width and height
     * 
     * @param color  The {@link Color} of the Picture
     * @param height The height of the Picture
     * @param width  The width of the Picture
     */
    public Picture(int height, int width) {
        this(Color.WHITE, height, width);
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * 
     * @param color  The {@link Color} of the Picture
     * @param width  The width of the Picture
     * @param height The height of the Picture
     */
    public Picture(Color color, int height, int width) {
        this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
    }

    /**
     * Creates a Picture based off of an existing {@link Pixel} 2D array
     * 
     * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
     */
    public Picture(Pixel[][] pixels) {
        if (pixels.length == 0 || pixels[0].length == 0)
            throw new RuntimeException("Can't have an empty image!");
        int width = pixels[0].length;
        for (int i = 0; i < pixels.length; i++)
            if (pixels[i].length != width)
                throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels[" + i + "].length!");
        this.pixels = new Pixel[pixels.length][width];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
            }
        }
    }

    /**
     * Creates a Picture based off of an existing Picture
     * 
     * @param picture The Picture to copy
     */
    public Picture(Picture picture) {
        this(picture.pixels);
    }

    /**
     * Gets the width of the Picture
     * 
     * @return The width of the Picture
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the Picture
     * 
     * @return The height of the Picture
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets the {@link Pixel} at a given coordinate
     * 
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @return The {@link Pixel} at the given location
     */
    public Pixel getPixel(int x, int y) {
        if (x >= getWidth() || y >= getHeight() || x < 0 || y < 0)
            throw new RuntimeException("No pixel at (" + x + ", " + y + ")");
        return pixels[y][x];
    }

    /**
     * Sets the {@link Pixel} at a given coordinate
     * 
     * @param x     The x location of the {@link Pixel}
     * @param y     The y location of the {@link Pixel}
     * @param pixel The new {@link Pixel}
     */
    public void setPixel(int x, int y, Pixel pixel) {
        if (x >= getWidth() || y >= getHeight() || x < 0 || y < 0)
            throw new RuntimeException("No pixel at (" + x + ", " + y + ")");
        if (pixel == null)
            throw new NullPointerException("Pixel is null"); // guard is required because pixel's value isn't used in
                                                             // this method
        pixels[y][x] = pixel;
    }

    /**
     * Opens a {@link PictureViewer} to view this Picture
     * 
     * @return the {@link PictureViewer} viewing the Picture
     */
    public PictureViewer view() {
        return new PictureViewer(this);
    }

    /**
     * Save the image on disk as a JPEG
     * Call programmatically on a Picture object, it will prompt you to choose a
     * save location
     * In the save dialogue window, specify the file AND extension (e.g.
     * "lilies.jpg")
     * Extension must be .jpg as ImageIO is expecting to write a jpeg
     */
    public void save() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedImage image = new BufferedImage(this.pixels[0].length, this.pixels.length, BufferedImage.TYPE_INT_RGB);

        for (int r = 0; r < this.pixels.length; r++)
            for (int c = 0; c < this.pixels[0].length; c++)
                image.setRGB(c, r, this.pixels[r][c].getColor().getRGB());

        // user's Desktop will be default directory location
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");

        chooser.setDialogTitle("Select picture save location / file name");

        File file = null;

        int choice = chooser.showSaveDialog(null);

        if (choice == JFileChooser.APPROVE_OPTION)
            file = chooser.getSelectedFile();

        // append extension if user didn't read save instructions
        if (!file.getName().endsWith(".jpg") && !file.getName().endsWith(".JPG") && !file.getName().endsWith(".jpeg")
                && !file.getName().endsWith(".JPEG"))
            file = new File(file.getAbsolutePath() + ".jpg");

        try {
            ImageIO.write(image, "jpg", file);
            System.out.println("File created at " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Can't write to location: " + file.toString());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Invalid directory choice");
        }
    }

    /**
     * return a copy of the reference to the 2D array of pixels that comprise this
     * picture
     */
    public Pixel[][] getPixels() {
        return pixels;
    }

    /********************************************************
     *************** STUDENT METHODS BELOW ******************
     ********************************************************/

    /** remove all blue tint from a picture */
    public void zeroBlue() {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixels[r][c].setBlue(0);
            }
        }
    }

    /** remove everything BUT blue tint from a picture */
    public void keepOnlyBlue() {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixels[r][c].setRed(0);
                pixels[r][c].setGreen(0);
            }
        }
    }

    /** invert a picture's colors */
    public void negate() {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixels[r][c].setRed(255 - pixels[r][c].getRed());
                pixels[r][c].setGreen(255 - pixels[r][c].getGreen());
                pixels[r][c].setBlue(255 - pixels[r][c].getBlue());
            }
        }
    }

    /** simulate the over-exposure of a picture in film processing */
    public void solarize(int threshold) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                if (pixels[r][c].getRed() < threshold) {
                    pixels[r][c].setRed(255 - pixels[r][c].getRed());
                }

                if (pixels[r][c].getGreen() < threshold) {
                    pixels[r][c].setGreen(255 - pixels[r][c].getGreen());
                }

                if (pixels[r][c].getBlue() < threshold) {
                    pixels[r][c].setBlue(255 - pixels[r][c].getBlue());
                }
            }
        }
    }

    /** convert an image to grayscale */
    public void grayscale() {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                int avg = (pixels[r][c].getRed() + pixels[r][c].getGreen() + pixels[r][c].getBlue()) / 3;
                pixels[r][c].setRed(avg);
                pixels[r][c].setGreen(avg);
                pixels[r][c].setBlue(avg);
            }
        }
    }

    /** change the tint of the picture by the supplied coefficients */
    public void tint(double red, double blue, double green) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixels[r][c].setRed((int) (pixels[r][c].getRed() * red));
                pixels[r][c].setGreen((int) (pixels[r][c].getGreen() * green));
                pixels[r][c].setBlue((int) (pixels[r][c].getBlue() * blue));
            }
        }
    }

    /**
     * reduces the number of colors in an image to create a "graphic poster" effect
     */
    public void posterize(int span) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixels[r][c].setRed(pixels[r][c].getRed() - pixels[r][c].getRed() % span);
                pixels[r][c].setGreen(pixels[r][c].getGreen() - pixels[r][c].getGreen() % span);
                pixels[r][c].setBlue(pixels[r][c].getBlue() - pixels[r][c].getBlue() % span);
            }
        }
    }

    /** mirror an image about a vertical midline, left to right */
    public void mirrorVertical() {
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < width / 2; c++) {
                leftPixel = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** mirror about a vertical midline, right to left */
    public void mirrorRightToLeft() {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length / 2; c++) {
                pixels[r][c].setColor(pixels[r][pixels[0].length - 1 - c].getColor());
            }
        }
    }

    /** mirror about a horizontal midline, top to bottom */
    public void mirrorHorizontal() {
        for (int r = 0; r < pixels.length / 2; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixels[r][c].setColor(pixels[pixels.length - 1 - r][c].getColor());
            }
        }
    }

    /** flip an image upside down about its bottom edge */
    public void verticalFlip() {
        for (int r = 0; r < pixels.length / 2; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                Pixel temp = pixels[r][c];
                pixels[r][c] = pixels[pixels.length - 1 - r][c];
                pixels[pixels.length - 1 - r][c] = temp;
            }
        }
    }

    /** fix roof on greek temple */
    public void fixRoof() {
        Pixel left_pixel = null;
        Pixel right_pixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length / 4.5; r++) {
            for (int c = 0; c < width / 2; c++) {
                left_pixel = pixels[r][c];
                right_pixel = pixels[r][(width - 1) - c];

                right_pixel.setColor(left_pixel.getColor());
            }
        }
    }

    /** detect and mark edges in an image */
    public void edgeDetection(int dist) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                if (c < pixels[0].length - 1 && Math.abs(pixels[r][c].getRed() - pixels[r][c + 1].getRed()) > dist) {
                    pixels[r][c].setColor(Color.BLACK);
                } else if (r < pixels.length - 1
                        && Math.abs(pixels[r][c].getRed() - pixels[r + 1][c].getRed()) > dist) {
                    pixels[r][c].setColor(Color.BLACK);
                } else {
                    pixels[r][c].setColor(Color.WHITE);
                }
            }
        }
    }

    /**
     * copy another picture's pixels into this picture, if a color is within dist of
     * param Color
     */
    public void chromakey(Picture other, Color color, int dist) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                if (pixels[r][c].colorDistance(color) < dist) {
                    pixels[r][c].setColor(other.getPixel(c, r).getColor());
                }
            }
        }
    }

    /** steganography encode (hide the message in msg in this picture) */
    public void encode(Picture msg) {
        for (int r = 0; r < msg.getHeight(); r++) {
            for (int c = 0; c < msg.getWidth(); c++) {
                Pixel p = msg.getPixel(c, r);
                Pixel target = pixels[r][c];
                target.setRed(target.getRed() - target.getRed() % 4 + p.getRed() / 64);
                target.setGreen(target.getGreen() - target.getGreen() % 4 + p.getGreen() / 64);
                target.setBlue(target.getBlue() - target.getBlue() % 4 + p.getBlue() / 64);
            }
        }
    }

    /**
     * steganography decode (return a new Picture containing the message hidden in
     * this picture)
     */
    public Picture decode() {
        Picture msg = new Picture(getHeight(), getWidth());
        for (int r = 0; r < msg.getHeight(); r++) {
            for (int c = 0; c < msg.getWidth(); c++) {
                Pixel p = pixels[r][c];
                Pixel target = msg.getPixel(c, r);
                target.setRed(p.getRed() % 4 * 64);
                target.setGreen(p.getGreen() % 4 * 64);
                target.setBlue(p.getBlue() % 4 * 64);
            }
        }
        return msg;
    }

    /** perform a simple blur using the colors of neighboring pixels */
    public Picture simpleBlur() {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                int red = 0;
                int green = 0;
                int blue = 0;
                int count = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (r + i >= 0 && r + i < pixels.length && c + j >= 0 && c + j < pixels[0].length) {
                            red += pixels[r + i][c + j].getRed();
                            green += pixels[r + i][c + j].getGreen();
                            blue += pixels[r + i][c + j].getBlue();
                            count++;
                        }
                    }
                }
                pixels[r][c].setRed(red / count);
                pixels[r][c].setGreen(green / count);
                pixels[r][c].setBlue(blue / count);
            }
        }

        Picture blurred = new Picture(pixels);

        return blurred;
    }

    /** perform a blur using the colors of pixels within radius of current pixel */
    public Picture blur(int radius) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                int red = 0;
                int green = 0;
                int blue = 0;
                int count = 0;
                for (int i = -radius; i <= radius; i++) {
                    for (int j = -radius; j <= radius; j++) {
                        if (r + i >= 0 && r + i < pixels.length && c + j >= 0 && c + j < pixels[0].length
                                && Math.sqrt(i * i + j * j) <= radius) {
                            red += pixels[r + i][c + j].getRed();
                            green += pixels[r + i][c + j].getGreen();
                            blue += pixels[r + i][c + j].getBlue();
                            count++;
                        }
                    }
                }
                pixels[r][c].setRed(red / count);
                pixels[r][c].setGreen(green / count);
                pixels[r][c].setBlue(blue / count);
            }
        }

        Picture blurred = new Picture(pixels);

        return blurred;
    }

    /**
     * Simulate looking at an image through a pane of glass
     * 
     * @param dist the "radius" of the neighboring pixels to use
     * @return a new Picture with the glass filter applied
     */
    public Picture glassFilter(int dist) {
        Picture glassed = new Picture(getHeight(), getWidth());

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                int randR = (int) (Math.random() * (2 * dist + 1) - dist);
                int randC = (int) (Math.random() * (2 * dist + 1) - dist);
                if (r + randR >= 0 && r + randR < pixels.length && c + randC >= 0 && c + randC < pixels[0].length) {
                    glassed.getPixel(c, r).setColor(pixels[r + randR][c + randC].getColor());
                }
            }
        }

        return glassed;
    }

    /**
     * Simulate motion blur in an image
     * 
     * @param dist the distance to blur
     * @return a new Picture with the motion blur applied
     */
    public Picture motionBlur(int dist) {
        Picture blurred = new Picture(getHeight(), getWidth());

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                int red = 0;
                int green = 0;
                int blue = 0;
                int count = 0;
                for (int i = 0; i <= dist; i++) {
                    if (c + i < pixels[0].length) {
                        red += pixels[r][c + i].getRed();
                        green += pixels[r][c + i].getGreen();
                        blue += pixels[r][c + i].getBlue();
                        count++;
                    }
                }
                blurred.getPixel(c, r).setRed(red / count);
                blurred.getPixel(c, r).setGreen(green / count);
                blurred.getPixel(c, r).setBlue(blue / count);
            }
        }

        return blurred;
    }

    /**
     * Create a vignette effect on an image
     * 
     * @return a new Picture with the vignette effect applied
     */
    public Picture vignette() {
        Picture vignette = new Picture(getHeight(), getWidth());

        int maxDist = (int) Math.sqrt(Math.pow(getHeight() / 2, 2) + Math.pow(getWidth() / 2, 2));

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                int dist = (int) Math.sqrt(Math.pow(r - getHeight() / 2, 2) + Math.pow(c - getWidth() / 2, 2));
                double factor = 1 - (double) dist / maxDist;
                vignette.getPixel(c, r).setRed((int) (pixels[r][c].getRed() * factor));
                vignette.getPixel(c, r).setGreen((int) (pixels[r][c].getGreen() * factor));
                vignette.getPixel(c, r).setBlue((int) (pixels[r][c].getBlue() * factor));
            }
        }

        return vignette;
    }

    /**
     * Gaussian blur an image
     * @param radius the radius of the blur
     * @return a new Picture with the Gaussian blur applied
     */
    public Picture gaussianBlur(int radius) {
        Picture blurred = new Picture(getHeight(), getWidth());

        double[][] kernel = new double[radius * 2 + 1][radius * 2 + 1];
        double sum = 0;
        for (int r = 0; r < kernel.length; r++) {
            for (int c = 0; c < kernel[0].length; c++) {
                double dist = Math.sqrt(Math.pow(r - radius, 2) + Math.pow(c - radius, 2));
                kernel[r][c] = Math.exp(-dist / (2 * radius * radius));
                sum += kernel[r][c];
            }
        }

        for (int r = 0; r < kernel.length; r++) {
            for (int c = 0; c < kernel[0].length; c++) {
                kernel[r][c] /= sum;
            }
        }

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                double red = 0;
                double green = 0;
                double blue = 0;
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel[0].length; j++) {
                        int row = r + i - radius;
                        int col = c + j - radius;
                        if (row >= 0 && row < pixels.length && col >= 0 && col < pixels[0].length) {
                            red += pixels[row][col].getRed() * kernel[i][j];
                            green += pixels[row][col].getGreen() * kernel[i][j];
                            blue += pixels[row][col].getBlue() * kernel[i][j];
                        }
                    }
                }
                blurred.getPixel(c, r).setRed((int) red);
                blurred.getPixel(c, r).setGreen((int) green);
                blurred.getPixel(c, r).setBlue((int) blue);
            }
        }

        return blurred;
    }
}
