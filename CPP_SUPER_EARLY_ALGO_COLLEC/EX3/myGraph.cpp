//Zachary Job
//10.29.11
//V 1

//myGraph.cpp

#include "myGraph.h"
#include <queue>
#include <stdio.h>
#include <math.h>

using namespace std;

int *M;
int *Set;
int tempN;
int nodes;
queue<int> searchQ;

//Make the class object
myGraph::myGraph(){}

/*
Sets the variables

@param in node amount
@return fail or pass
*/
int myGraph::initialize(int in)
{
	if(in > 1)
	{
		nodes = in;
		M = new int[nodes*nodes];
		Set = new int[nodes];
		return 0;
	}
	return 1;
}

/*
Adds an edge

@param x node 1
@param y node 2
@return fail or pass
*/
int myGraph::addEdge(int x,int y)
{
	if(x <= nodes && y <= nodes && x > 0 && y > 0)
	{
		M[nodes*(x-1)+(y-1)] = 1;
		M[nodes*(y-1)+(x-1)] = 1;
		return 0;
	}
	return 1;
}

/*
Removes an edge

@param x node 1
@param y node 2
@return fail or pass
*/
int myGraph::remEdge(int x,int y)
{
	if(x <= nodes && y <= nodes && x > 0 && y > 0)
	{
		M[nodes*(x-1)+(y-1)] = 0;
		M[nodes*(y-1)+(x-1)] = 0;
		return 0;
	}
	return 1;
}

/*
Prints edges
*/
void myGraph::printEdges()
{
	cout<<"\nEdges Available:\n";
	
	int modI;
	
	for(int i = 0; i < nodes*nodes; i++)
	{
		modI = i%nodes;
		if(modI == 0)
			modI = nodes;
		
		if(M[i] == 1)
		{
			cout<<(i-i%nodes)/nodes+1<<" & "<<(i%nodes)+1<<" [M["<<i<<"]M]"<<"\n";
		}
	}
}

/*
Breadth First Search

@param start is the starting node
*/
void myGraph::breadth(int start)
{ 
	cout<<"\nBreadth First Traversal: Note start will be pushed no matter\n";
	
	cleanSet();
	
	if(start < 1 || start > nodes)
	{
		start = 1;
	}
	
	searchQ.push(start);
	Set[start-1] = 1;
	
	while(searchQ.empty() == false)
	{
		tempN = searchQ.front();
		cout<<"<<POPPING: "<<tempN<<" <-\n";
		
		searchQ.pop();

		int j = ((tempN-1)*nodes);
		for(int i = j; i < j+nodes; i++)
		{
			if(M[i]==1 && Set[i-j] != 1)
			{	
				cout<<">>PUSHING: "<<i-j+1<<"\n";
				searchQ.push(i-j+1);
				Set[i-j] = 1;
			}
		}
	}
}

/*
Depth First Search

@param start is the starting node
*/
void myGraph::depth(int start)
{
	cout<<"\nDepth First Traversal: Note start will be pushed no matter\n";
	
	cleanSet();
		
	if(start < 1 || start > nodes)
	{
		start = 1;
	}
	
	myGraph::depthCore(start);
}

/*
Depth First Search recursive helper

@param start is the starting node
*/
void myGraph::depthCore(int start)
{
	cout<<">>PUSHING: "<<start<<" <-\n";
	
	Set[start-1] = 1;
	
	int j = ((start-1)*nodes);
	for(int i = j; i < j+nodes; i++)
	{ 
		if(M[i]==1 && Set[i-j] != 1)
		{
			depthCore(i-j+1);
			cout<<"<<POPPING: "<<i-j+1<<"\n";
		}
	}
}

/*
Cleans set for reuse
*/
void myGraph::cleanSet()
{
	for(int i = 0; i < nodes; i++)
		Set[i] = 0;
}

void myGraph::dec()
{
	delete[] M;
	delete[] Set;
}