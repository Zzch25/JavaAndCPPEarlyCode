import java.util.Scanner;

public class P4x2
{
    public static void main(String[] args)
    {
		Scanner in = new Scanner(System.in);
		Calc tf = new Calc();

		System.out.println("Enter number one: ");
		double one = tf.nextDouble();
		System.out.println("Enter number two: ");
		double two = tf.nextDouble();
		tf.calculate(one, two);

		System.out.println("Results...");
		System.out.print("Sum: ");
		System.out.println(tf.getSum);
		System.out.print("Difference: ");
		System.out.println(tf.getDifference);
		System.out.print("Product: ");
		System.out.println(tf.getProduct);
		System.out.print("Quotient: ");
		System.out.println(tf.getQuotient);
		System.out.print("Distance: ");
		System.out.println(tf.getDistance);
		System.out.print("Average: ");
		System.out.println(tf.getAverage);
		System.out.print("Maximum: ");
		System.out.println(tf.getMaximum);
		System.out.print("Minimum: ");
		System.out.println(tf.getMinimum);
    }
}
