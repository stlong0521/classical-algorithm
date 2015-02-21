//****************************************************************************************
// Author: Tianlong Song
// Name: MergeSort.java
// Description: Merge sort
// Date created: 12/16/2014
//****************************************************************************************

class MergeSort {
	public void sort(double[] nums) {
		mergeSort(nums,0,nums.length-1);
	}

	public void mergeSort(double[] A,int p,int r) {
		int q;
		if(p<r) {
			q = (p+r)/2;
			mergeSort(A,p,q);
			mergeSort(A,q+1,r);
			merge(A,p,q,r);	
		}
	}

	public void merge(double[] A,int p,int q,int r) {
		double L[] = new double[q-p+2];
		double R[] = new double[r-q+1];
		System.arraycopy(A,p,L,0,q-p+1);
		System.arraycopy(A,q+1,R,0,r-q);
		L[q-p+1] = Double.POSITIVE_INFINITY; //Infinity
		R[r-q] = Double.POSITIVE_INFINITY;   //Infinity
		int i=0,j=0;
		for(int k=p;k<=r;k++) {
			if(L[i]<=R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
		}		
	}	
}
