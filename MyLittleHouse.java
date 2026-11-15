// These are our imports that we will use for our project.
// They give us access to classes that are not automatically available.
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.*;

public class MyLittleHouse // This is our main class where our methods and variables will go.
{
    BufferedImage picture;

    public MyLittleHouse()
    {
        // This section allows our program to try loading the image
        // and print an error message if something goes wrong.
        try
        {
            // Load house.png from the project files.
            picture = ImageIO.read(new File("house.png"));
        }
        catch(Exception e)
        {
            System.out.println("Picture was not found.");
            e.printStackTrace();
        }
    }

    public void colorPicture() // This method is where I will be coloring and modifying my image.
    {
        // These two colors are not built-in Color constants like green, red,
        // or yellow, so we create them using their RGB values.
        Color brown = new Color(139, 69, 19);
        Color tan = new Color(210, 180, 140);
        
        // This for loop goes through each x-coordinate, or horizontal position, of the image.
        for(int x = 0; x < picture.getWidth(); x++)
        {
            // This for loop goes through each y-coordinate, or vertical position, of the image.
            for(int y = 0; y < picture.getHeight(); y++)
            {   
                // This gets the color of the pixel at the current coordinates.
                Color pixel = new Color(picture.getRGB(x, y));

                // This if statement checks whether all three RGB values are below 50.
                // If they are, the pixel is considered dark and can be recolored.
                if(pixel.getRed() < 50 &&
                   pixel.getGreen() < 50 &&
                   pixel.getBlue() < 50)
                {
                    // Any dark pixel at y = 225 or greater will be colored tan.
                    if(y >= 225) 
                    {
                        picture.setRGB(x, y, tan.getRGB()); // This is the color of our ground.
                    }

                    // Coordinate intervals for where our colors will go.
                    else if(x >= 195 && x <= 215 &&
                            y >= 160 && y <= 225) 
                    {
                        picture.setRGB(x, y, brown.getRGB()); // This is the color of our tree trunk.
                    }

                    // Coordinate intervals for where our colors will go.
                    else if(x >= 170 && x <= 245 &&
                            y >= 95 && y <= 180)
                    {
                        picture.setRGB(x, y, Color.GREEN.getRGB()); // This is the color of our tree leaves.
                    }

                    // Coordinate intervals for where our colors will go.
                    else if(x >= 0 && x <= 80 &&
                            y >= 0 && y <= 90)
                    {
                        picture.setRGB(x, y, Color.YELLOW.getRGB()); // This is the color of our sun.
                    }

                    // Coordinate intervals for where our colors will go.
                    else if(x >= 40 && x <= 165 &&
                            y >= 80 && y <= 220)
                    {
                        picture.setRGB(x, y, Color.RED.getRGB()); // This is the color of our house.
                    }
                }
            }
        }
    }
    
    // This method is responsible for displaying our finished image.
    public void show()
    {
        JFrame frame = new JFrame("Colored House"); // A JFrame is a window, and the name of our window is "Colored House."

        // ImageIcon turns our picture into an image that Swing can display,
        // and JLabel holds that image so it can be added to the JFrame.
        JLabel label = new JLabel(new ImageIcon(picture));

        frame.add(label); // This places the label containing our image into the JFrame we created.
        frame.pack(); // This makes our window large enough to contain its components.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the user closes the window, the program will end.
        frame.setVisible(true); // This makes our window appear.
    }
    
    // This is the main method where our program begins running.
    public static void main(String[] args)
    {
        // This creates a MyLittleHouse object called "p."
        // Creating the object also calls the MyLittleHouse constructor, which loads our image.
        MyLittleHouse p = new MyLittleHouse();

        // Only continue if house.png loaded successfully.
        if(p.picture != null)
        {
            p.colorPicture(); // Colors and modifies our image.
            p.show(); // Displays our finished image.
        }
    }
}