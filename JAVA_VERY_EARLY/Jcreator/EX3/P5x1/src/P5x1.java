import java.util.Scanner;

public class P5x1
{
    public static void main(String[] args)
    {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Input a year to calculate if it is a leap year!");
    	Lyear ly = new Lyear(in.nextInt());
    	if(ly.getLy() == true)
    	{
    		System.out.println("This year is a leap year!");
    	}
    	else
    	{
    		System.out.println("This year is not a leap year!");
    	}
    }
}
