/**
 * @author      Zachary Job
 * @version     1                
 * @date       5/1/2013         
 **/

import java.util.Random;

 /**
 *location which also simulates wookie outcomes
 *
 *NOTE ON VARS: To prevent creating too many variables, all were 
 *instatiated as private (also to make then inaccessable =])
 **/
public class Location implements Comparable<Location>
{
	private Random gen; //random for fun location stats
	private String name; //name of location
	private String eName; //name of event
	private int rating; //location rating
	private String type; //type of event
	private boolean used; //whether the location has a time machine
	
	private int maxSpecial = 5; //must match wookie maxSpecial
	private int rateMax = 500; //maximum rating
	private String[] opts = {"Engineering","Fortitude","Wisdom","Intelligence"}; //string of possible events
	
   /**
	*generatess a radnom location
	**/
	public Location()
	{
		gen = new Random();
		eName = opts[gen.nextInt(opts.length)] + " Event";
		used = false;
		
		rating = gen.nextInt(rateMax+1);
		type = (eName.substring(0,1)).toLowerCase();
		name = "Random Encounter Location";
	}
	
   /**
	*generates a location based on user input and the blank constructor for bad input
	*
	*@param n is the name
	*@param r is the rating
	*@param eN is the event name
	*@param t is the event type
	**/
	public Location(String n, int r, String eN, String t)
	{
		this();
		
		if(!n.equals(""))
			name = n;
			
		if(r >= 0 && r <= rateMax)
			rating = r;
			
		if(t.length() > 1)
			t = t.substring(0,1);
		
		for(int i=0; i<opts.length; i++)
		{
			if(t.toLowerCase().equals(opts[i].substring(0,1).toLowerCase()))
			{
				type = t.toLowerCase();
				if(eN.equals(""))
					eName = opts[i] + " Event";
				else
					eName = eN;		
				i = opts.length;
			}
		}
	}
	
   /**
	*toggles whether it hold a time machine
	**/
	public void toggleUsed()
	{
		used = !used;
	}
	
   /**
	*returns if used
	*
	*@return used is whether a time machine took said location
	**/
	public boolean isUsed()
	{
		return used;
	}
	
   /**
	*simulates a time machines outcome given its wookies
	**/
	public void simulate(TimeMachine tM)
	{	
		if(type.equals("e"))
		{
			if(rating <= tM.getEng() || rating == 0)
				System.out.print(tM.getWookieA() + " and " + tM.getWookieB() + " survived an enginnering event ");
			else
			{
				System.out.print(tM.getWookieA() + " and " + tM.getWookieB() + " died in an enginnering event ");
				tM.killWookieA();
				tM.killWookieB();
			}
		}
		else if(type.equals("i"))
		{
			if(rating <= tM.getInt() || rating == 0)
				System.out.print(tM.getWookieA() + " and " + tM.getWookieB() + " survived an intelligence event ");
			else
			{
				System.out.print(tM.getWookieA() + " and " + tM.getWookieB() + " died in an intelligence event ");
				tM.killWookieA();
				tM.killWookieB();
			}
		}
		else if(type.equals("f"))
		{
			if(rating <= tM.getFortA() || rating == 0)
				System.out.print(tM.getWookieA() + " has survived a fortitude event ");
			else
			{
				System.out.print(tM.getWookieA() + " has died in a fortitude event ");
				tM.killWookieA();
			}
			if(rating <= tM.getFortB() || rating == 0)
				System.out.print(tM.getWookieB() + " has survived a fortitude event ");
			else
			{
				System.out.print(tM.getWookieB() + " has died in a fortitude event ");
				tM.killWookieB();
			}
		}
		else if(type.equals("w"))
		{
			if(rating <= tM.getWisA() || rating == 0)
				System.out.print(tM.getWookieA() + " has survived a wisdom event ");
			else
			{
				System.out.print(tM.getWookieA() + " has died in a wisdom event ");
				tM.killWookieA();
			}
			if(rating <= tM.getWisB() || rating == 0)
				System.out.print(tM.getWookieB() + " has survived a wisdom event ");
			else
			{
				System.out.print(tM.getWookieB() + " has died in a wisdom event ");
				tM.killWookieB();
			}
		}
		else
			System.out.println("Magicarp used splash! It was extremely effective!");
	}
	
   /**
	*returns the locations name
	*
	*@return name is the location name
	**/
	public String getLName()
	{
		return name;
	}
	
   /**
	*returns the location event name
	*
	*@return eName is the event name
	**/
	public String getEName()
	{
		return eName;
	}
	
   /**
	*returns the location event type
	*
	*@param type is the location event type
	**/
	public String getType()
	{
		return type;
	}
	
   /**
	*returns the event rating
	*
	*@return rating is the location event rating
	**/
	public int getRating()
	{
		return rating;
	}
	
   /**
	*overide of compare to compare other location ratings
	*
	*@return gives less equal greater
	**/
	public int compareTo(Location in)
	{
		if(this.getRating()==in.getRating())
			return 0;
		else if(this.getRating()>in.getRating())
			return 1;
		return -1;
	}
	
   /**
	*overides toString
	*
	*@return gives the location name + its event rating
	**/
	public String toString()
	{
		return name + " " + rating;
	}
}