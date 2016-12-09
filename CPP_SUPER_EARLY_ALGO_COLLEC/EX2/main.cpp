//Zachary Job
//10.8.11
//V 1

//main.cpp

#include <stdlib.h> 
#include <string>
#include <sstream>
#include <ctime>
#include <stdio.h>
#include "Sortings.h"
#include "main.h"

using namespace std;

//Prints the given array
//
//@param A is the array
//@param n is the array size
void printArray(int *A,int n)
{
	for(int i=0;i<n;i++)
		cout<<A[i]<<endl;
}

//Runs the user interface which calls the sorts and performs a
//time check and shows the user the array before and after sorting
int main()
{
	int n; //array size
	int temp; //temporary input integer
	double duration; //clock time passed
	string in; //input string
	bool isDone = false; //loop condition
	clock_t start; //clock starting time
	Sortings mySort; //Creates sort object for use of sorting algorithms
	
	//User array size interface
	while(!isDone)
	{
		cout<<"\nEnter a number\n>>";
		
		getline(cin, in);
		stringstream numIn(in);
		
		if(numIn >> temp)
		{
			n = temp;
			isDone = !isDone;
		}
		else
			cout<<"<!>Invalid<!>\n";
	}
	
	//Create the array and assign random values
	int *A = new int[n];
	for(int i=0;i<n;i++)
		A[i] = rand();

	cout<<"\n[[[Generated Array]]]\n";
	printArray(A,n);
	cout<<"\n=================\n";
	
	//User sort selection
	while(isDone)
	{
		cout<<"\nChoose Your Sort\n"<<"1) Selection Sort\n2) Insert Sort\n3) Quick Sort\n4) Merge Sort\n>>";
		
		getline(cin, in);
		stringstream numIn(in);
		
		if(numIn >> temp)
		{	
			isDone = !isDone;
			
			start = clock();
			
			if(temp == 1)
				mySort.selectionSort(A,n);
			else if(temp == 2)
				mySort.insertSort(A,n);
			else if(temp == 3)
				mySort.quickSort(A,n);
			else if(temp == 4)
				mySort.mergeSort(A,n);
			else
			{
				isDone = !isDone;
				cout<<"<!>Invalid<!>\n";
			}
			
			duration = (clock()-start)/(double) CLOCKS_PER_SEC;
		}
		else
			cout<<"<!>Invalid<!>\n";
	}	
	
	cout<<"\n[[[Sorted Array]]]\n";
	printArray(A,n);
	cout<<"\nTime to sort: "<<duration<<"\n";
	
	delete []A;
}

