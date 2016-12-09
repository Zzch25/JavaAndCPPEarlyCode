//Zachary Job
//10.29.11
//V 1

//Sortings.h

#include <iostream>

//Set up Sortings as an object
class myGraph
{
	public:
		myGraph(); //Prepare for class object
		static int initialize(int);
		static int addEdge(int,int);
		static int remEdge(int,int);
		static void printEdges();
		static void breadth(int);
		static void depth(int);
		static void dec(); //Clean up
	private:
		static void cleanSet();
		static void depthCore(int);
}; 