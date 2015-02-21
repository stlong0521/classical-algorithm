//****************************************************************************************
// Author: Tianlong Song
// Name: QuickSort.java
// Description: Quick sort
// Date created: 12/17/2014
//****************************************************************************************

import java.util.Random;

class QuickSort {
	public void sort(double[] nums) {
		quickSort(nums,0,nums.length-1);
	}

	public void quickSort(double[] A,int p,int r) {
		int q;
		if(p<r) {
			// Randomized partition, use partition() instead for regular quicksort
			q = randomizedPartition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
	}

	public int randomizedPartition(double[] A,int p,int r) {
		int i;
		double tmp;
		// Generate a random integer between p and r
		i = (new Random()).nextInt(r-p+1) + p;
		// Random pivot by exchanging A[i] and A[r]
		tmp = A[i];
		A[i] = A[r];
		A[r] = tmp;
		return partition(A,p,r);
	}

	public int partition(double[] A,int p,int r) {
		int i=p,j;
		double tmp;
		for(j=p;j<r;j++) {
			if(A[j]<=A[r]) {
				// Exchange A[i] and A[j]
				tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
				i++;	
			}
		}
		// Place the pivot into right position by exchanging A[r] and A[i]
		tmp = A[r];
		A[r] = A[i];
		A[i] = tmp;		
		return i;
	}	
}
