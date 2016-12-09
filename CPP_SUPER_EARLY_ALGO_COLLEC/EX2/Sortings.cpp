//Zachary Job
//10.8.11
//V 1

//Sortings.cpp

#include "Sortings.h"

//Make the class object
Sortings::Sortings(){}

//Swaps elements in an array
//
//@param A is the array
//@param i is the first index
//@param j is the second index
void Sortings::swap(int *A,int i, int j)
{
	int tmp = A[i];
	A[i] = A[j];
	A[j] = tmp;
}


//Sorts via selection sort
//
//@param A is the array
//@param n is the array size
void Sortings::selectionSort(int *A, int n)
{
	for(int i=0;i<=n-2;i++)
	{
		int min = i;
		for(int j=i+1;j<=n-1;j++)
		{
			if(A[j] < A[min])
				min = j;
		}
		swap(A,i,min);
	}
}


//Sorts via insert sort
//
//@param A is the array
//@param n is the array size
void Sortings::insertSort(int *A, int n)
{
	for(int i=2; i<=n; i++)
		for(int j=i; j>1 & A[j-1]<A[j-2]; j--)
			swap(A,j-1,j-2);
}

//Sorts via quick sort
//
//@param A is the array
//@param n is the array size
void Sortings::quickSort(int *A, int n)
{
	quickCore(A, 0, n-1);
}

//Used as a recursive helper to quickSort
//Starts by recursing down to the smallest possible array portions possible moving
//elements left of a pivot
//
//@param A is the array
//@param l is the left index
//@param r is the right index
void Sortings::quickCore(int *A, int l, int r)
{
	if(l<r)
	{
		int p = quickPart(A,l,r);
		quickCore(A,l,p-1);
		quickCore(A,p+1,r);
	}
}

//Acts as the pivot and switch mechanism to quickCore
//Chooses the end element as the pivot and throws all less to its left
//
//@param A is the array
//@param l is the left index
//@param r is the right index
int Sortings::quickPart(int *A, int l, int r)
{
	int x = A[r];
	int i = l - 1;
		
	for(int j = l; j < r; j++)
	{
		if(A[j]<x)
		{
			i++;
			swap(A,i,j);
		}
	}
		
	swap(A,i+1,r);
	return(i+1);
}

//Sorts via merge sort
//
//@param is the array
//@param is the array size
void Sortings::mergeSort(int *A, int n)
{
	int *B = new int[n];
	mergeCore(A,B,0,n-1);
	
	delete []B;
}

//Acts as the recursive helper to mergeSort
//Splits the array down to its smallest portions recursively and
//sorts two sections from the smallest level up forcing them to be in order
//by selectively iterating each section placing the least valued item at the current
//index of the array being sorted
//
//@param A is the array
//@param B is a temporary array to hold values from A
//@param l is the left index
//@param r is the right index
void Sortings::mergeCore(int *A, int *B, int l, int r)
{
	if(l<r)
	{
		int m,i,j,k;
		m = (l+r)/2;
		
		mergeCore(A,B,l,m);
		mergeCore(A,B,m+1,r);
		
		for(i=l; i<=m; i++)
			B[i]=A[i];
		for(j=r; j>m; j--, i++)
			B[i]=A[j];
		for(i=l, j=r, k=l; k<=r; k++)
		{
			if(B[i]<=B[j])
				A[k]=B[i++];
			else
				A[k]=B[j--];
		}
	}
}