/**
 * @(#)PatronClass.java
 *
 *
 * @Marcus Cudina
 * @version 1.00 2012/2/28
 *
 *preconditions: so last decade
 *postcondition: voltswagon veyron <- who are they fooling... pfff Bugatti, might as well drive a beetle or eck, a lupo... nobody loves the lupo. oh yes the tester uses this class
 */

public class PatronClass
{
  private String myFirstName;//first name
  private String myLastName;//last name
  private int bookID;//ISBN
  private int cID;//card ID

 /**
  *Constructor
  *@param First Name
  *@param Last Name
  *@param Card ID
  */

  public PatronClass(String first, String last, int ID)
  {
  	myFirstName = first;
  	myLastName = last;
  	bookID = 0;
  	cID = ID;
  }

 /**
  *Returns the proper name only for comparison
  *@return full name
  */

  public String tempString()
  {
  	return myFirstName + " " + myLastName;
  }

 /**
  *Returns the entire patron's status
  *@return card ID + full name
  */

  public String toString()
  {
  	return "(Card ID: " + cID + ") " + myFirstName + " " + myLastName;
  }

 /**
  *change patron information
  *@param First Name
  *@param Last Name
  *@param Card ID
  */

  public void cI(String first, String last)
  {
  	myFirstName = first;
  	myLastName = last;
  }

 /**
  *Gives the patron a book ISBN
  *@param inputed ISBN
  */

  public void ISBN(int id)
  {
  	bookID = id;
  }

 /**
  *Returns the patrons current book
  *@return current ISBN value
  */

  public int getISBN()
  {
  	return bookID;
  }

 /**
  *Returns the patron card ID
  *@return patron card ID
  */

  public int cardID()
  {
  	return cID;
  }
}
