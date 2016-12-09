/**
 * @(#)Asteroid.java
 *
 *
 * @author
 * @version 1.00 2012/6/7
 */
package pkg25;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.*;

public class Asteroid extends JPanel
{
    Random xVar;
    Random yVar;
    int x;
    int y;
    int radius;
    int[] pos;
    AtBorder checkB;
    Collision checkC;
    Image img;
    ImageIcon bob;


    public Asteroid()
    {
    	pos = new int[2];
        radius = 10;

        bob = new ImageIcon("24.png");
        img = bob.getImage();
    	checkB = new AtBorder();

        xVar = new Random();
        yVar = new Random();
        x = 5 - xVar.nextInt(10);
        y = 5 - yVar.nextInt(10);
    }
    public void inPos(int[] inP)
    {
        pos = inP;
    }
    public void move(Graphics gr)
    {
    	if(checkB.isInBounds(pos) == false);
        {
    		pos = checkB.newPos(pos);
                draw(gr);
        }
    }
    public int[] getPos()
    {
    	return pos;
    }
    public int getRad()
    {
        return radius;
    }
    public void draw(Graphics gr)
    {
    	pos[0] = pos[0] + x;
        pos[1] = pos[1] + y;
        gr.drawImage(img, pos[0], pos[1], 250, 250, Color.black,this);
    }
}