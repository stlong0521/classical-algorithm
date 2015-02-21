//****************************************************************************************
// Author: Tianlong Song
// Name: HeapSort.java
// Description: Heap sort
// Date created: 12/17/2014
//****************************************************************************************

class HeapSort {
	public void sort(double[] nums) {
		double tmp;
		int heapSize = nums.length;

		// Build the max-heap
		buildMaxHeap(nums);

		//Extract-max sequentially
		for(int i=nums.length-1;i>0;i--) {
			// Exchage nums[i] and nums[0]
			tmp = nums[0];
			nums[0] = nums[i];
			nums[i] = tmp;
			// Fix any possible violation
			heapSize--;
			maxHeapify(nums,0,heapSize);
		}
	}
	
	// A[A.length/2]~A[A.length-1] are all leaves, which are one-element heaps to begin with
	// Note that A[A.length/2-1] is the parent of the very last node A[A.length-1]
	public void buildMaxHeap(double[] A) {
		for(int i=A.length/2-1;i>=0;i--) {
			maxHeapify(A,i,A.length);
		}
	}

	// When called, maxHeapify assumes that the two subtrees of i are already max-heaps
	public void maxHeapify(double[] A,int i,int heapSize) {
		int l,r,largest;
		l = 2*i + 1; //Left child
		r = 2*i + 2; //Right child
		double tmp;

		// Find the maximum among i and its two children
		if(l<heapSize&&A[l]>A[i]) {
			largest = l;
		} else {
			largest = i;
		}
		if(r<heapSize&&A[r]>A[largest]) {
			largest = r;
		}

		// Exchange A[i] and A[largest], and fix possible viloation
		if(i!=largest) {
			tmp = A[i];
			A[i] = A[largest];
			A[largest] = tmp;
			maxHeapify(A,largest,heapSize);	
		}
	}
}
