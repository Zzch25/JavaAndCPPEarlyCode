/**
 * @(#)Collision.java
 *
 *
 * @author
 * @version 1.00 2012/6/7
 */
package pkg25;

public class Collision
{
	int[] obj1p;
	int obj1r;
	int[] obj2p;
	int obj2r;
	int x1;
	int x2;
	int y1;
	int y2;
	int compX;
	int compY;

    public Collision()
    {
    	obj1p = new int[2];
   		obj2p = new int[2];
   		obj2r = 0;
   		obj1r = 0;
   		x1 = 0;
   		x2 = 0;
   		y1 = 0;
   		y2 = 0;
   		compX = 0;
   		compY = 0;
    }
    public boolean isCollision(int[] o1p, int o1r, int[] o2p, int o2r)
    {
    	x1 = o1p[0];
    	y1 = o1p[1];
    	x2 = o2p[0];
    	y2 = o2p[1];

    	if(x1 > x2)
    		compX = (x1 - x2);
    	else
    		compX = (x2 - x1);
    	if(y1 > y2)
    		compY = (y1 - y2);
    	else
    		compY = (y2 - y1);

    	if(compX <= o1r+o2r & compY <= o1r + o2r)
    		return true;
		return false;
    }
}