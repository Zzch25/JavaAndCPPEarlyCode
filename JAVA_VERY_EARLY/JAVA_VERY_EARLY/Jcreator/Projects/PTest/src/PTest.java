import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class PTest
{
    public static void main(String[] args)
    {
    	Scanner in = new Scanner(System.in);
    	ArrayList<Palindrone> pallyobuddy = new ArrayList<Palindrone>();
   		Random bob = new Random();//used for random spaces mode
   		String input = "";
   		String ys = new String("Spaces selected");
   		String ns = new String("No spaces selected");
   		int count = 0;//used to set class instance to an arraylist

    	System.out.println("Welcome to the Palindrone tester! Enter Q to quit when prompted."); //opening prompt
    	System.out.println("----------------------------------------------------------------");
    	System.out.println();

    	do //continues loop until q is prompted
    	{
			int sOi = 0; //space indicator temporarily instantiated
			String inptemp = ""; //temp string used for comparator

			System.out.print("Type options (Yes/No/25) for spacing else PL for print log: ");
			input = in.nextLine();
			System.out.println();

			if(input.equalsIgnoreCase("No"))
			{
				sOi = 0;
				System.out.println(ns);
			}
			else if(input.equalsIgnoreCase("Yes"))
			{
				sOi = 1;
				System.out.println(ys);
			}
			else if(input.equalsIgnoreCase("25"))
			{
				System.out.print("Computer rolls the die... ");
				if(bob.nextInt(2) == 0)//random sequence to decide whether or not to have spaces
				{
					sOi = 0;
					System.out.println("Die lands on no spaces");
				}
				else
				{
					sOi = 1;
					System.out.println("Die lands on spaces");
				}
			}
			else //indicator is set to 2 so that main code does not execute until the user inputs a valid option
			{
				sOi = 2;
				if(input.equalsIgnoreCase("PL") & count != 0)//determines if log is to be printed
				{
					for(int i = 0; i <= pallyobuddy.size() - 1; i++)//loops for each arraylist entity
					{
						if(pallyobuddy.get(i).getSpace() == 0)
						{
							System.out.print(ns);
						}
						else
						{
							System.out.print(ys);
						}
						System.out.println(" - Regular: " + pallyobuddy.get(i).getRegular() + " - Reversed: " + pallyobuddy.get(i).getReversed());//log line
					}
				}
				else if(input.equalsIgnoreCase("PL") & count == 0)
				{
					System.out.println("Log unavailable, no prior input found");
				}
				else if(!input.equalsIgnoreCase("Q"))//prevents unrecognized prompt if the user quits
				{
					System.out.println("Command not recognized");
				}
			}

			System.out.println();//spacing is used to make the interface more user friendly

			if(sOi != 2)//if a valid spacing option was selected, the code will continue with its primary function
			{
    			do
    			{
  					if(input.equals(""))//checks for null entries
  					{
  						System.out.println("Please enter an actual sequence");
  						System.out.println();
  					}
  					System.out.print("Input a sequence you wish to test: ");
    				input = in.nextLine();
    				inptemp.equals(input.replace(" ", ""));
    			}
    			while(input.equals(""));

    			System.out.println();

				if(!input.equalsIgnoreCase("Q"))//another provision to skip the main of the program in favor of quiting
				{
					pallyobuddy.add(new Palindrone());//creates a new arraylist slot having cleared that the current one is filled

    				if(pallyobuddy.get(count).getStatus(input, sOi) == true)
    				{
    					System.out.println(input + " is a palindrone");
    				}
    				else
    				{
    					System.out.println(input + " is not a palindrone");
    				}

    				System.out.println();
					System.out.println("Results: ");//prints input(modified or regular) and the reversed(modified or regular)
    				System.out.println("-Reg = " + pallyobuddy.get(count).getRegular());
					System.out.println("-Rev = " + pallyobuddy.get(count).getReversed());
					System.out.println();
				}
				count++;//increments array slot to be used
			}
    	}
    	while(!input.equalsIgnoreCase("Q"));//quit function

    	System.out.print("Exiting...");
    }
}
//up to date: 925