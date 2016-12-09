/**
 * @author      Zachary Job
 * @version     1                
 * @date       5/1/2013         
 **/

/**
 *Manages the simulation post wookie assignment
 *
 *NOTE ON VARS: To prevent creating too many variables, all were 
 *instatiated as private (also to make then inaccessable =])
 **/
public class LMHash
{
	private Location[] loc; //locations
	private TimeMachine[] tm; //time machines
	private TimeMachine[] temp; //temporary time machine array for manipulating 
	private int k; //counting int
	private int x; //coutning int
	
   /**
	*contructor setting up locations and time machines
	*
	*@param l for locations
	*@param t for time machines
	**/
	public LMHash(Location[] l, TimeMachine[] t)
	{
		addLoc(l);
		addTM(t);
	}
	
   /**
	*adds a location or dosen't
	*
	*@param l for location
	**/
	private void addLoc(Location[] l)
	{
		if(l.length==0)
		{
			loc = null;
			return;
		}
		loc = new Location[l.length];
		for(int i = 0; i < l.length; i++)
			loc[i] = new Location(l[i].getLName(),l[i].getRating(),l[i].getEName(),l[i].getType());
	}
	
   /**
	*adds a time machine or dosen't
	*
	*@param t for time machine
	**/
	private void addTM(TimeMachine[] t)
	{
		if(t.length==0)
		{
			tm = null;
			return;
		}
		tm = new TimeMachine[t.length];
		for(int i = 0; i < t.length; i++)
			tm[i] = new TimeMachine(t[i].getName(),t[i].getIns(),t[i].getWookieA(),t[i].getWookieB());
	}
	
   /**
	*simulates given good input
	*
	*@return timemachine to give to main for re sim (later once I get there)
	**/
	public TimeMachine[] hash()
	{
		if(tm!=null && loc!=null)
		{	
			k = 0;
			
			if(loc.length>tm.length)
			{
				for(int i = 0, j = 0; i < tm.length && j<loc.length; i++, j++)
				{
					if(tm[i].getInt()!=0)
						k++;
				}
			}
			else
				k = loc.length;
			
			temp = new TimeMachine[k];
			
			//if there are too many wookie pairs... KILL THEM!
			if(tm.length>k)
			{
				for(int i = k; i<tm.length; i++)
					System.out.println(tm[i].getWookieA() + " and " + tm[i].getWookieB() + " died in a fiery explosion\n");
			}
			
			//adjust to remove the dead wookies! no one will ever know...
			System.arraycopy(tm, 0, temp, 0, k);
			
			//simple hash
			for(int i = 0, j = 0; i < temp.length; i++)
			{
				j = ((20*temp[i].getIns()/temp[i].getInt())%loc.length); //the algorithm for location
				
				//initial poke
				if(loc[j].isUsed()==false)
				{
					loc[j].simulate(temp[i]);
					loc[j].toggleUsed();
				}
				//tombstone
				else
				{
					x = j;
					for(; x<loc.length; x++) //>>>>>>>>>>>>>>>>>>>>
					{
						if(loc[x].isUsed()==false)
						{
							loc[x].simulate(temp[i]);
							loc[x].toggleUsed();
							j = x;
							x = loc.length+1;
						}
					}
					if(x==loc.length)
					{
						x = j;
						for(; x>=0; x--) //<<<<<<<<<<<<<<<<<<
						{
							if(loc[x].isUsed()==false)
							{
								loc[x].simulate(temp[i]);
								loc[x].toggleUsed();
								j = x;
								x = -1;
							}
						}
					}
					x = 0;
				}
				System.out.println("["+loc[j].getEName()+"] @ Location " + j + "\n");
			}
			k = 0;
			return secureTemp();
		}
		else
			return null;
	}
	
   /**
	*Well, I enjoy having no non private variables, therefore this is
	**/
	private TimeMachine[] secureTemp()
	{
		TimeMachine[] ref = temp;
		temp = null;
		return ref;
	}
}