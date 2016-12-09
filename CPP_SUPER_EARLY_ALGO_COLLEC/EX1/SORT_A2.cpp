//Zachary Job
//9.15.11
//V 1.0

#include <iostream>
#include <ctime>
#include "stdlib.h"
#include "arrDefined.h"
using namespace std;

int size = 10; //array size

//Prints the current array
//
//@param: inArr is the referenced array element
void printArray(int* inArr)
{	
	cout << "Printing..." << "\n";
	for(int i = 0; i < size; i++)
		cout << inArr[i] << "\n";
}

//Swaps objects at i and j position
//
//@param: inArr is the referenced array element
//@param: i is the first index
//@param: j is the second index
void swap(int* inArr, int i, int j)
{
	int temp;
	
	temp = inArr[i];
	inArr[i] = inArr[j];
	inArr[j] = temp;
}

//Sorts via selection sort
//
//@param: inArr is the referenced array element
void SelectionSort(int* inArr)
{
	for(int i = 0; i < size-1; i++)
		for(int j = i+1; j < size; j++)
			if(inArr[i] > inArr[j])
				swap(inArr,i,j);
				
	printArray(inArr);
}

//Sorts via bubble sort
//
//@param: inArr is the referenced array element
void BubbleSort(int* inArr)
{
	int count;
	bool isDone = false;
	
	while(isDone == false)
	{
		count = 0;
		for(int i = 0; i < size-1; i++)
		{
			if(inArr[i] > inArr[i+1])
				swap(inArr,i,i+1);
			else
				count++;
		}
		if(count == size-1)
			isDone = true;
	}
	printArray(inArr);
}

int main()
{
	double duration; //timer duration
	clock_t start; //timer object
	
	int *x = new int[size]; //array
	for(int i=0; i<size; i++)
		x[i]=rand();
	
	//===============SELECTION SORT
	
	//cout<<"Selection Sort Disabled Via //: ";
	start = clock();
	SelectionSort(x);
	duration = (clock()-start)/(double) CLOCKS_PER_SEC;
	
	//Sort Information
	cout<<"Time: "<< duration << "\n";
	
	//==================BUBBLE SORT
	
	cout<<"Bubble Sort Disabled Via //: ";
	start = clock();
	//BubbleSort(x);
	duration = (clock()-start)/(double) CLOCKS_PER_SEC;
	
	//Sort Information
	cout<<"Time: "<< duration << "\n";

	delete x;
	return 0;
}