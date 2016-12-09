import java.util.Scanner;

public class P5x2
{
    public static void main(String[] args)
    {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input A, 2-10, J, Q, or K for the first character, and input D, H, S, or C for the last");
		cTest Bob = new cTest(in.nextLine());
		System.out.println(Bob.getAnswer());
    }
}
