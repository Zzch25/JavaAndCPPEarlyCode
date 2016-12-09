/**
 * @author      Zachary Job
 * @version     1                
 * @date       5/1/2013         
 **/
 
import java.util.Scanner; //Imports scanner for user input

/**
 *Runs the user interface
 *
 *NOTE ON VARS: To prevent creating too many variables, all were 
 *instatiated as private (also to make then inaccessable =])
 **/
public class TTWOTOT
{	
	private static Object theAnswer = new Object(); //menu option var
	private static Comparable curr = null; //temporary for the dequeue
	private static fileLoad inputS = new fileLoad(); //creates file loading instance 
	private static MyPriorityQueue TimeMachines = new MyPriorityQueue(); //creates main time machine class
	private static Qsort Wookies = new Qsort(); //creates main wookie class
	private static Wookie toQTA4 = null; //creates temporary wookie to add
	private static Location[] Locations = null;
	private static Location toQTA6 = null; //creates temporary location to add
	private static TimeMachine toQTA5 = null; //creates temporary time machine to add
	private static TimeMachine[] tms = null; //temporary time machine array to hold queue
	private static TimeMachine[] tmsHe = null; //temporary time machine array for shortenting tms to for appropriate wookie size
	
	private static Comparable[] tempCompA = null; //comprable temporary list used to store comparables through ops
	private static Location[] tempLocA = null; //location temporary list used to store comparables through op
	private static MyPriorityQueue tempPrQu = null; //temporary priority queue for holding a pq during an op
	
	//temporary ints for operations taking input
	private static int intTemp1;
	private static int intTemp2;
	private static int intTemp3;
	private static int intTemp4;
	
	//temporary strings for taking inputs
	private static String strTemp1;
	private static String strTemp2;
	private static String strTemp3;
	private static String strTemp4;
	
	private static int subAm = 3; //make integer string input size
	private static final String iFi = "[^0-9]"; //filter for string input

   /**
    *Prints a line for the interface
	**/
	private static void PL()
	{
		System.out.println("===============================================");
	}
	
   /**
    *Takes input from user and filters printing with default or custom choices
	*
	*@param filter is the replace all filter
	*@param cOpt custom option print out
	**/
	private static String input(String filter, String cOpt)
	{
		Scanner in = new Scanner(System.in);
		String temp;
		
		if(cOpt.equals(""))
			System.out.print("Option: ");
		else
			System.out.print(cOpt + ": ");
		temp = (in.nextLine()).replaceAll(filter, "");
		System.out.print("Result: ");
		return temp;
	}
	
   /**
    *Prints exit status
	*
	*@param in IS CURRENTLY REDUNDANT, but I like it this way as I might expand this project to have many many many many menus
	**/
	private static void zeroExit(Object in)
	{
		if(in.equals("0"))
			System.out.println("Exiting Option...");
		else
			System.out.println("Invalid Input");
	}
	
   /**
    *Prints the user mini menus with the option of a custom opt 1 name
	*
	*@param opt is the end string portion to print
	*@param custN overides the default opt 1
	**/
	private static String addMenu(String opt, String custN)
	{
		PL();
		if(custN.equals(""))
			System.out.println("1) Random " + opt);
		else
			System.out.println("1) " + custN + " " + opt);
		System.out.println("2) Specify " + opt);
		System.out.println("0) To Exit");
		PL();
		return input("[^0|1|2]","");
	}
	
