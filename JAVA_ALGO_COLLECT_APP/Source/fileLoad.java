/**
 * @author      Zachary Job
 * @version     1                
 * @date       5/1/2013         
 **/

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.DataInputStream;

/**
 *Loads the file with error proofing
 *
 *NOTE ON VARS: To prevent creating too many variables, all were 
 *instatiated as private (also to make then inaccessable =])
 **/
public class fileLoad
{
	private static File file; //file instance for location etc
	private static FileInputStream fIn; //in stream
	private static BufferedInputStream bIn; //speed up buffer
	private static DataInputStream dIn; //data stream
	private static int rLen; //length of read info when split
	private static String rFF; //string of raw input
	private static String[] read; //split of rFF (raw input)
	private static String[] temp; //the inputed data of a line is split to this
	private static String[] eT; //extra split for locations event and rating
	
	private static String wCR; //the amount of wookies expected pre parse
	private static String lCR; //the amount of locations expected pre parse
	private static String tCR; //the amount of time machines expected pre parse
	private static int wC; //expected lines of wookies
	private static int lC; //expected lines of locations
	private static int tC; //expected lines of time machines
	
	private static Location tempLoc; //used to hold a new location
	private static Location[] tempLA; //used to expand locations
	
	private static int subAm = 5; //amount of characters that can be input before cut off
	private static String defLoc = "filename.dat"; //default file location
	private static final String iFi = "[^0-9]"; //integer string filter
	
   /**
	*constructs a fileload with everything set to a blank state
	**/
	public fileLoad()
	{
		rFF  = "";
		file = new File(defLoc);
		fIn = null;
		bIn = null;
		dIn = null;
		read = null;
		temp = null;
		eT = null;
		wCR = null;
		lCR = null;
		tCR = null;
		wC = 0;
		lC = 0;
		tC = 0;
		tempLoc = null;
		tempLA = null;
	}
	
   /**
	*changes the desired file location to the input
	*
	*@param location is the new destination
	**/
	public static void changeFile(String location)
	{
		file = new File(location);
	}
	
   /**
	*this performs the file load operations
	*
	*@param wookies wookie list to be modified
	*@param timemachines is a list to be modified
	*@param locations is a list of locations
	*@return locations is the locations passed from process
	**/
	public static Location[] loadFile(Qsort Wookies, MyPriorityQueue TimeMachines, Location[] Locations)
	{			
		try 
		{
			//open up to reading
			fIn = new FileInputStream(file);
			bIn = new BufferedInputStream(fIn); 
			dIn = new DataInputStream(bIn);
			
			rFF = "";
			
			while(dIn.available() != 0)
				rFF = rFF + dIn.readLine() + "<<!>>"; //add new line and splitter
					
			Locations = Process(Wookies, TimeMachines, Locations);

			fIn.close();
			bIn.close();
			dIn.close();
					  
			System.out.println("Result: Done Processing");
		} 
		catch (FileNotFoundException e) 
		{	
			PLE();
			System.out.println("Error Finding File -  Bad Directory");
			file = new File(defLoc);
			System.out.println("Default Directory " + defLoc + " Set");
		} 
		catch (IOException e) 
		{
			PLE();
			System.out.println("Internal Error - Play Nice ;)");
		}
		return Locations;
	}
	
   /**
	*takes the input and inputs this into appropriate lists etc
	*
	*@param wookies is a list of wookies
	*@param timemachines is a queue of timemachines
	*@param locations is a list of locations
	*@return locations returns the modified locations
	**/
	public static Location[] Process(Qsort Wookies, MyPriorityQueue TimeMachines, Location[] Locations)
	{
		read = rFF.split("<<!>>"); //split into an array where each splitter was inserted

		//process file header line to find expected info
		rLen = read.length;
		wCR = read[0].split(" ")[0].replaceAll(iFi, "");
		if(wCR.length()>subAm) wCR = wCR.substring(0,subAm);
		lCR = read[0].split(" ")[1].replaceAll(iFi, "");
		if(lCR.length()>subAm) lCR = lCR.substring(0,subAm);
		tCR = read[0].split(" ")[2].replaceAll(iFi, "");
		if(tCR.length()>subAm) tCR = tCR.substring(0,subAm);
		
		if(wCR.equals("") || lCR.equals("") || tCR.equals("") || read[0].split(" ").length != 3)
			return Locations;
		
		wC = Integer.parseInt(wCR);
		lC = Integer.parseInt(lCR);
		tC = Integer.parseInt(tCR);
		
		for(int i = 1; i < rLen; i++)
		{
			//process expected wookies
			if(wC > 0)
			{
				temp = read[i].split(" ");
				if(temp.length == 5)
				{
					for(int n = 1; n<5; n++)
					temp[n] = temp[n].replaceAll(iFi,"");
					if(temp[1].equals("")) temp[1] = "0";
					if(temp[1].length()>subAm) temp[1] = temp[1].substring(0,subAm);
					if(temp[2].equals("")) temp[2] = "0";
					if(temp[2].length()>subAm) temp[2] = temp[2].substring(0,subAm);
					if(temp[3].equals("")) temp[3] = "0";
					if(temp[3].length()>subAm) temp[3] = temp[3].substring(0,subAm);
					if(temp[4].equals("")) temp[4] = "0";
					if(temp[4].length()>subAm) temp[4] = temp[4].substring(0,subAm);
					
					Wookies.add(new Wookie(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4])));
					System.out.println("Wookie Loaded");
				}
				wC--;
			}
			//process expected locations
			else if(lC > 0)
			{
				temp = read[i].split("\\|");
				if(temp.length == 3)
				{
					eT = temp[2].split(" ");
					
					if(eT.length == 2)
					{
						eT[1] = eT[1].replaceAll(iFi,"");
						if(eT[1].equals("")) eT[1] = "250";
						if(eT[1].length()>subAm) eT[1] = eT[1].substring(0,subAm);
						
						tempLoc = new Location(temp[0], Integer.parseInt(eT[1]), temp[1], eT[0]); 
						if(Locations == null)
						{	
							Locations = new Location[1];
							Locations[0] = tempLoc;
						}
						else
						{
							tempLA = Locations; 
							Locations = new Location[Locations.length+1];
							System.arraycopy(tempLA,0,Locations,0,tempLA.length);
							Locations[Locations.length-1]=tempLoc;
						}

						System.out.println("Location Loaded");
					}
				}
				lC--;
			}
			//process expected time machines
			else if(tC > 0)
			{
				temp = read[i].split("\\|");
				if(temp.length == 2)
				{
					temp[1] = temp[1].replaceAll(iFi,"");
					if(temp[1].equals("")) temp[1] = "5";
					if(temp[1].length()>subAm) temp[1] = temp[1].substring(0,subAm);
					
					TimeMachines.enqueue(new TimeMachine(temp[0], Integer.parseInt(temp[1])));
					System.out.println("Time Machine Loaded");
				}
				tC--;
			}
			else
				i = rLen;
		}
		wCR = null;
		lCR = null;
		tCR = null;
		wC = 0;
		lC = 0;
		tC = 0;
		tempLA = null;
		tempLoc = null;
		read = null;
		temp = null;
		eT = null;
		Wookies.sort();
		return Locations;
	}
	
   /**
	*prints an error print line
	**/
	private static void PLE()
	{
		System.out.println("ERROR==========================================");
	}
}