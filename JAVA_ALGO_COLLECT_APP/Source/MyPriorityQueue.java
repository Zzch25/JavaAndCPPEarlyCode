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
public class MyPriorityQueue
{
	private MyMinHeap theQueue; //PASSED
	
	/**
	 *Creates the default min heap
	**/
	public MyPriorityQueue() //PASSED
	{
		theQueue = new MyMinHeap();
	}
	
	/**
	 *Creates a minheap
	 *
	 *@param: arr is a custom array for the minheap
	 *@param: n is the capacity of the minheap
	 **/
	public MyPriorityQueue(Comparable [] arr, int n) //PASSED
	{
		theQueue = new MyMinHeap(arr, n);
	}
	
	/**
	 *Adds to the min heap
	 *
	 *@param: o is the object to add to the minheap
	**/
	public boolean enqueue(Comparable o) //PASSED
	{
		return theQueue.add(o);
	}
	
	/**
	 *Removes the top of the minheap
	**/
	public Comparable dequeue() //PASSED
	{
		return theQueue.removeMin(); 
	}
	
	/**
	 *Returns the min
	**/
	public Comparable peek() //PASSED
	{
		Comparable temp = dequeue();
		if(temp != null)
			theQueue.add(temp);
		return temp;
	}
	
	public int getSize()
	{
		return theQueue.size();
	}
	
	/**
	 *Returns whether the minheap is empty
	 *
	 *@return: bool whether empty
	**/
	public boolean isEmpty() //PASSED
	{
		if(peek()==null)
			return true;
		return false;
	}
}