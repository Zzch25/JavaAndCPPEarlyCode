/**
 * @(#)Ship.java
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

public class Ship extends JPanel
{
	int[] pos;
        int[] slope;
        int[] slopeA;
	int maxPlyr;
        int turn;
        int id;
        int turnInt;
        int radius;
        int shipResponseA;
        int shipResponse;
        int score;
	AtBorder checkB;
	boolean[][] tg;
        boolean isActive;
        Image img;
        ImageIcon bob;

    public Ship()
    {
        bob = new ImageIcon("24.png");
        img = bob.getImage();
        
        id = 0;
        shipResponseA = 100;
        shipResponse = 0;
        score = 0;
        turn = 30;
        turnInt = 1;
        slope = new int[2];
        slope[0] = 0;
        slope[1] = 0;
        slopeA = new int[2];
        slopeA[0] = 0;
        slopeA[1] = 0;
    	pos = new int[2];
    	checkB = new AtBorder();
    	maxPlyr = 4;
        radius = 10;
        isActive = false;

    	tg = new boolean[4][3];
    }
    public void inPos(int id)
    {
        this.id = id;
        isActive = true;
        
        if(id == 0)
        {
            pos[0] = 100;
            pos[1] = 100;
        }
        if(id == 1)
        {
            pos[0] = 900;
            pos[1] = 100;
        }
        if(id == 2)
        {
            pos[0] = 900;
            pos[1] = 900;
        }
        if(id == 3)
        {
            pos[0] = 100;
            pos[1] = 900;
        }
    }
    public void move(int[] type, Graphics gr)
    {
        score++;
        
    	if(checkB.isInBounds(pos) == false);
    		pos = checkB.newPos(pos);
    	for(int i = 0; i<maxPlyr; i++)
    	{
    		if(type[0] == i)
    		{
    			if(type[1] == 1)
    			{
					tg[i][0] = !tg[i][0];
	    		}
	    		if(type[1] == 2)
	    		{
					tg[i][1] = !tg[i][1];
	    		}
	    		if(type[1] == 3)
	    		{
					tg[i][2] = !tg[i][2];
	    		}
	    	}
	    	for(int x = 0; x<maxPlyr; x++)
	    	{
	    		if(tg[i][x] == true & isActive == true)
	    		{
	    			if(x == 0)
	    			{
                                    if(shipResponseA > shipResponse)
                                    {
                                        shipResponse++;
                                    }
                                    else
                                    {
                                        shipResponse = 0;
                                        
                                        if(slopeA[0] > slope[0])
                                        {
                                            slope[0] += 1;
                                        }
                                        else
                                        {
                                            slope[0] -= 1;
                                        }
                                        if(slopeA[1] > slope[1])
                                        {
                                            slope[1] += 1;
                                        }
                                        else
                                        {
                                            slope[1] -= 1;
                                        }
                                    }
                                    pos[0] += slope[0];
                                    pos[1] += slope[1];
	    			}
	    			if(x == 1)
	    			{
                                    if(slopeA[0] > -turn & slopeA[0] < turn)
                                    {
                                        slopeA[0] += turnInt;
                                        slopeA[1] -= turnInt;
                                    }
	    			}
	    			if(x == 2)
	    			{
                                    if(slopeA[0] > -turn & slopeA[0] < turn)
                                    {
                                        slopeA[0] -= turnInt;
                                        slopeA[1] += turnInt;
                                    }
	    			}
	    		}
	    	}
                gr.drawImage(img, pos[0], pos[1], 25, 25, Color.black,this);
    	  }
    }
    public int[] getPos()
    {
    	return pos;
    }
    public int getRadius()
    {
        return radius;
    }
    public boolean erase()
    {
        if(isActive == true)
        {
            return true;
        }
        else
        isActive = false;
            return false;
    }
    public void setScore(int scr)
    {
        score = scr;
    }
    public int getScore()
    {
        return(score);         
    }
}