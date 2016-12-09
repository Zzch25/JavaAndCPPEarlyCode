//Zachary Job
//10.29.11
//V 1

//Sortings.h

#include <string>
#include <stdio.h>
#include <iostream>
#include <sstream>

using namespace std;

//Set up Sortings as an object
class myGraph
{
	public:
		myGraph(); //Prepare for class object
		static void initialize(int, bool);
		static void addEdge(int,int,int);
		static void remEdge(int,int);
		static void printEdges();
		static void breadth(int);
		static void depth(int);
		static void dijkstra(int);
		static void floyd(int);
		static int getBounds(int);
		static int getBoundsNodes(int);
		static void dec(); //Clean up
	private:
		static void cleanSet();
		static void depthCore(int);
		static void floydRec();
		static string dijkstraRec(int);
}; 