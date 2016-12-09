/**
 * @(#)AtBorder.java
 *
 *
 * @author
 * @version 1.00 2012/6/7
 */
package pkg25;

public class AtBorder
{
	int xtLimit;
	int xbLimit;
	int ylLimit;
	int yrLimit;
	int inX;
	int inY;
	int max;
	int min;
	int[] rPos;

    public AtBorder()
    {
    	max = 955;
    	min = 0;
		xtLimit = max;
		ylLimit = max;
		yrLimit = min;
		xbLimit = min;
		rPos = new int[2];
    }
    public boolean isInBounds(int[] pos)
    {
    	inX = pos[0];
    	inY = pos[1];

    	if(inX >= max | inX <= min | inY >= max | inY <= min)
    	{
    		return false;
    	}
    	return true;
    }
    public int[] newPos(int[] pos)
    {
    	inX = pos[0];
    	inY = pos[1];

		rPos[0] = max - inX;
		rPos[1] = min - inY;

		return rPos;
    }
}