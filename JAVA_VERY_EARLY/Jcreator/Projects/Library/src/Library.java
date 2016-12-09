/**
 * @(#)Library.java
 * @Zachary Job
 * @version 1 2012/2/28
 */

import java.util.Scanner; //for user input
import java.util.ArrayList; //for arraylist use

/**
 * Note: This project is unfinished. This project currently only contains a tester, but it will be broken into a class and tester in later revisions. -25
 *preconditions: come at me bra, this program will run all day son
 *postconditions: 25
 *
 *BUILD WISH LIST:
 *-#1 (once options complete) - split tester into a class and tester
 *-check with eric over checkout limit
 *-serialization
 *-cls for display
 */

public class Library
{
    public static void main(String[] args)
    {
    	Scanner in = new Scanner(System.in);//user input via next/Line
    	ArrayList<PatronClass> bob = new ArrayList<PatronClass>();//holds patrons
    	ArrayList<Book> aReallyLongNameForAnArrayListForAClassNamedBooks = new ArrayList<Book>();//holds books
    	boolean done = false;//used for prompt while logic to exit from printed option panes
    	boolean shoe = false;//used as a logic assist in long operations
    	String input = "";//used to take input

    	/**
    	 *temps used to input information into a new book and/or patron and sometimes take user input just because
    	 */
    	String temp = "";
    	String temp2 = "";
    	String temp3 = "";

    	String b = "-----------------25-----------------"; //line break
    	String pch = "Input Interpreted as "; //prompt for post input
    	String inv = "an Invalid Answer"; //undesired input yielded an operation opposite the prompt
    	String iop = "Input an Option: "; //no comment! (paradox?)

    	/**
    	 *opts used as 2+ stage booleans to control the current option pane selected
    	 */
    	int opt = 0;
    	int opt2 = 0;
    	int opt3 = 0;

    	int trip = 0;//allows for a pane to be printed via skipping operations, printing, then returning
    	int cIDi = 0;//tracks for the upcoming patron ID
    	int inttemp = 0;//for book quantity

	  	System.out.println("Welcome to the Library of 25");
	  	System.out.println("Program Will Return From Options Due to Invalid Search Requests");
    	System.out.println();
    	System.out.println("Please Input Correlating Numbers or Information");

    	while(!done) //main program loop
    	{
    		/**
    		 *the main interface
    		 */
    		System.out.println("Type Q to Quit");
			System.out.println(b);
			System.out.println("1 - Manage Patrons");
			System.out.println("2 - Manage Books");
			System.out.println(b);
			System.out.print(iop);

			input = ((in.nextLine()).replaceAll("[^1|2|q|Q]", ""));//filter and input
			if(input.length()>1)//prevents substring error @ 1 character
			{
				input = input.substring(0,1);//replace
			}
			System.out.print(pch);
			if(input.equals(""))//invalid input
			{
				System.out.println(inv);
			}
			else if(input.equalsIgnoreCase("q"))//exit
			{
				System.out.println("I Desperately Want to Leave This Program");
				System.out.println(b);
				System.out.println("Exiting...");
				done = !done;//end main loop
			}
			else//everything's cool bro
			{
				System.out.println(input);
				System.out.println(b);
				opt = Integer.parseInt(input);//user option of main pane

				while(!done)
				{
					if(trip == 0)//trip allowing for pane to print @ 0
					{
						System.out.println("Type Q to Return");
						System.out.println(b);
					}
					else//execution @ trip = 1 of option
					{
						input = ((in.nextLine()).replaceAll("[^1|2|3|q|Q]", ""));//another filter allowing 3 options
						if(input.length()>1)//prevents substring error @ length = 1
						{
							input = input.substring(0,1);//replace all but first character
						}

						System.out.print(pch);

						if(input.equalsIgnoreCase("q"))//quit pane
						{
							opt = 0;
							done = !done;
							System.out.println(input);
							System.out.println(b);
							trip = 2;
						}
						else if(input.equals(""))//invalid
						{
							System.out.println(inv);
							System.out.println(b);
							trip = 2;
						}
						else
						{
							opt2 = Integer.parseInt(input);//allow another pane and user input
						}
					}
					if(opt == 1)//option 1 main pane
					{
						if(trip == 0)//trip for printing pane
						{
							System.out.println("1 - Register/Remove/Edit Patron");
							System.out.println("2 - Check Patron Status");
						}
						else if(trip == 1)//trip for operations
						{
							if(opt2 != 3)//if three is excluded (opt2 accepts 3 as option 2 of the main pane contains three options)
							{
								System.out.println(input);
								System.out.println(b);

								if(opt2 == 1)//register/remove
								{
									while(!done) //teh loop for teh pane
									{
										System.out.println("Type Q to Return");
										System.out.println(b);
										System.out.println("1 - Register Patron");
										System.out.println("2 - Remove Patron");
										System.out.println("3 - Edit Patron");
										System.out.println(b);
										System.out.print(iop);

										input = ((in.nextLine()).replaceAll("[^1|2|3|q|Q]", ""));//le filter
										if(input.length() > 1)//prevent substring error @ length = 1
										{
											input = input.substring(0, 1);//replace all but first character
										}
										System.out.print(pch);
										if(input.equalsIgnoreCase("q"))//quit pane
										{
											System.out.println(input);
											System.out.println(b);
											done = !done;
										}
										else if(input.equals(""))//invalid input
										{
											System.out.println(pch + inv);
											System.out.println(b);
										}
										else//keep on rolling
										{
											System.out.println(input);
											System.out.println(b);
											opt3 = Integer.parseInt(input);//turn input into an integer

											/**
											 *register a patron
											 */

											if(opt3 == 1)
											{
												System.out.print("Please Enter a First Name (spaces will be removed): ");
												input = (in.nextLine()).replaceAll("\\s+", "");//filter spaces
												temp = input;//ready for patron instantiation
												System.out.println(b);

												System.out.print("Please Enter a Last Name (spaces will be removed): ");
												input = (in.nextLine()).replaceAll("\\s+", "");//filter spaces
												temp2 = input;//ready for patron instantiation
												System.out.println(b);

												cIDi++;//increment next id for new patrons
												bob.add(new PatronClass(temp, temp2, cIDi));//add a patron

												System.out.println(bob.get(bob.size()-1) + " Was Successfully Added");//prints new patron status +...
												System.out.println(b);
											}

											/**
											 *check viability of removing a patron and restoring items
											 */

											else if(opt3 == 2)//size is not null
											{
												if(bob.size() > 0)
												{
													System.out.print("Input a Patron ID to Remove: ");
													input = in.nextLine().replaceAll("[^0-9]", "");//input and filter
													System.out.println(b);

													if(!input.equals(""))//not invalid
													{
														for(int i = 0; i <= bob.size() - 1; i++)//cycle patrons
														{
															if(Integer.parseInt(input) == bob.get(i).cardID())//match found
															{
																if(bob.get(i).getISBN() != 0)//check if patron has a book
																{
																	for(int x = 0; x <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; x++)//cycle to find book
																	{
																		if(aReallyLongNameForAnArrayListForAClassNamedBooks.get(x).getISBN() == bob.get(i).getISBN())//book found
																		{
																			aReallyLongNameForAnArrayListForAClassNamedBooks.get(x).cQUp(true);//return book
																			System.out.println("Book Forcibly Returned Because Racecar");
																			System.out.println(b);
																			x = aReallyLongNameForAnArrayListForAClassNamedBooks.size();//end loop cycle
																		}
																	}
																}
																System.out.println("Patron Removed");
																System.out.println(b);
																bob.remove(i);
																i = bob.size() + 1;
															}
															else if(i == bob.size() - 1)//if no match is found
															{
																	System.out.println("Invalid Patron");
																	System.out.println(b);
															}
														}
													}
													else//invalid ID
													{
														System.out.println(pch + inv);
														System.out.println(b);
													}
												}
												else//---------------------\/-----------------------
												{
													System.out.println("No Patrons Available");
													System.out.println(b);
												}
											}

											/**
											 *Edit a patron's name
											 */

											else
											{
												if(bob.size() > 0)//patrons available
												{
													System.out.print("Please Input a Patron ID to Change His/Her Name: ");
													input = in.nextLine().replaceAll("[^0-9]", "");//input and filter

													if(input.equals(""))//invalid
													{
														System.out.println(pch + inv);
														System.out.println(b);
													}
													else
													{
														for(int i = 0; i <= bob.size() - 1; i++)//cycle patrons
														{
															if(Integer.parseInt(input) == bob.get(i).cardID())//id match
															{
																System.out.println("Match Found: " + bob.get(i));
																System.out.println(b);

																System.out.print("Please Enter a First Name (spaces will be removed): ");
																input = (in.nextLine()).replaceAll("\\s+", "");//filter spaces
																temp = input;//ready for patron edit
																System.out.println(b);

																System.out.print("Please Enter a Last Name (spaces will be removed): ");
																input = (in.nextLine()).replaceAll("\\s+", "");//filter spaces
																temp2 = input;//ready for patron edit
																System.out.println(b);

																bob.get(i).cI(temp, temp2);//change patron name

																System.out.println("Editing Completed: " + bob.get(i));
																System.out.println(b);

																i = bob.size();//end loop
															}
															else if(i == bob.size() - 1)
															{
																System.out.println("No Matches Found");
																System.out.println(b);
															}
														}
													}
												}
												else
												{
													System.out.println("No Patrons Available");
													System.out.println(b);
												}
											}
										}
									}
									done = !done;//end while loop
									trip = 2;//trip reset
								}

								/**
								 *check patrons option
								 */

								else
								{
									if(bob.size() > 0) //patrons are available
									{
										while(!done)//loop for option pane
										{
											System.out.println("Type Q to Return");
											System.out.println(b);
											System.out.println("1 - Print All Patrons");
											System.out.println("2 - Search All Patrons");
											System.out.println(b);

											System.out.print(iop);

											input = ((in.nextLine()).replaceAll("[^1|2|q|Q]", ""));//input and filter
											if(input.length()>1)//prevent substring error @ length = 1
											{
												input = input.substring(0,1);//replace all but first character
											}

											System.out.print(pch);

											if(input.equalsIgnoreCase("q"))//quit
											{
												System.out.println(input);
												System.out.println(b);
												done = !done;
											}
											else if(input.equals(""))//invalid
											{
												System.out.println(inv);
												System.out.println(b);
											}
											else//good to go
											{
												System.out.println(input);
												System.out.println(b);
												opt3 = Integer.parseInt(input);//translate input into an int

												/**
											 	 *print all patrons
											 	 */

												if(opt3 == 1)
												{
													System.out.println("Patrons Registered:");
	   												for(int i = 0; i <= bob.size() - 1; i++)//loop through all patrons
													{
														if(bob.get(i).getISBN() == 0)//do not have a book
														{
															System.out.println(bob.get(i));
														}
														else//have a book
														{
															System.out.println(bob.get(i) + " Has Book " + bob.get(i).getISBN());//print with book status
														}
													}
													System.out.println(b);
												}

												/**
											 	 *patron search pane
											 	 */

												else
												{
													while(!done)//option pane loop
													{
														System.out.println("Type Q to Return");
														System.out.println(b);
														System.out.println("1 - Search by Name");
														System.out.println("2 - Search by ID");
														System.out.println(b);
														System.out.print(iop);

														input = ((in.nextLine()).replaceAll("[^1|2|q|Q]", ""));//input and filter
														if(input.length() > 1)//prevent substring error @ length = 1
														{
															input = input.substring(0, 1);//replace all but first character
														}
														System.out.print(pch);
														if(input.equalsIgnoreCase("q"))//quit
														{
															System.out.println(input);
															System.out.println(b);
															done = !done;
														}
														else if(input.equals(""))//invalid
														{
															System.out.println(inv);
															System.out.println(b);
														}
														else//awesome
														{
															shoe = false;
															System.out.println(input);
															System.out.println(b);
															opt3 = Integer.parseInt(input);//translate input to an integer

															/**
											 				 *search by name
											 				 */

															if(opt3 == 1)
															{
																System.out.print("Input a Patron's First and Last Name (Include a Space): ");
																input = in.nextLine();//input

																System.out.println(b);

																for(int i = 0; i <= bob.size() - 1; i++)//loop through patrons
																{
																	if((bob.get(i).tempString()).equalsIgnoreCase(input))//match found
																	{
																		System.out.print("Match Found: ");
																		if(bob.get(i).getISBN() == 0)//if nothing borrowed
																		{
																			System.out.println(bob.get(i));
																		}
																		else//borrowed book
																		{
																			System.out.println(bob.get(i) + " Has Book " + bob.get(i).getISBN());//patron and borrowed book
																		}
																		shoe = true;
																	}
																	else if(i == bob.size() - 1 & shoe == false)//no comment for you (another paradox)
																	{
																		System.out.println("No Matches Found");
																	}
																}
																System.out.println(b);
															}
															else
															{
																System.out.print("Input a Patron's ID: ");
																input = in.nextLine().replaceAll("[^0-9]", "");//input and filter
																System.out.println(b);

																if(!input.equals(""))//not invalid input
																{
																	for(int i = 0; i <= bob.size() - 1; i++)//cycle through patrons
																	{
																		if(bob.get(i).cardID() == Integer.parseInt(input))//check for ID matches
																		{
																			System.out.print("Match Found: ");
																			if(bob.get(i).getISBN() == 0)//no book
																			{
																				System.out.println(bob.get(i));
																			}
																			else//borrowed book
																			{
																				System.out.println(bob.get(i) + " Has Book " + bob.get(i).getISBN());//print patron with book status
																			}
																			shoe = true;
																		}
																		else if(i == bob.size() - 1 & shoe == false)//no
																		{
																			System.out.println("Match Not Found");
																		}
																	}
																	System.out.println(b);
																}
																else//invalid input
																{
																	System.out.print(pch + inv);
																	System.out.print(b);
																}
															}
														}
													}
													done = !done;//end pane
												}
											}
										}
										done = !done;//end pane
									}
									else//no again
									{
										System.out.println("No Patrons Available");
										System.out.println(b);
									}
									trip = 2;//reset trip
								}
							}
							else//if opt2 did = 3 no
							{
								System.out.println(pch + inv);
								System.out.println(b);
								trip = 2;
							}
						}
					}
					else if(opt == 2)
					{

						if(trip == 0)//initial trip allowing for option print
						{
							System.out.println("1 - Register/Remove Book");
							System.out.println("2 - Check Book Status");
							System.out.println("3 - Sign Out/Return Book");
						}
						else if(trip == 1)//after trip
						{
							System.out.println(input);
							System.out.println(b);

							/**
							 *Register Remove Pane
							 */

							if(opt2 == 1)
							{
								while(!done)//loop for pane
								{
									System.out.println("Type Q to Return");
									System.out.println(b);
									System.out.println("1 - Register Book");
									System.out.println("2 - Remove Book");
									System.out.println(b);
									System.out.print(iop);

									input = ((in.nextLine()).replaceAll("[^1|2|q|Q]", ""));//input filter
									if(input.length() > 1)//prevent substring error @ length = 1
									{
										input = input.substring(0, 1);//replace all but first character
									}
									System.out.print(pch);
									if(input.equalsIgnoreCase("q"))//quit
									{
										System.out.println(input);
										System.out.println(b);
										done = !done;
									}
									else if(input.equals(""))//invalid
									{
										System.out.println(inv);
										System.out.println(b);
									}
									else//good
									{
										System.out.println(input);
										System.out.println(b);
										opt3 = Integer.parseInt(input); //turn input into into integer

										/**
										 *register a book
										 */

										if(opt3 == 1)
										{

											do //loop till valid isbn
											{
												shoe = false;//reset for do loop if invalid
												System.out.print("Please Input a 'Numerical' ISBN: ");
												temp = in.nextLine().replaceAll("[^0-9]", "");//input and filter
												System.out.println(b);
												if(temp.equals("") | temp.equals("0"))//void if null or 0 aka default trip
												{
													System.out.println("Invalid ISBN - Input a Proper Value");
													System.out.println(b);
													shoe = true;
												}
												else
												{
													for(int i = 0; i <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; i++)//check if isbn exists
													{
														if(aReallyLongNameForAnArrayListForAClassNamedBooks.get(i).getISBN() == Integer.parseInt(temp))
														{
															shoe = true;
														}
													}
												}
											}
											while(shoe == true);

											System.out.print("Please Input a Title: ");
											temp2 = in.nextLine();//input
											System.out.println(b);

											System.out.print("Please Input an Author (First and Last Name): ");
											temp3 = in.nextLine();//input
											System.out.println(b);

											System.out.print("Input a Quantity for This Title: ");
											input = in.nextLine().replaceAll("[^0-9]", "");

											if(input.equals(""))
											{
												System.out.println("Invalid Input - Quantity Set to 1");
												System.out.println(b);

												inttemp = 1;
											}
											else
											{
												inttemp = Integer.parseInt(input);
											}

											aReallyLongNameForAnArrayListForAClassNamedBooks.add(new Book(Integer.parseInt(temp), temp2, temp3, inttemp)); //new book with all data
											System.out.println(aReallyLongNameForAnArrayListForAClassNamedBooks.get(aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1) + " " + "Was Successfully Added");//print book info
											System.out.println(b);
										}

										/**
										 *remove a book
										 */

										else if(aReallyLongNameForAnArrayListForAClassNamedBooks.size() > 0)//if books available
										{
											System.out.print("Input an ISBN to Remove the Corresponding Book (All of the Same ISBN Will Be Removed): ");
											input = in.nextLine().replaceAll("[^0-9]", "");//filter and input
											System.out.println(b);

											if(input.equals(""))//invalid
											{
												System.out.println(pch + inv);
												System.out.println(b);
											}
											else//good to roll
											{
												for(int i = 0; i <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; i++)//cycle books
												{
													if(Integer.parseInt(input) == aReallyLongNameForAnArrayListForAClassNamedBooks.get(i).getISBN())//match found
													{
														if(aReallyLongNameForAnArrayListForAClassNamedBooks.get(i).getBorrowed() == true)//if book is out
														{
															for(int x = 0; x <= bob.size() - 1; x++)//cycle patrons
															{
																if(aReallyLongNameForAnArrayListForAClassNamedBooks.get(i).getISBN() == bob.get(x).getISBN())//patron has a book
																{
																	bob.get(x).ISBN(0);//reset patron to no book status
																	System.out.println("Patron ID " + bob.get(x).cardID() + " Book Status Removed");
																	if(x == bob.size() - 1)
																	{
																		System.out.println(b);
																	}
																}
															}
														}
														System.out.println("Book Removed");
														System.out.println(b);
														aReallyLongNameForAnArrayListForAClassNamedBooks.remove(i);//remove
														i = aReallyLongNameForAnArrayListForAClassNamedBooks.size() + 1;//destroy loop
													}
													else if(i == bob.size() - 1)//no matches found
													{
														System.out.println("No Matches Found");
														System.out.println(b);
													}
												}
											}
										}
										else//no comments available
										{
											System.out.println("No Books Available");
											System.out.println(b);
										}
									}
								}
								done = !done;// end loop
								trip = 2;//trip reset
							}

							/**
							 *print books available, can execute without books but with 0 results
							 */

							else if(opt2 == 2)
							{
								if(aReallyLongNameForAnArrayListForAClassNamedBooks.size() > 0) //patrons are available
								{
									while(!done)//loop for option pane
									{
										System.out.println("Type Q to Return");
										System.out.println(b);
										System.out.println("1 - Print All Books");
										System.out.println("2 - Search All Books");
										System.out.println(b);

										System.out.print(iop);

										input = ((in.nextLine()).replaceAll("[^1|2|q|Q]", ""));//input and filter
										if(input.length()>1)//prevent substring error @ length = 1
										{
											input = input.substring(0,1);//replace all but first character
										}

										System.out.print(pch);

										if(input.equalsIgnoreCase("q"))//quit
										{
											System.out.println(input);
											System.out.println(b);
											done = !done;
										}
										else if(input.equals(""))//invalid
										{
											System.out.println(inv);
											System.out.println(b);
										}
										else//good to go
										{
											System.out.println(input);
											System.out.println(b);
											opt3 = Integer.parseInt(input);//translate input into an int

											/**
										 	 *print all books
										 	 */

											if(opt3 == 1)
											{
												System.out.println("Books Registered:");
	   											for(int i = 0; i <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; i++)//loop through all patrons
												{
													System.out.println(aReallyLongNameForAnArrayListForAClassNamedBooks.get(i));
												}
												System.out.println(b);
											}

										   /**
										 	*book search pane
										 	*/

											else
											{
												while(!done)//option pane loop
												{
													System.out.println("Type Q to Return");
													System.out.println(b);
													System.out.println("1 - Search by Title");
													System.out.println("2 - Search by Author");
													System.out.println("3 - Search by ISBN");
													System.out.println(b);
													System.out.print(iop);

													input = ((in.nextLine()).replaceAll("[^1|2|3|q|Q]", ""));//input and filter
													if(input.length() > 1)//prevent substring error @ length = 1
													{
														input = input.substring(0, 1);//replace all but first character
													}
													System.out.print(pch);
													if(input.equalsIgnoreCase("q"))//quit
													{
														System.out.println(input);
														System.out.println(b);
														done = !done;
													}
													else if(input.equals(""))//invalid
													{
														System.out.println(inv);
														System.out.println(b);
													}
													else//awesome
													{
														shoe = false;
														System.out.println(input);
														System.out.println(b);
														opt3 = Integer.parseInt(input);//translate input to an integer

														/**
											 			 *search by title
											 			 */

														if(opt3 == 1)
														{
															System.out.print("Input a Book's Title (Include any Spaces): ");
															input = in.nextLine();//input

															System.out.println(b);

															for(int i = 0; i <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; i++)//loop through books
															{
																if((aReallyLongNameForAnArrayListForAClassNamedBooks.get(i).tempString()).equalsIgnoreCase(input))//match found
																{
																	System.out.print("Match Found: ");
																	System.out.println(aReallyLongNameForAnArrayListForAClassNamedBooks.get(i));
																	shoe = true;
																}
																else if(i == aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1 & shoe == false)//no comment for you (another paradox)
																{
																	System.out.println("No Matches Found");
																}
															}
															System.out.println(b);
														}
														else if(opt3 == 2)
														{
															System.out.print("Input a Book's Author (Include any Spaces): ");
															input = in.nextLine();//input

															System.out.println(b);

															for(int i = 0; i <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; i++)//loop through books
															{
																if((aReallyLongNameForAnArrayListForAClassNamedBooks.get(i).getAuthor()).equalsIgnoreCase(input))//match found
																{
																	System.out.print("Match Found: ");
																	System.out.println(aReallyLongNameForAnArrayListForAClassNamedBooks.get(i));
																	shoe = true;
																}
																else if(i == aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1 & shoe == false)//no comment for you (another paradox)
																{
																	System.out.println("No Matches Found");
																}
															}
															System.out.println(b);
														}
														else
														{
															System.out.print("Input an ISBN: ");
															input = in.nextLine().replaceAll("[^0-9]", "");//input and filter
															System.out.println(b);
															if(!input.equals(""))//not invalid input
															{
																for(int i = 0; i <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; i++)//cycle through books
																{
																	if(aReallyLongNameForAnArrayListForAClassNamedBooks.get(i).getISBN() == Integer.parseInt(input))//check for ISBN matches
																	{
																		System.out.print("Match Found: ");
																		System.out.println(aReallyLongNameForAnArrayListForAClassNamedBooks.get(i));
																		shoe = true;
																	}
																	else if(i == bob.size() - 1 & shoe == false)//no
																	{
																		System.out.println("Match Not Found");
																	}
																}
																System.out.println(b);
															}
															else//invalid input
															{
																System.out.print(pch + inv);
																System.out.print(b);
															}
														}
													}
												}
												done = !done;//end pane
											}
										}
									}
								}
								else
								{
									System.out.println("No Books Available");
									System.out.println(b);
								}
							trip = 2;
							}

							/**
							 *sign out return pane
							 */

							else
							{
								if(aReallyLongNameForAnArrayListForAClassNamedBooks.size() > 0 & bob.size() > 0) //if book(s) and patron(s) are available
								{
									while(!done)//all powerfull option pane loop
									{
										System.out.println("Type Q to Return");
										System.out.println(b);
										System.out.println("1 - Sign Out a Book");
										System.out.println("2 - Return a Book");
										System.out.println(b);
										System.out.print(iop);

										input = ((in.nextLine()).replaceAll("[^1|2|q|Q]", ""));//input and filter
										if(input.length()>1)//prevent substring error @ length = 1
										{
											input = input.substring(0,1);//replace all but first character
										}

										System.out.print(pch);

										if(input.equalsIgnoreCase("q"))//quit
										{
											System.out.println(input);
											System.out.println(b);
											done = !done;//end pane loop
										}
										else if(input.equals(""))//invalid
										{
											System.out.println(inv);
											System.out.println(b);
										}
										else
										{
											System.out.println(input);
											System.out.println(b);
											opt3 = Integer.parseInt(input);//turn input into a number

											/**
										   	 *sign out a book
										 	 */

											if(opt3 == 1)
											{
												for(int i = 0; i <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; i++)//loop for checking if any book is available for signout
												{
													if(aReallyLongNameForAnArrayListForAClassNamedBooks.get(i).isOut() == false)//if a book is available
													{
														System.out.print("Input the Proper ISBN: ");
														temp = in.nextLine().replaceAll("[^0-9]", "");//input and filter
														System.out.println(b);

														if(temp.equals(""))//invalid
														{
															System.out.println("Invalid ISBN");
														}
														else
														{
															for(int z = 0; z <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; z++)//loop books - check if inputed isbn is available
															{
																if(((aReallyLongNameForAnArrayListForAClassNamedBooks.get(z).getISBN()) == (Integer.parseInt(temp))) & ((aReallyLongNameForAnArrayListForAClassNamedBooks.get(z).isOut())== false)) //if matched and is not out
																{
																	System.out.println("Book is Available");
																	System.out.println(b);

																	System.out.print("Input a Valid Patron ID: ");
																	temp = in.nextLine().replaceAll("[^0-9]", "");//input and filter
																	System.out.println(b);
																	if(!temp.equals(""))//if not invalid
																	{
																		for(int x = 0; x <= bob.size() - 1; x++)//loop patrons
																		{
																			if(Integer.parseInt(temp) == bob.get(x).cardID())//if input matches patron id
																			{
																				if(bob.get(x).getISBN() == 0)//if patron can still borrow
																				{
																					System.out.println("Patron Has Been Granted Access to the Book");
																					System.out.println(b);

																					bob.get(x).ISBN(aReallyLongNameForAnArrayListForAClassNamedBooks.get(z).getISBN());//give patron book id
																					aReallyLongNameForAnArrayListForAClassNamedBooks.get(z).cQUp(false);//change book status to out
																				}
																				else
																				{
																					System.out.println("Issue Attempting to Assign Book - Check Whether Title/Patron is Available");
																					System.out.println(b);
																				}
																				x = bob.size();//end loop
																			}
																			else if(x == bob.size() - 1)// & if for loop is about to finish...
																			{
																				System.out.println("Patron Not Found");
																				System.out.println(b);
																			}
																		}
																	}
																	else
																	{
																		System.out.println(pch + inv);
																		System.out.println(b);
																	}
																	z = aReallyLongNameForAnArrayListForAClassNamedBooks.size();//end loop
																}
																else if(z == aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1)
																{
																	System.out.println("Book Unavailable - I'm Sorry Dave, I Can't Do That");
																	System.out.println(b);
																}
															}
														}
														i = aReallyLongNameForAnArrayListForAClassNamedBooks.size();//end loop
													}
													else if(i == aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1)// & if for loop is about to finish
													{
														System.out.println("Nothing Available for Signout");
														System.out.println(b);
													}
												}
											}

											/**
										   	 *return a book
										 	 */

											else
											{
												for(int i = 0; i <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; i++)//loop books
												{
													if(aReallyLongNameForAnArrayListForAClassNamedBooks.get(i).getBorrowed() == true)//if a title is available for return
													{
														System.out.print("Input the Proper ISBN: ");
														temp = in.nextLine().replaceAll("[^0-9]", "");//input and filter

														if(temp.equals(""))//invalid
														{
															System.out.println("Invalid ISBN");
															System.out.println(b);
														}
														else//catchphrase
														{
															for(int z = 0; z <= aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1; z++)//loop books
															{
																if(aReallyLongNameForAnArrayListForAClassNamedBooks.get(z).getISBN() == Integer.parseInt(temp) & aReallyLongNameForAnArrayListForAClassNamedBooks.get(z).getBorrowed() == true) //if matched and out
																{
																	System.out.print("Input a Patron ID: " );
																	input = in.nextLine().replaceAll("[^0-9]", "");

																	if(!input.equals(""))
																	{
																		for(int x = 0; x <= bob.size() - 1; x++)//loop patrons
																		{
																			if(bob.get(x).cardID() == Integer.parseInt(input) & bob.get(x).getISBN() == aReallyLongNameForAnArrayListForAClassNamedBooks.get(z).getISBN())//if a patron has the book
																			{
																				bob.get(x).ISBN(0);
																				aReallyLongNameForAnArrayListForAClassNamedBooks.get(z).cQUp(true);
																				x = bob.size();
																				System.out.println("Book Returned");
																				System.out.println(b);
																			}
																			else if(x == bob.size() - 1)
																			{
																				System.out.println("Book Not Returned - ID Not Eligible");
																				System.out.println(b);
																			}
																		}
																	}
																	else
																	{
																		System.out.println(pch + inv);
																	}
																	z = aReallyLongNameForAnArrayListForAClassNamedBooks.size();
																}
																else if(z == aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1)//& if at end of for loop...
																{
																	System.out.println("Not A Valid Option");
																	System.out.println(b);
																}
															}
														}
														i = aReallyLongNameForAnArrayListForAClassNamedBooks.size(); //end loop
													}
													else if(i == aReallyLongNameForAnArrayListForAClassNamedBooks.size() - 1)//if nothing is out
													{
														System.out.println("Nothing Available for Return");
														System.out.println(b);
													}
												}
											}
										}
									}
									done = !done;//end pane loop
								}
								else//errors for sign out return if nothing is available
								{
									if(aReallyLongNameForAnArrayListForAClassNamedBooks.size() > 0 & bob.size() == 0)
									{
										System.out.println("No Patrons Available");
										System.out.println(b);
									}
									else if(bob.size() > 0)
									{
										System.out.println("No Books Available");
										System.out.println(b);
									}
									else
									{
										System.out.println("Nothing Available for Manipulation");
										System.out.println(b);
									}
								}
								trip = 2;//activate trip reset
							}
						}
					}
					if(trip == 0)//initial trip to print main panes
					{
						System.out.println(b);
						System.out.print(iop);
						trip++;
					}
					else if(trip == 2)//trip reset
					{
						trip = 0;
					}
				}
				done = !done;//end ever-ee-thing
			}
    	}
    }
}
