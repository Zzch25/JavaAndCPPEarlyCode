//Zachary Job
//10.29.11
//V 1

//main.cpp

#include <string>
#include <stdlib.h> 
#include <sstream>
#include "myGraph.h"
#include "main.h"

using namespace std;

int main()
{
	bool isDone = false; //Looping Condition
	string in; //temp input string
	int tempIn; //temporary input int
	int tempIn2; //temporary input int
	myGraph G; //myGraph Object
	
	cout<<"WARNING: CODE USES LINEAR MATRIX BECAUSE RACECAR - REQUIRES LOTS-O-MEMORY\n";
	cout<<"NOTE: ORDER WILL BE POINTED TO DURING THE PRINT\n";
	cout<<"===========================================================================";
	
	//enter node amount loop
	while(!isDone)
	{
		cout<<"\nEnter how many nodes ranging from one up\n";
			
		//input
		getline(cin, in);
		stringstream intIn(in);
		(intIn)>>tempIn;
		
		if(G.initialize(tempIn) == 0)
			isDone = !isDone; //exit
	}
		
	isDone = !isDone;
	
	//options loop
	while(!isDone)
	{	
		cout<<"\nQ - Quit\nA - Add Edge\nR - Remove Edge\nP - Print Edge\nB - Breadth-First Search\nD - Depth-First Search\n>>";
		
		//input
		getline(cin, in);
		stringstream stringIn(in);
		(stringIn)>>in;
		
		//exit
		if(in == "q")
		{
			isDone = !isDone;
			G.dec();
		}
		//add edge
		else if(in == "a")
		{
			while(!isDone)
			{
				cout<<"\nEnter the first node\n";
			
				//input
				getline(cin, in);
				stringstream intX(in);
				(intX)>>tempIn;
				
				cout<<"\nEnter the second node\n";
				
				//input
				getline(cin, in);
				stringstream intY(in);
				(intY)>>tempIn2;
			
				if(G.addEdge(tempIn,tempIn2) == 0)
					isDone = !isDone;
			}
			isDone = !isDone;
		}
		//remove edge
		else if(in == "r")
		{
			while(!isDone)
			{
				cout<<"\nEnter the first node\n";
			
				//input
				getline(cin, in);
				stringstream intX(in);
				(intX)>>tempIn;
				
				cout<<"\nEnter the second node\n";
				
				//input
				getline(cin, in);
				stringstream intY(in);
				(intY)>>tempIn2;
				
				if(G.remEdge(tempIn,tempIn2) == 0)
					isDone = !isDone;
			}
			isDone = !isDone;
		}
		//print edges
		else if(in == "p")
		{
			G.printEdges();
		}
		//breadth first search
		else if(in == "b")
		{
			cout<<"\nEnter a starting node\n";
				
			//input
			getline(cin, in);
			stringstream intIn(in);
			(intIn)>>tempIn;
			
			G.breadth(tempIn);
		}
		//depth first search
		else if(in == "d")
		{
			cout<<"\nEnter a starting node\n";
				
			//input
			getline(cin, in);
			stringstream intIn(in);
			(intIn)>>tempIn;
			
			G.depth(tempIn);
		}
		
	}
}
