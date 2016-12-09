import java.util.Scanner;
import java.lang.Thread;

public class P7x4
{
    public static void main(String[] args)
    {
    	String[] elephant = new String[10];
		Scanner macys = new Scanner(System.in);
		int stringAmount = 1; //please keep this value an integer one and up in value
		int stringADefault = 10;
		String numbers = "";

		System.out.println("Please input an integer above the value of '1'. This will determine the amount of inputs available!");
		System.out.println();

		stringAmount = macys.nextInt();
		System.out.println();

		if(stringAmount < 1)
		{
			stringAmount=stringADefault;
			System.out.println("Directions were not followed, for your convienince the amount has been set to the default value, " + stringADefault + ".");
			System.out.println();
		}

		if(stringAmount == 1)
		{
			numbers = "number";
		}
		else
		{
			numbers = "numbers";
		}

		System.out.println("Please input " + stringAmount + " " + numbers + ":");

		for(int i=0; i<=(stringAmount-1); i++)
		{
			elephant[i] = macys.next();
		}
		for(int i=(stringAmount-1); i>=0; i--)
		{
			System.out.println(elephant[i]);
		}
    }
}
