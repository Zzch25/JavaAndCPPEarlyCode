//Zachary Job
//10.29.11
//V 1

//myGraph.cpp

#include "myGraph.h"
#include <queue>
#define pp pair<int,int>


int *M;
int *MF;
int *Set;
int *SetD1;
int *SetD2;
//:::::::
int tempN;
int nodes;
int maxEMU = 1000;
//:::::::
string tempS;
stringstream toInt;
//:::::::
bool directed;
//:::::::
queue<int> theQ;

//Make the class object
myGraph::myGraph(){}

/*
Sets the variables

@param in node amount
@param direct for (un/d)irected graph
@return fail or pass
*/
void myGraph::initialize(int in, bool direct)
{
	nodes = in;
	//:::::::
	M = new int[nodes*nodes];
	MF = new int[nodes*nodes];
	Set = new int[nodes];
	SetD1 = new int[nodes];
	SetD2 = new int[nodes];
	//:::::::
	directed = direct;
		
	for(int i = 0; i < nodes*nodes; i++)
	{
		M[i] = maxEMU;
		MF[i] = maxEMU;
	}
}

/*
Adds an edge

@param x node 1
@param y node 2
@param z weight
@return fail or pass
*/
void myGraph::addEdge(int x,int y,int z)
{
	M[nodes*(x-1)+(y-1)] = z;
	if(directed == false)
		M[nodes*(y-1)+(x-1)] = z;
}

/*
Removes an edge

@param x node 1
@param y node 2
@return fail or pass
*/
void myGraph::remEdge(int x,int y)
{
	M[nodes*(x-1)+(y-1)] = maxEMU;
	if(directed == false)
		M[nodes*(y-1)+(x-1)] = maxEMU;
}

/*
Prints edges
*/
void myGraph::printEdges()
{
	cout<<"\nEdges Available:\n";
	
	for(int i = 0; i < nodes*nodes; i++)
	{
		if(M[i] != maxEMU)
			cout<<(i-i%nodes)/nodes+1<<" & "<<(i%nodes)+1<<" @ "<<M[i]<<" [M["<<i<<"]M]"<<"\n";
	}
}

/*
Breadth First Search

@param start is the starting node
*/
void myGraph::breadth(int start)
{ 
	cout<<"\nBreadth First Traversal\n";
	
	cleanSet();
	
	theQ.push(start);
	Set[start-1] = 1;
	
	cout<<">>PUSHING: "<<start<<"\n";
	
	while(theQ.empty() == false)
	{
		tempN = theQ.front();
		cout<<"<<POPPING: "<<tempN<<" <-\n";
		
		theQ.pop();

		int j = ((tempN-1)*nodes);
		for(int i = j; i < j+nodes; i++)
		{
			if(M[i]!=maxEMU && Set[i-j] != 1)
			{	
				cout<<">>PUSHING: "<<i-j+1<<"\n";
				theQ.push(i-j+1);
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
	cout<<"\nDepth First Traversal\n";
	
	cleanSet();
	
	myGraph::depthCore(start);
	cout<<"<<POPPING: "<<start<<"<- \n";
}

/*
Depth First Search recursive helper

@param start is the starting node
*/
void myGraph::depthCore(int start)
{
	cout<<">>PUSHING: "<<start<<"\n";
	
	Set[start-1] = 1;
	
	int j = ((start-1)*nodes);
	for(int i = j; i < j+nodes; i++)
	{ 
		if(M[i]!=maxEMU && Set[i-j] != 1)
		{
			depthCore(i-j+1);
			cout<<"<<POPPING: "<<i-j+1<<"<- \n";
		}
	}
}

/*
Dijkstra's Algorithm for all path weights

@param start is the starting node
*/
void myGraph::dijkstra(int start)
{
	cleanSet();
		
	priority_queue<pp, vector<pp>, greater<pp> > pq;
	
	SetD1[start-1] = 0;
	pq.push(pp(SetD1[start-1],start));
	
	while(pq.empty() == false)
	{
		tempN = pq.top().second;
		pq.pop();
		
		Set[tempN-1] = 1;
		
		for(int i = 0; i < nodes; i++)
		{
			if(SetD1[tempN-1] + M[(tempN-1)*nodes+i] < SetD1[i])
			{
				SetD1[i] = SetD1[tempN-1] + M[(tempN-1)*nodes+i];
				SetD2[i] = tempN;
				
				if(Set[i] != 1)
					pq.push(pp(SetD1[i],i+1));
			}
		}
	}
	
	cout<<"\n";
	
	for(int i = 0; i < nodes; i++)
	{
		tempS = dijkstraRec(i+1);
		if(tempS != "")
			cout<<i+1<<":"<<">"<<start<<tempS<<" @ "<<SetD1[i]<<"\n";
	}
}

/*
Dijkstra function path printer

@param derNoden is the vertex to target
@return is the resultant path in string form
*/
string myGraph::dijkstraRec(int derNoden)
{
	tempS = "";
	
	while(SetD2[derNoden-1] != -1)
	{
		toInt<<derNoden;
		tempS = ">" + toInt.str() + tempS;
		derNoden = SetD2[derNoden-1];
		toInt.clear();
		toInt.str("");
	}
	return tempS;
}

/*
Floyd's Algorithm for all paths

@param start is the starting node
*/
void myGraph::floyd(int start)
{
	cleanSet();
	
	copy(M + 0, M + nodes*nodes, MF);
	
	for(int i = 0; i < nodes; i++)
		MF[i*nodes+i] = 0;
	
	for(int k = 0; k < nodes; k++) 
	{
		for(int i = 0; i < nodes; i++)
		{
			for(int j = 0; j < nodes; j++)
			{
				if(MF[i*nodes+j] > MF[i*nodes+k]+MF[k*nodes+j])
					MF[i*nodes+j] = MF[i*nodes+k]+MF[k*nodes+j];
			}
		}
	}
	
	floydRec();
}

void myGraph::floydRec()
{
	cout<<"\nEdges Available:\n";
	
	for(int i = 0; i < nodes*nodes; i++)
	{
		if((i-i%nodes)/nodes != (i%nodes))
			cout<<(i-i%nodes)/nodes+1<<" & "<<(i%nodes)+1<<" @ "<<MF[i]<<"\n";
	}
}

/*
Cleans set for reuse
*/
void myGraph::cleanSet()
{
	for(int i = 0; i < nodes; i++)
	{
		Set[i] = 0;
		SetD1[i] = maxEMU;
		SetD2[i] = -1;
	}
}

/*
Checks for inbound output under maxEMU

@param input
@return if it is in bound
*/
int myGraph::getBounds(int in)
{
	if(in >= maxEMU || in < 1)
		return 0;
	return 1;
}

/*
Checks for inbound output under nodes

@param input
@return if it is in bound
*/
int myGraph::getBoundsNodes(int in)
{
	if(in > nodes || in < 1)
		return 0;
	return 1;
}

/*
Destructor
*/
void myGraph::dec()
{
	delete[] M;
	delete[] MF;
	delete[] Set;
	delete[] SetD1;
	delete[] SetD2;
}