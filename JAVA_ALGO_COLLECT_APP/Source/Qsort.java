/**
 * @author      Zachary Job
 * @version     1                
 * @date       5/1/2013         
 **/

/**
 *holds and sorts a comparable array via Quick Sort
 *
 *NOTE ON VARS: To prevent creating too many variables, all were 
 *instatiated as private (also to make then inaccessable =])
 **/
public class Qsort
{
	private Comparable[] xs; //list to be held and sorted
	private Comparable[] temp; //temporary used for swapping
	private String wookStr; //used for the tostring

   /**
	*blank constructor sets all to null
	**/
	public Qsort()
	{
		xs = null;
		temp = null;
		wookStr = null;
	}
	
   /**
	*adds a comparable to xs
	*
	*@param in is the comparable to add
	**/
	public void add(Comparable in)
	{
		if(xs!=null)
		{
			temp = xs;
			xs = new Comparable[xs.length+1];
			System.arraycopy(temp,0,xs,0,temp.length);	
			xs[temp.length]=in;
			
			temp = null;
		}
		else
		{
			xs = new Comparable[1];
			xs[0] = in;
		}	
	}

   /**
	*calls quicksort with appropriate data
	**/
	public void sort()
	{
		if(xs!=null)
			if(xs.length>1)
				quickSort(0,xs.length-1);
	}
	
   /**
	*recursive sort which uses a pivot
	*
	*@param x is the left point
	*@param y is the right point
	**/
	private void quickSort(int x,int y)
	{
		int l = x;
		int r = y;
		
		if(l<r)
		{
			int p = partition(l,r);
			quickSort(l,p-1);
			quickSort(p+1,r);
		}		
	}
	
   /**
	*moves every thing less than the pivot before it
	*
	*@param l is the left point
	*@param r is the right point
	**/
	private int partition(int l, int r) // moves all less than the pivot before it, etc after
	{
		Comparable x = xs[r];

        int i = l-1;
        int temp=0;

        for(int j=l; j<r; j++)
        {
            if(xs[j].compareTo(x)<=0)
            {
                i++;
                swap(i,j);
            }
        }

        swap(i+1,r);
        return (i+1);
	}

   /**
	*swaps the x and y position of xs
	*
	*@param x is the x position
	*@param y is the y position
	**/
	private void swap(int x, int y)
	{
		Comparable temp;
		temp = xs[x];
		xs[x]=xs[y];
		xs[y]=temp;
	}
	
   /**
	*returns xs
	*
	*@return xs is the held list
	**/
	public Comparable[] retList()
	{
		return xs;
	}
	
   /**
	*returns whether xs is empty
	*
	*@return boolean whether xs is empty
	**/
	public boolean isEmpty()
	{
		if(xs == null)
			return true;
		return false;
	}
	
   /**
	*overides tostring to return all the comparables
	*
	*@return 
	**/
	public String toString()
	{
		wookStr = "";
		
		if(xs != null)
		{
			for(int i = 0; i<xs.length; i++)
			{
				wookStr = wookStr + xs[i].toString();
				if(i!=xs.length-1) 
					wookStr = wookStr + "\n";
			}	
		}
		return secureWStr();
	}
	
   /**
	*my private variables and I are inseperable!
	*
	*@return ref is wookStr
	**/
	private String secureWStr()
	{
		String ref = wookStr;
		wookStr = null;
		return ref;
	}

//DEBUGGING IGNORE===============================================================
	public void debug()
	{
		System.out.println(xs.length);
		System.out.println();
		for(int i = 0; i<xs.length; i++)
			xs[i].toString();
		System.out.println();
	}
}