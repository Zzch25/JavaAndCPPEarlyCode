/**
 * @(#)P3x2.java
 *
 * P3x2 application
 *
 * @author
 * @version 1.00 2011/10/19
 */

public class P3x2 {

    public static void main(String[] args)
    {
    Dice Bob = new Dice();
    System.out.println("New die created with a normal range");
    System.out.print("The die is rolled yielding ");
    Bob.roll();
    System.out.println(Bob.getRoll());
    Dice Twentyfive = new Dice(25);
    System.out.println("New die created with a custom range");
    System.out.print("The die is rolled yielding ");
    Twentyfive.roll();
    System.out.println(Twentyfive.getRoll());
    }
}
