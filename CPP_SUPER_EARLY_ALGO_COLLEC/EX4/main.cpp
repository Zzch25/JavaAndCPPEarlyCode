//Zachary Job
//10.29.11
//V 1

//main.cpp

#include "myGraph.h"
#include "main.h"

using namespace std;

int main()
{
	int tempIn; //temporary input int
	int tempIn2; //temporary input int
	int tempIn3; //temporary input int
	//:::::::
	string in; //temp input string
	//:::::::
	bool isDone = false; //Looping Condition
	bool directed = false; //Whether graph is weighted
	//:::::::
	myGraph G; //myGraph Object
	
	cout<<"WARNING: CODE USES LINEAR MATRIX!\n";
	cout<<"NOTE: ORDER WILL BE POINTED TO DURING THE PRINT\n";
	cout<<"===========================================================================";
	
	cout<<"\nEnter how many nodes ranging from 1 to under 1000\n";
		
	//input
	do
	{
		getline(cin, in);
		stringstream intIn(in);
		(intIn)>>tempIn;
	}while(G.getBounds(tempIn) == 0);
		
	cout<<"\nChoose if directed (y/n)\n";
		
	//input
	do
	{
		getline(cin, in);
		stringstream boolIn(in);
		(boolIn)>>in;
	}while(in != "y" && in != "n");
		
	if(in == "y")
		directed = true;
		
	G.initialize(tempIn, directed);
	
	//options loop
	while(!isDone)
	{	
		cout<<"\nQ - Quit\nA - Add Edge\nR - Remove Edge\nP - Print Edge\nB - Breadth-First Search\nD - Depth-First Search\nJ - Dijkstra's Path Costs\nF - Floyd's All-Pairs Costs\n>>";
		
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
			cout<<"\nEnter the first node\n";
			
			//input
			do
			{
				getline(cin, in);
				stringstream intX(in);
				(intX)>>tempIn;
			}while(G.getBoundsNodes(tempIn) == 0);
				
			cout<<"\nEnter the second node which cannot equal the first\n";
				
			//input
			do
			{
				getline(cin, in);
				stringstream intY(in);
				(intY)>>tempIn2;
			}while(G.getBoundsNodes(tempIn2) == 0 || tempIn2 == tempIn);
				
			cout<<"\nEnter a positive weight under 1000\n";
				
			//input
			do
			{
				getline(cin, in);
				stringstream intZ(in);
				(intZ)>>tempIn3;
			}while(G.getBounds(tempIn3) == 0);
			
			G.addEdge(tempIn,tempIn2,tempIn3);
		}
		//remove edge
		else if(in == "r")
		{
			cout<<"\nEnter the first node\n";
			
			//input
			do
			{
				getline(cin, in);
				stringstream intX(in);
				(intX)>>tempIn;
			}while(G.getBoundsNodes(tempIn) == 0);
				
			cout<<"\nEnter the second node which cannot equal the first\n";
				
			//input
			do
			{
				getline(cin, in);
				stringstream intY(in);
				(intY)>>tempIn2;
			}while(G.getBoundsNodes(tempIn) == 0 || tempIn2 == tempIn);
				
			G.remEdge(tempIn,tempIn2);
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
			do
			{
				getline(cin, in);
				stringstream intIn(in);
				(intIn)>>tempIn;
			}while(G.getBoundsNodes(tempIn) == 0);
			
			G.breadth(tempIn);
		}
		//depth first search
		else if(in == "d")
		{
			cout<<"\nEnter a starting node\n";
				
			//input
			do
			{
				getline(cin, in);
				stringstream intIn(in);
				(intIn)>>tempIn;
			}while(G.getBoundsNodes(tempIn) == 0);
			
			G.depth(tempIn);
		}
		//Dijkstra's
		else if(in == "j")
		{
			cout<<"\nEnter a starting node\n";
				
			//input
			do
			{
				getline(cin, in);
				stringstream intIn(in);
				(intIn)>>tempIn;
			}while(G.getBoundsNodes(tempIn) == 0);
			
			G.dijkstra(tempIn);
		}
		//Floyd's
		else if(in == "f")
		{
			cout<<"\nEnter a starting node\n";
				
			//input
			do
			{
				getline(cin, in);
				stringstream intIn(in);
				(intIn)>>tempIn;
			}while(G.getBoundsNodes(tempIn) == 0);
			
			cout<<"\n";
			
			G.floyd(tempIn);
		}
	}
}
