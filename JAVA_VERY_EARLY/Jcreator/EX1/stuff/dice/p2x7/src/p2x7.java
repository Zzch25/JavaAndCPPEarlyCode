import java.util.Random;

public class p2x7 
{
    public static void main(String[] args) 
    {
		Random generator = new Random();
		int intRND;
			
		intRND = generator.nextInt(6);
		intRND = intRND+1;
		System.out.println(intRND);
    }
}
