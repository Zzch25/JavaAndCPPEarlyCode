import java.awt.Rectangle;
 
public class p2x1 
{
			 
    public static void main(String[] args) 
    {
    	double dblX;
    	double dblY;
    	double dblA;
    	double dblW;
    	double dblH;
    	
    	Rectangle bob = new Rectangle(25,25,25,25);
    	bob.translate(25,25);
    	
    	dblX = bob.getX();
    	dblY = bob.getY();
    	dblW = bob.getWidth();
    	dblH = bob.getHeight();
    	dblA = dblH*dblW;
    		
    	System.out.print("X= ");
    	System.out.println(dblX);
    	System.out.println("Expected 50");	
    	System.out.print("Y= ");
    	System.out.println(dblY);
    	System.out.println("Expected 50");
    	System.out.print("Area= ");
    	System.out.println(dblA);
    	System.out.println("Expected 625");		 	
    }
}
