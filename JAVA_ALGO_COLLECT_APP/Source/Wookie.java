/**
 * @author      Zachary Job
 * @version     1                
 * @date       5/1/2013         
 **/

import java.util.Random;

/**
 *creates a wookie
 *
 *NOTE ON VARS: To prevent creating too many variables, all were 
 *instatiated as private (also to make then inaccessable =])
 **/
public class Wookie implements Comparable<Wookie>
{
	private Random gen; //used to generate characteristics
	private String name; //wookie name
	private int age; //wookie age
	private int rank; //wookie rank
	private int eng; //wookie engineering skll
	private int fort; //wookie fortitude
	private int TH; //wookie total stat
	private int temp; //temp int used for ops
	private int temp2; //temp int used for ops
	private double tempD; //temp double used for ops
	
	private String[] nameList = {"Bob", "Harny", "Palmer", "Carl", "Paul", "Jimmy", "Loppy", "Mick", "Ike"}; //name list for blank constructor
	private double maxAge = 500; //maximum wookie age
	private double maxSpecial = 5; //must match wookie maxSpecial
	private int THxply = 100; //factor to modify the overall rank of a wookie
	
   /**
	*generates a wookie
	**/
	public Wookie() //Add algorithms to better determine characteristics + Add name db and rnd select
	{
		gen = new Random();
		
		temp = (int)maxAge;
		age = gen.nextInt(temp)+1;
		
		tempD = (100*(age/maxAge))*((maxSpecial-1)/100); //algorithm to determin rank
		temp = (int)tempD; 
		temp2 = (int)maxSpecial;
		
		//each generates based on the previous algorithm except fort
		rank = gen.nextInt(temp2-temp)+temp+1;
		eng = gen.nextInt(temp2-rank/2)+rank/2;
		fort = gen.nextInt(temp2)+1;
		
		name = nameList[gen.nextInt(nameList.length)];
		
		TH = age+rank*THxply;
		
		temp = 0;
		temp2 = 0;
		tempD = 0;
	}

   /**
	*creates a user defined wookie
	*
	*@param n is name
	*@param a is age
	*@param r is rank
	*@param e is engineering
	*@param f is fortitude
	**/
	public Wookie(String n, int a, int r, int e, int f)
	{
		gen = new Random();
		
		if(n == "")
			name = nameList[gen.nextInt(nameList.length)];
		else
			name = n;
		
		if(a > maxAge)
			age = (int)maxAge;
		else if(a < 1)
			age = 1;
		else
			age = a;
			
		if(r > maxSpecial)
			rank = (int)maxSpecial;
		else if(r < 0)
			rank = 0;
		else
			rank = r;
		
		if(e > maxSpecial)
			eng = (int)maxSpecial;
		else if(e < 0)
			eng = 0;
		else
			eng = e;
		
		if(f > maxSpecial)
			fort = (int)maxSpecial;
		else if(f < 0)
			fort = 0;
		else
			fort = f;
			
		TH = age+rank*THxply;
	}

   /**
	*returns the fortitude
	*
	*@return fort is fortitude
	**/
	public int getFort()
	{
		return fort;
	}
	
   /**
	*returns the engineering skill
	*
	*@return eng is the engineering skill
	**/
	public int getEng()
	{
		return eng;
	}
	
   /**
	*returns the rank
	*
	*@return rank is the rank
	**/
	public int getRank()
	{
		return rank;
	}
	
   /**
	*returns the age
	*
	*@return age is the age
	**/
	public int getAge()
	{	
		return age;
	}
	
   /**
	*returns the name
	*
	*@return name is the name
	**/
	public String getName()
	{
		return name;
	}
	
   /**
	*returns the wookies overall status
	*
	*@return TH is the status 
	**/
	public int getTH()
	{
		return TH;
	}
	
   /**
	*overides the compareto method
	*
	*@return less equal greater
	**/
	public int compareTo(Wookie in)
	{
		if(getRank()==in.getRank())
			return 0;
		else if(getRank()>in.getRank())
			return 1;
		return -1;
	}
	
   /**
	*overides the tostring method
	*
	*@return gives the name with rank
	**/
	public String toString()
	{
		return name + " " + rank;
	}
}