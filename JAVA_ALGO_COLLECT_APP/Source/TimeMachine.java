/**
 * @author      Zachary Job
 * @version     1                
 * @date       5/1/2013         
 **/

import java.util.Random;

 /**
 *
 *
 *NOTE ON VARS: To prevent creating too many variables, all were 
 *instatiated as private (also to make then inaccessable =])
 **/
public class TimeMachine implements Comparable<TimeMachine>
{
	private Random gen; //random for generating different stats
	private int instability; //time machines instability
	private String tName; //time machines name
	
	private boolean active = false; //is active boolean
	private Wookie wA = null; //the head wookie
	private Wookie wB = null; //the junior wookie
	private int maxIns = 10; //maximum instability
	private String tmGName = "Generic Time Machine"; //default generated name
	
	private int temp; //temporary int
	private Wookie tempW; //temporary wookie for manipulation
	
   /**
	*generates a random time machine
	**/
	public TimeMachine()
	{
		gen = new Random();
		
		instability = gen.nextInt(maxIns)+1;
		tName = tmGName;
		
		wA = null;
		wB = null;
		
		temp = 0;
		tempW = null;
	}
	
   /**
	*creates a user generated time machine
	*
	*@param n is the name
	*@param ins is the instability
	**/
	public TimeMachine(String n, int ins)
	{
		if(!n.equals(""))
			tName = n;
		else
			tName = tmGName;
		if(ins > maxIns)
			instability = maxIns;
		else if(ins < 0)
			instability = 0;
		else
			instability = ins;
			
		wA = null;
		wB = null;
		
		temp = 0;
		tempW = null;
	}
	
   /**
	*creates a time machine with wookies and call previous constructor
	*
	*@param n is the name
	*@param ins is the instability
	*@param A is the head wookie
	*@param B is the junior wookie
	**/
	public TimeMachine(String n, int ins, Wookie A, Wookie B)
	{
		this(n,ins);
		
		wA=A;
		wB=B;
	}
	
   /**
	*returns the instability
	*
	*@return instability... you know
	**/
	public int getIns()
	{
		return instability;
	}
	
   /**
	*sets the time machine as active
	**/
	public void setActive()
	{
		active = true;
	}
	
   /**
	*sets the time machine as innactive 
	**/
	public void setInactive()
	{
		active = false;
	}
	
   /**
	*returns if the machine is active
	*
	*@return active... meh
	**/
	public boolean isActive()
	{	
		return active;
	}
	
   /**
	*returns the name
	*
	*@return tName is the time machine name
	**/
	public String getName()
	{
		return tName;
	}
	
   /**
	*adds the head wookie
	*
	*@param A is the head wookie
	**/
	public void addWookieA(Wookie A)
	{
		wA = A;
	}
	
   /**
	*adds the junior wookie
	*
	*@param B is the junior wookie
	**/
	public void addWookieB(Wookie B)
	{
		wB = B;
	}
	
   /**
	*returns the head wookie
	*
	*@return wA is the head wookie
	**/
	public Wookie getWookieA()
	{
		return wA;
	}
	
   /**
	*returns the junior wookie
	*
	*@return wB is the junior wookie
	**/
	public Wookie getWookieB()
	{
		return wB;
	}
	
   /**
	*"kills" the head wookie
	*
	*@return secureW returns the removed wookie
	**/
	public Wookie killWookieA()
	{
		tempW = wA;
		wA = null;
		
		check();
		
		return secureW();
	}
	
   /**
	*"kills" the junior wookie
	*
	*@return secureW returns the removed wookie
	**/
	public Wookie killWookieB()
	{
		tempW = wB;
		wB = null;
		
		check();
		
		return secureW();
	}
	
   /**
	*checks if at least a wookie is alive else the machine becomes innactive
	**/
	public void check()
	{
		if(wA == null && wB == null)
			setInactive();
	}
	
   /**
	*returns the combined engineering skill
	*
	*@return secureTemp gives the combined engineering skill
	**/
	public int getEng()
	{
		if(wA != null)
			temp += wA.getEng();
		if(wB != null)
			temp += wB.getEng();
			
		return secureTemp();
	}
	
   /**
	*returns the combined intelligence
	*
	*@return secureTemp gives the combined intelligence
	**/
	public int getInt()
	{
		if(wA != null)
			temp += wA.getRank();
		if(wB != null)
			temp += wB.getRank();
			
		return secureTemp();
	}
	
   /**
	*returns the head wookie's fortitude
	*
	*@return secureTemp gives the head wookie's fortitude
	**/
	public int getFortA()
	{
		if(wA != null)
			temp = wA.getFort();
		
		return secureTemp();
	}
	
   /**
	*returns the junior wookie's fortitude
	*
	*@return secureTemp gives the junior wookie's fortitude
	**/
	public int getFortB()
	{
		if(wB != null)
			temp = wB.getFort();
		
		return secureTemp();
	}
	
   /**
	*returns the head wookie's wisdom
	*
	*@return secureTemp gives the head wookie's wisdom
	**/
	public int getWisA()
	{
		if(wA != null)
			temp = wA.getAge();
		
		return secureTemp();
	}
	
   /**
	*returns the junior wookie's wisdom
	*
	*@return secureTemp gives the junior wookie's wisdom
	**/
	public int getWisB()
	{
		if(wB != null)
			temp = wB.getAge();
		
		return secureTemp();
	}
	
   /**
	*Well, I enjoy my private variables so much, that I made this
	*
	*@return ref is an int
	**/
	private int secureTemp()
	{
		int ref = temp;
		temp = 0;
		return ref;
	}
	
   /**
	*I do love my private varibales so, therefore this exists
	*
	*@return ref is a wookie
	**/
	private Wookie secureW()
	{
		Wookie ref = tempW;
		tempW = null;
		return ref;
	}
	
   /**
	*overides compareto to compare instability
	*
	*@return less equal or greater than
	**/
	public int compareTo(TimeMachine in)
	{
		if(this.getIns()==in.getIns())
			return 0;
		else if(this.getIns()>in.getIns())
			return 1;
		return -1;
	}
	
   /**
	*overides the tostring method
	*
	*@return string of the name and instability
	**/
	public String toString()
	{
		return tName + " " + instability;
	}
}