   /**
    *Runs the user interface
	**/
	public static void main(String [] args)
	{	
		//command args y/n
		if(args.length > 0)
			inputS.changeFile(args[0]);
		
		System.out.println("Attempting to Load Existing Data...");
		Locations = inputS.loadFile(Wookies, TimeMachines, Locations);//
		PL();
		
		while(!theAnswer.equals("25"))
		{
			System.out.println("1) Show Wookies");
			System.out.println("2) Show Time Machines");
			System.out.println("3) Show Locaions");
			System.out.println("4) Add Wookie");
			System.out.println("5) Add Time Machine");
			System.out.println("6) Add Location");
			System.out.println("7) Load New File");
			System.out.println("8) Run Simulation");
			System.out.println("25) 25");
			PL();
			theAnswer = input("[^1|2|3|4|5|6|7|8|25]","");
			
			if(theAnswer.equals("1"))
			{	
				if(!Wookies.isEmpty())
					System.out.println("\n" + Wookies.toString());
				
				else
					System.out.println("No Wookies Available");
			}
			
			else if(theAnswer.equals("2"))
			{
				if(TimeMachines.isEmpty() == true)		
					System.out.println("No Times Machines Available");
				else
				{
					System.out.println();
					
					//set up temps to dequeue tm
					tempCompA = new Comparable[TimeMachines.getSize()];
					tempPrQu = new MyPriorityQueue();
					
					//de/enqueues and prints all the tms
					for(int i = 0; i<tempCompA.length; i++)
					{
						tempCompA[i] = TimeMachines.dequeue();
						System.out.println(tempCompA[i]);
						tempPrQu.enqueue(tempCompA[i]);
					}
					TimeMachines = tempPrQu;
					tempCompA=null;
					tempPrQu=null;
				}
			}
			
			else if(theAnswer.equals("3"))
			{
				if(Locations != null)
				{
					System.out.println();
					for(int i = 0; i<Locations.length; i++)
						System.out.println(Locations[i].toString());
				}
				else
					System.out.println("No Locations Available");
			}
			
			else if(theAnswer.equals("4"))
			{
				System.out.println("Add A Wookie");
				
				while(!theAnswer.equals("0"))
				{
					theAnswer = addMenu("Wookie", "");
					
					//random time machine
					if(theAnswer.equals("1"))
					{
						toQTA4 = new Wookie();
						Wookies.add(toQTA4);
						
						System.out.println("Random Wookie Added");
					}
					else if(theAnswer.equals("2"))
					{
						System.out.println("Specify Wookie");
						PL();
						
						//user add wookie inteface and ops
						strTemp1 = input("","Name");
						System.out.println(strTemp1);
						strTemp2 = input(iFi,"Age");
						if(strTemp2.length()>subAm)
							strTemp2 = strTemp2.substring(0,subAm);
						if(strTemp2.equals(""))
							strTemp2 = "0";
						intTemp1 = Integer.parseInt(strTemp2);
						System.out.println(intTemp1);
						strTemp2 = input(iFi,"Rank");
						if(strTemp2.length()>subAm)
							strTemp2 = strTemp2.substring(0,subAm);
						if(strTemp2.equals(""))
							strTemp2 = "0";
						intTemp2 = Integer.parseInt(strTemp2);
						System.out.println(intTemp2);
						strTemp2 = input(iFi,"Engineering");
						if(strTemp2.length()>subAm)
							strTemp2 = strTemp2.substring(0,subAm);
						if(strTemp2.equals(""))
							strTemp2 = "0";
						intTemp3 = Integer.parseInt(strTemp2);
						System.out.println(intTemp3);
						strTemp2 = input(iFi,"Fortitude");
						if(strTemp2.length()>subAm)
							strTemp2 = strTemp2.substring(0,subAm);
						if(strTemp2.equals(""))
							strTemp2 = "0";
						intTemp4 = Integer.parseInt(strTemp2);
						System.out.println(intTemp4);
						
						toQTA4 = new Wookie(strTemp1,intTemp1,intTemp2,intTemp3,intTemp4);
						Wookies.add(toQTA4);
						
						strTemp2 = null;
						strTemp1 = null;
						intTemp1 = 0;
						intTemp2 = 0;
						intTemp3 = 0;
						intTemp4 = 0;
					}
					else
						zeroExit(theAnswer);
					toQTA4 = null;
				}
				Wookies.sort();
			}
			
			else if(theAnswer.equals("5"))
			{
				System.out.println("Add A Time Machine");
				
				while(!theAnswer.equals("0"))
				{
					theAnswer = addMenu("Time Machine", "");
					
					//random time machine
					if(theAnswer.equals("1"))
					{
						toQTA5 = new TimeMachine();
						TimeMachines.enqueue(toQTA5);
						
						System.out.println("Random Time Machine Added");
					}
					else if(theAnswer.equals("2"))
					{
						System.out.println("Specify Time Machine");
						PL();
						
						//user add time machine interface and ops
						strTemp1 = input("","Name");
						System.out.println(strTemp1);
						strTemp2 = input(iFi,"Instability");
						if(strTemp2.length()>subAm)
							strTemp2 = strTemp2.substring(0,subAm);
						if(strTemp2.equals(""))
							strTemp2 = "10";
						intTemp1 = Integer.parseInt(strTemp2);
						System.out.println(intTemp1);
						
						toQTA5 = new TimeMachine(strTemp1,intTemp1);
						TimeMachines.enqueue(toQTA5);
						
						strTemp2 = null;
						strTemp1 = null;
						intTemp1 = 0;
					}
					else
						zeroExit(theAnswer);
					toQTA5 = null;
				}
			}
			
			else if(theAnswer.equals("6"))
			{
				System.out.println("Add A Location");
				
				while(!theAnswer.equals("0"))
				{
					theAnswer = addMenu("Location", "");
					
					//add random location
					if(theAnswer.equals("1"))
					{
						toQTA6 = new Location();
						if(Locations == null)
						{
							Locations = new Location[1];
							Locations[0] = toQTA6;
						}
						else
						{
							//add location to an enlarged array
							tempLocA = new Location[Locations.length+1];
							System.arraycopy(Locations,0,tempLocA,0,Locations.length);
							Locations = new Location[tempLocA.length];
							Locations = tempLocA;
							Locations[Locations.length-1]=toQTA6;
						}
						System.out.println("Random Location Added");
					}
					else if(theAnswer.equals("2"))
					{
						System.out.println("Specify Location");
						PL();
						
						//user add location interface and ops
						strTemp3 = input("","Location Name");
						System.out.println(strTemp3);
						strTemp4 = input("","Event Name");
						System.out.println(strTemp4);
						strTemp1 = input(iFi,"Rating");
						if(strTemp1.length()>subAm)
							strTemp1 = strTemp1.substring(0,subAm);
						if(strTemp1.equals(""))
							strTemp1 = "250";
						intTemp1 = Integer.parseInt(strTemp1);
						System.out.println(intTemp1);
						strTemp2 = input("","Event Type");
						if(!strTemp2.equals(""))
							strTemp2=strTemp2.substring(0,1);
						System.out.println(strTemp2);
						
						toQTA6 = new Location(strTemp3,intTemp1,strTemp4,strTemp2);
						if(Locations == null)
						{
							Locations = new Location[1];
							Locations[0] = toQTA6;
						}
						else
						{
							//enlarge locations and add
							tempLocA = new Location[Locations.length+1];
							System.arraycopy(Locations,0,tempLocA,0,Locations.length);
							Locations = new Location[tempLocA.length];
							Locations = tempLocA;
							Locations[Locations.length-1]=toQTA6;
						}
						
						strTemp1 = null;
						strTemp2 = null;
						intTemp1 = 0;
						strTemp3 = null;
						strTemp4 = null;
					}
					else
						zeroExit(theAnswer);	
					tempLocA = null;
					toQTA6 = null;
				}
			}
			
			else if(theAnswer.equals("7"))
			{
				System.out.println("Loading From File...");
				
				while(!theAnswer.equals("0"))
				{
					theAnswer = addMenu("File + Load", "Default");
					
					if(theAnswer.equals("1"))
						Locations = inputS.loadFile(Wookies, TimeMachines, Locations);//
					else if(theAnswer.equals("2"))
					{
						System.out.println("Specify");
						PL();
						strTemp1 = input("","File Directory");
						System.out.println(strTemp1);
						inputS.changeFile(strTemp1);
						Locations = inputS.loadFile(Wookies, TimeMachines, Locations);//
						strTemp1 = null;
					}
					else
						zeroExit(theAnswer);
				}
			}
			
			else if(theAnswer.equals("8"))
			{
				System.out.println("\n\n...Poking About For Time Machines...\n");
				
				tempCompA = Wookies.retList(); //contains wookies now
				tms = new TimeMachine[TimeMachines.getSize()]; //set for dequeue of time machines
				if(TimeMachines.isEmpty() == false && tempCompA != null && Locations != null)
				{		
					//time machine dequeued into an array
					tempPrQu = new MyPriorityQueue();
					for(int i = 0; i<tms.length; i++)
					{
						curr = TimeMachines.dequeue();
						tms[i] = (TimeMachine)curr;
						System.out.println(curr + " Loaded");
						tempPrQu.enqueue(curr);
					}
					TimeMachines = tempPrQu;
					
					System.out.println("\n...Pairing Wookies...");
					
					//pair wookies to time machines
					for(int i = 0, j = 0, wookLen = tempCompA.length-1; i < tms.length; i++, j++, wookLen--)
					{
						System.out.println();
						if(wookLen>0 && wookLen>j)
						{
							tms[i].addWookieA((Wookie)tempCompA[wookLen]);
							System.out.println((Wookie)tempCompA[wookLen] + " picked " + tms[i]);
							tms[i].addWookieB((Wookie)tempCompA[j]);
							System.out.println((Wookie)tempCompA[wookLen] + " took " + (Wookie)tempCompA[j] + " as a partner");
							tms[i].setActive();
							System.out.println("Time Machine " + tms[i] + " is now active");
						}
						else
						{
							//compact time machines to the size of what was actually paired
							tmsHe = tms;
							tms = new TimeMachine[i];
							System.arraycopy(tmsHe,0,tms,0,i);
							//=============================================================
							System.out.println("<!>Out of Wookie Pairs<!>\n");
							i = tms.length;
						}
						if(i == tms.length-1)
							System.out.println("\n<!>Out of Time Machines<!>");
					}
					
					System.out.println("...Simulating Time Travel...\n");
					LMHash simulation = new LMHash(Locations,tms); //temporary, pre multi sim... not private because things may change!
					simulation.hash(); //check deActivate for tm sim
					//for loop -> TimeMachine[] result = simulation.hash() -> locations ::: for multiple sims :::
					
					tempPrQu = null;
				}
				else
					System.out.println("Insufficient Data!");
					
				curr = null;
				tms = null;
				tmsHe = null;
				tempCompA = null;
				
				System.out.println("<<<Simulation Ended - Lack of Flux Capacitors>>>");
			}
			
			else if(!theAnswer.equals("25")) //because 25
			{
				System.out.println("Invalid Option");
			}
			
			else
			{
				System.out.println("Exiting...");
			}
			PL();
		}
	}
}