import java.util.Scanner;

/**
   This program runs a TicTacToe game. It prompts the
   user to set positions on the board and prints out the
   result.
*/
public class TicTacToeRunner
{
   public static void main(String[] args)
   {
   	  String inp = "";
   	  int ct = 0;
   	  int tr = 0;
   	  int tc = 0;
   	  int s1 = 3;
   	  int s2 = 16;
   	  int s3 = 25;
      Scanner in = new Scanner(System.in);
      String player = "x";
      boolean done = false;

	  do
	  {
	  	if(ct == 1)
	  	{
	  		System.out.println("Please follow the given directions");
	  	}
      	System.out.println("[1/2/3] 1: " + s1 + "x" + s1 + ", 2: " + s2 + "x" + s2 + ", 3: " + s3 + "x" + s3);
      	inp = in.nextLine();
      	if(inp.equals("1"))
      	{
			tr = 3;
   	  		tc = 3;
      	}
      	else if(inp.equals("2"))
      	{
			tr = 16;
   	  		tc = 16;
      	}
      	else if(inp.equals("3"))
      	{
			tr = 25;
   	  		tc = 25;
      	}
      	else
      	{
      		ct = 1;
      	}
	  }
	  while(tr < 3 | tc < 3);

      TicTacToe game = new TicTacToe(tr, tc);

      while (!done)
      {
         System.out.print(game.toString());
         if(game.isDone() == true)
         {
         	done = !done;
         	System.out.println("Game over. " + game.victor + " is the winner!");
         }
         else
         {
         	System.out.print(
               	"Row for " + player + " (-1 to exit): ");
         	int row = in.nextInt();
         	if (row < 0) done = true;
         	else
         	{
            	System.out.print("Column for " + player + ": ");
            	int column = in.nextInt();
            	game.set(row, column, player);
            	if (player.equals("x"))
               		player = "o";
            	else
               		player = "x";
         	}
      	 }
   	  }
   }
}
