/**
   A 3 x 3 tic-tac-toe board.
*/
public class TicTacToe
{
   /**
      Constructs an empty board.
   */
   String victor;
   int ROWS;
   int COLUMNS;

   public TicTacToe(int r, int c)
   {
   	  ROWS = r;
   	  COLUMNS = c;
   	  victor = "";
      board = new String[ROWS][COLUMNS];
      // Fill with spaces
      for (int i = 0; i < ROWS; i++)
         for (int j = 0; j < COLUMNS; j++)
            board[i][j] = " ";
   }

   /**
      Sets a field in the board. The field must be unoccupied.
      @param i the row index
      @param j the column index
      @param player the player ("x" or "o")
   */
   public void set(int i, int j, String player)
   {
      if (board[i][j].equals(" "))
         board[i][j] = player;
   }

   /**
      Creates a string representation of the board, such as
      |x  o|
      |  x |
      |   o|
      @return the string representation
   */
   public String toString()
   {
      String r = "";
      for (int i = 0; i < ROWS; i++)
      {
         r = r + "|";
         for (int j = 0; j < COLUMNS; j++)
         {
            r = r + board[i][j];
         }
         r = r + "|\n";
      }
      return r;
   }
   public String isVictor()
   {
   		return victor;
   }
   public boolean isDone()
   {
   		int trip = 0;
   		String comparator = "";
   		String x = "";
   		String xc = "x";
   		String oc = "o";
   		String winner = "";
   		int count = 0;
   		int size = 0;

		System.out.println("Debug:");//
      	for(int a = 0; a<2; a++)
      	{
      		if(a==0)
      		{
      			comparator=xc;
      		}
      		else
      		{
      			comparator=oc;
      		}
      		if(trip == 0)
      		{
      			for (int i = 0; i < ROWS; i++)//horizontal check, will check any size tic tac toe board
      			{
      				x = "";
         			for (int j = 0; j < COLUMNS; j++)
         			{
						if(trip == 0)
						{
							if(board[i][j] == comparator)
							{
								x += board[i][j];
							}
							size = 0;
							if(j == COLUMNS - 1 & x.length()==COLUMNS)
							{
								do
								{
									if(size == x.length() - 1)
									{
										if(comparator.equalsIgnoreCase(x.substring(size)))
										{
											trip = 1;
										}
										else
										{
											trip = 0;
										}
									}
									else if(size < x.length() - 1)
									{
										if(comparator.equalsIgnoreCase(x.substring(size, size+1)))
										{
											trip = 1;
										}
										else
										{
											trip = 0;
										}
									}
									size++;
								}
								while(trip == 1 & 0 != x.length()-size);
								if(trip==1)
								{
									winner = comparator;
								}
							}
						}
         			}
      			}
      		}
      		if(trip == 0)
      		{
      			for (int j = 0; j < COLUMNS; j++)//vertical check, will check any size tic tac toe board
      			{
      				x = "";
         			for (int i = 0; i < ROWS; i++)
         			{
						if(trip == 0)
						{
							if(board[i][j] == comparator)
							{
								x += board[i][j];
							}
							size = 0;
							if(i == ROWS - 1 & x.length()==ROWS)
							{
								do
								{
									if(size == x.length() - 1)
									{
										if(comparator.equalsIgnoreCase(x.substring(size)))
										{
											trip = 1;
										}
										else
										{
											trip = 0;
										}
									}
									else if(size < x.length() - 1)
									{
										if(comparator.equalsIgnoreCase(x.substring(size, size+1)))
										{
											trip = 1;
										}
										else
										{
											trip = 0;
										}
									}
									size++;
								}
								while(trip == 1 & 0 != x.length()-size);
								if(trip==1)
								{
									winner = comparator;
								}
							}
						}
         			}
      			}
      		}
      		if(trip == 0 & COLUMNS - ROWS >= 0)
      		{
      			for (int i = 0; i <= COLUMNS-ROWS; i++)//Diagnol left to right check, will check any size tic tac toe board
      			{
      				x = "";
      				count = 0;
      				for(int j = 0; j < COLUMNS; j++)
      				{
						if(trip == 0)
						{
							if(board[i + count][j] == comparator & x.length() < COLUMNS)
							{
								x += board[i + count][j];
								count++;
							}
							size = 0;
							if(j == COLUMNS - 1 & x.length()==COLUMNS)
							{
								do
									{
									if(size == x.length() - 1)
									{
										if(comparator.equalsIgnoreCase(x.substring(size)))
										{
											trip = 1;
										}
										else
										{
											trip = 0;
										}
									}
									else if(size < x.length() - 1)
									{
										if(comparator.equalsIgnoreCase(x.substring(size, size+1)))
										{
											trip = 1;
										}
										else
										{
											trip = 0;
										}
									}
									size++;
								}
								while(trip == 1 & 0 != x.length()-size);
								if(trip==1)
								{
									winner = comparator;
								}
							}
						}
					}
      			}
      		}
      		if(trip == 0 & COLUMNS - ROWS >= 0)
      		{
      			for (int i = 0; i <= COLUMNS-ROWS; i++)//Diagnol right to left check, will check any size tic tac toe board
      			{
      				x = "";
      				count = 0;
      				for(int j = COLUMNS - 1; j >= 0; j--)
      				{
						if(trip == 0)
						{

							if(board[i + count][j] == comparator & x.length() < ROWS)
							{
								x += board[i+count][j];
								count++;
							}
							size = 0;
							if(j == 0 & x.length()==ROWS)
							{
								do
									{
									if(size == x.length() - 1)
									{
										if(comparator.equalsIgnoreCase(x.substring(size)))
										{
											trip = 1;
										}
										else
										{
											trip = 0;
										}
									}
									else if(size < x.length() - 1)
									{
										if(comparator.equalsIgnoreCase(x.substring(size, size+1)))
										{
											trip = 1;
										}
										else
										{
											trip = 0;
										}
									}
									size++;
								}
								while(trip == 1 & 0 != x.length()-size);
								if(trip==1)
								{
									winner = comparator;
								}
							}
						}
					}
      			}
      		}
      	}
      	if(trip == 1)
      	{
      		victor = winner;
      		return true;
      	}
      	return false;
   }

   private String[][] board;
}
