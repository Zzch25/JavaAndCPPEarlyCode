/**
 * @(#)Book.java
 *
 *
 * @Andrew Dong & Zach Job
 * @version 1.00 2012/2/28
 *
 *preconditions: nein
 *postconditions: the tester uses this class and the world rejoices
 */

public class Book
{
  private int isbn;//book ISBN
  private int copya;//available amount
  private int totalq;//total quantity
  private String booktitle;//title
  private String bookauthor;//author
  private boolean check;//book's availability

 /**
  *Constructor
  *@param ISBN value
  *@param Book Title
  *@param Book Author
  *@param quantity
  */

  public Book(int input, String title, String author, int amount)
  {
  	isbn = input;
  	booktitle = title;
  	bookauthor = author;
  	check = false;//not out
  	totalq = amount;
  	copya = amount;
  }

  /**
  *Returns boolean over books availability
  *@return return availability
  */

  public boolean isOut()
  {
  	return check;
  }

 /**
  *Changes the current quantity
  *@param increment or decrement
  *if 0 trip to checked out
  */

  public void cQUp(boolean x)
  {
  	if(x == true & (copya < totalq))//if within the proper band for increase
  	{
  		copya++;//increases amount
  	}
  	if(x == false & copya > 0)
  	{
  		copya--;//decrease
  	}
  	if(copya == 0)
  	{
  		check = true;
  	}
  	else
  	{
  		check = false;
  	}
  }

 /**
  *Returns whether a copy is out
  *@return is borrowed
  */

  public boolean getBorrowed()
  {
  	if(totalq > copya)
  	{
  		return true;
  	}
  	else
  	{
  		return false;
  	}
  }

  /**
  *Changes book availability on call
  */

  public void cStat()
  {
  	check = !check;
  }

  /**
  *Returns the books ISBN
  *@return Book ISBN value
  */

  public int getISBN()
  {
  	return isbn;
  }

   /**
  *Returns the proper name only for comparison
  *@return full name
  */

  public String tempString()
  {
  	return booktitle;
  }

   /**
  *Returns the book author
  *@return the author's name
  */

  public String getAuthor()
  {
  	return bookauthor;
  }

  /**
  *Prints book information and availability based on check
  *@return return status + available
  *@return return status + unavailable
  */

  public String toString()
  {
  	if(check == false)
  	{
  		return "(Available @ " + copya + " of " + totalq + " in Inventory) " + isbn + " " + booktitle + " " + bookauthor;
  	}
  	else
  	{
  		return "(Unavailable @ 0 of " + totalq +  " in Inventory) " + isbn + " " + booktitle + " " + bookauthor;
  	}
  }

}