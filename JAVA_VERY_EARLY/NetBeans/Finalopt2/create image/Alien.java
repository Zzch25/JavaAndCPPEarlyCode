
package pkg25;
//The Alien ship class amde by Alex Herariz
import java.awt.*;
import javax.swing.*;
public class Alien extends JPanel
{
	private int size; //Size of image/ship
	private int x;//X and Y coordinate
	private int y;
	private int dx; //change in X
	private int dy;
	private Image img;  //Image used for enemy ship


	public Alien(int x1, int y1, String f)
    {
    	size = 25;
    	dx = 0;
    	dy = 0;
    	x = x1;
    	y = y1;
    	ImageIcon newImg=new ImageIcon(f);
    	img=newImg.getImage();
    }

    public void moveLeft()
    {
    	dx = -1;
    	if (x<=5)
    		x = 850;
    }
    public void moveRight()
    {
    	dx = 1;
    		if (x >= 850)
    			x = 6;
    }

    public void moveDown()
    {
    	dy = 1;
    	if (y<=5)
    		y = 250;
    }


    public void draw(Graphics gr)
    {
    	x =x + dx;
    	y = y +dy;
		gr.drawImage(img, x, y, size, size, Color.black, this);  //Generates the image of square size with side length of "Side" at X and y with the image specified
	}

public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
}