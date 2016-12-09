/**
 * @author      Zachary Job
 * @version     1                
 * @date       4/1/2013         
 */

public class TestPriorityQueue
{
	public static void main(String [] args)
	{
		Comparable[] arr = new Comparable[] {99,3,-1,2,100,1,10,4,2,2,3,9,10,52};
		//Comparable[] arr = new Comparable[] {};
		Comparable num = 2;
		
		//MIN HEAP TEST ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		
		System.out.println("****************************************************************************");
		System.out.println("****************************************************************************");
		
		//DEFAULT
		MyMinHeap bob = new MyMinHeap();
		
		//Initial Read Out
		bob.debug();
		bob.parse();
		
		//Add&Remove Sector
		bob.removeMin();
		bob.debug();
		bob.parse();
		bob.remove(2);
		bob.debug();
		bob.parse();
		bob.add(125);
		bob.debug();
		bob.parse();
		bob.add(225);
		bob.debug();
		bob.parse();
		bob.add(1);
		bob.debug();
		bob.parse();
		bob.add(5);
		bob.debug();
		bob.parse();
		bob.add(9);
		bob.debug();
		bob.parse();
		bob.add(4);
		bob.debug();
		bob.parse();
		bob.add(525);
		bob.debug();
		bob.parse();
		bob.remove(3);
		bob.debug();
		bob.parse();
		
		System.out.println("****************************************************************************");
		System.out.println("****************************************************************************");
		
		//ARR INT
		bob = new MyMinHeap(50);
		
		//Initial Read Out
		bob.debug();
		bob.parse();
		
		System.out.println("****************************************************************************");
		System.out.println("****************************************************************************");
		
		//ARR INT
		bob = new MyMinHeap(arr,arr.length);
		
		//Initial Read Out
		bob.debug();
		bob.parse();
		
		//Add&Remove Sector
		bob.removeMin();
		bob.debug();
		bob.parse();
		bob.removeMin();
		bob.debug();
		bob.parse();
		bob.remove(2);
		bob.debug();
		bob.parse();
		bob.remove(6);
		bob.debug();
		bob.parse();
		bob.remove(9);
		bob.debug();
		bob.parse();
		bob.add(125);
		bob.debug();
		bob.parse();
		bob.add(225);
		bob.debug();
		bob.parse();
		bob.add(1);
		bob.debug();
		bob.parse();
		bob.add(5);
		bob.debug();
		bob.parse();
		bob.add(9);
		bob.debug();
		bob.parse();
		bob.add(4);
		bob.debug();
		bob.parse();
		bob.add(525);
		bob.debug();
		bob.parse();
		bob.remove(15);
		bob.debug();
		bob.parse();
		
		System.out.println("****************************************************************************");
		System.out.println("****************************************************************************");
		
		//PRIORITY QUEUE TESTING :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		MyPriorityQueue loppy = new MyPriorityQueue(arr,arr.length);
		
		//Returns
		System.out.println("Status:::::::::::::::::::::::::::::::::::");
		System.out.println(loppy.peek());
		System.out.println(loppy.isEmpty());
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::");
		
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		
		System.out.println("Status:::::::::::::::::::::::::::::::::::");
		System.out.println(loppy.peek());
		System.out.println(loppy.isEmpty());
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::");
		
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		System.out.println(loppy.dequeue());
		
		System.out.println("Status:::::::::::::::::::::::::::::::::::");
		System.out.println(loppy.peek());
		System.out.println(loppy.isEmpty());
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::");
	}
}