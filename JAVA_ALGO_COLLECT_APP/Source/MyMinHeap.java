/**
 * @author      Zachary Job
 * @version     1                
 * @date       4/1/2013         
 **/

/**
 *
 *
 *NOTE ON VARS: To prevent creating too many variables, all were 
 *instatiated as private (also to make then inaccessable =])
 **/
public class MyMinHeap
{
	private Comparable [] theHeap; //Heap for storage
	private int size = 0; //cap used
	
	/**
	 *Blank Constructor
	**/
	public MyMinHeap() //PASSED
	{
		theHeap = new Comparable[25];
	}
	
	/**
	 *Constuctor with new capicity
	 *
	 *@param: cap is the desired tree size
	**/
	public MyMinHeap(int cap) //PASSED
	{
		this();
		if(cap > 0 && cap < Integer.MAX_VALUE)
			theHeap = new Comparable[cap];
	}
	
	/**
	 *Constructor with custom array and range to select array portion 
	 *
	 *@param: arr is an array of aobjects
	 *@param: n is the length
	**/
	public MyMinHeap(Comparable [] arr, int n) //PASSED
	{
		this();
		if(arr != null)
		{	
			if(n > arr.length || n < 1)
				n = arr.length;
			theHeap = new Comparable[n];
			for(int i = 0; i < n; i++)
			{
				theHeap[i] = arr[i];
				if(arr[i] != null)
					size++;
			}
			buildHeap();
		}
	}
	
	/**
	 *Returns the capacity used
	 *
	 *@return: returns size
	**/
	public int size() //PASSED
	{
		return size;
	}
	
	/**
	 *Adds comparable o to the end of the tree
	 *
	 *@param: o is the object to add
	 *@return: boolean
	**/
	public boolean add(Comparable o) //PASSED
	{
		if(size < Integer.MAX_VALUE && o != null)
		{
			if(size >= theHeap.length)
			{
				Comparable [] temp = theHeap;
				size++;
				theHeap = new Comparable[size];
				for(int i=0; i<size-1; i++)
					theHeap[i] = temp[i];
				theHeap[size-1] = o;
				shiftUp(size-1);
					
				return true;
			}
			else
			{
				theHeap[size] = o;
				size++;
				shiftUp(size-1);
			}
		}
		return false;
	}
	
	/**
	 *Removes the root and replaces it with the last value
	 *
	 *@return: object removed
	**/
	public Comparable removeMin() //PASSED
	{
		if(size > 0)
		{
			Comparable temp = theHeap[0];
			theHeap[0] = theHeap[size-1];
			theHeap[size-1]=null;
			size--;
			shiftDown(0);
			
			return temp;
		}
		return null;
	}
	
	/**
	 *Removes the ith object
	 *
	 *@param: index to remove
	 *@return: return removed object
	**/
	public Comparable remove(int i) //PASSED
	{
		if(size > 0 && i <= size-1 && i >= 0)
		{
			Comparable temp = theHeap[i];
			theHeap[i]=theHeap[size-1];
			theHeap[size-1]=null;
			size--;
			shiftUp(i);
			shiftDown(i);
			
			return temp;
		}
		return null;
	}
	
	/**
	 *Removes the index with the given object
	 *
	 *@param: o to remove
	 *@return: the object removed
	**/
	public Comparable remove(Comparable o) //PASSED
	{
		if(o != null)
		{
			for(int i = 0; i < size; i++)
			{
				if(o.compareTo(theHeap[i])==0)
					return remove(i);	
			}
		}
		return null;
	}
	
	/**
	 *Shifts said index to its right location downwards
	 *
	 *@param: index to shift don
	**/
	private void shiftDown(int index) //PASSED
	{	
		if(index < (size/2) && index >= 0)
		{
			int lc=(2*index)+1;
			if(lc+1 < size && theHeap[lc].compareTo(theHeap[lc+1]) > 0) //All Powerful Greater-Than Sign
				lc++;
			if(theHeap[index].compareTo(theHeap[lc])>0)
			{
				swap(index,lc);
				shiftDown(lc);
			}
		}
	}
	
	/**
	 *Shifts up x index to its appropriate location
	 *
	 *@param: index to shift
	 *@return: end location of shift
	**/
	private int shiftUp(int index) //PASSED - TEST OUTPUT
	{
		if(index < size && index > 0) //IDX >= 0 OEM
		{
			int parent = (index-1)/2;
			if(theHeap[index].compareTo(theHeap[parent]) < 0)
			{
				swap(index, parent);
				return shiftUp(parent);
			}
		}
		return index;
	}
	
	/**
	 *Swaps two indexes in the array
	 *
	 *@param: x is the first to swap
     *@param: y is the second to swap
	**/
	private void swap(int x, int y) //PASSED
	{
		Comparable temp;
		temp = theHeap[x];
		theHeap[x] = theHeap[y];
		theHeap[y] = temp;
	}
	
	/**
	 *Sorts the array
	**/
	private void buildHeap() //PASSED
	{
		for(int i = (size/2)-1; i>=0; i--)
			shiftDown(i);
	}
	
	/**
	 *Prints out the tree
	**/
	public Comparable[] parse() //PASSED - IMPLEMENT TOSTRING
	{ 
		if(size>0)
		{
			Comparable[] bob = new Comparable[size];
			for(int i = 0; i < size; i++)
				bob[i] = theHeap[i];
			return bob;
		}
		return null;
	}
	/**
	 *DEBUGGING - IGNORE =========================================================================
	**/
	public void debug()
	{
		System.out.println(size);
		for(int i=0; i<theHeap.length; i++)
			System.out.print(theHeap[i] + " ");
		System.out.println();
		System.out.println();
	}
}