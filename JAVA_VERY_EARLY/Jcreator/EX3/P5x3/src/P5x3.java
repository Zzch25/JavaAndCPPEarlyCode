import java.util.Scanner;

public class P5x3
{
    public static void main(String[] args)
    {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Input hours worked then pay per hour.");
    	Paycheck Bob = new Paycheck(in.nextDouble(), in.nextDouble());
		System.out.println(Bob.getPay());
    }
}
