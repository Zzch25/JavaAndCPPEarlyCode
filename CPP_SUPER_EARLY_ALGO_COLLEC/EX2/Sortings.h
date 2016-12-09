//Zachary Job
//10.8.11
//V 1

//Sortings.h

#include <iostream>

//Set up Sortings as an object
class Sortings
{
	public:
		Sortings(); //Prepare for class object
		static void selectionSort(int*,int);
		static void insertSort(int*,int);
		static void quickSort(int*,int);
		static void mergeSort(int*,int);
	private:
		static void swap(int*,int,int);
		static void mergeCore(int*,int*,int,int);
		static void quickCore(int*,int,int);
		static int quickPart(int*,int,int);
};