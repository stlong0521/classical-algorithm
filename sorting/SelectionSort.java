//****************************************************************************************
// Author: Tianlong Song
// Name: SelectionSort.java
// Description: Selection sort
// Date created: 12/14/2014
//****************************************************************************************

class SelectionSort{
	public void sort(double[] nums) {
		int i,j,minIndex;
		double min,tmp;
		for(i=0;i<nums.length-1;i++) {
			// Find the minimum among from i to length-1
			minIndex = i;
			min = nums[i];
			for(j=i+1;j<nums.length;j++) {
				if(nums[j]<min) {
					minIndex = j;
					min = nums[j];
				}	
			}
			// Swap nums[i] with the minimum found above
			if(minIndex!=i) {
				tmp = nums[i];
				nums[i] = nums[minIndex];
				nums[minIndex] = tmp;
			}
		}
	}
}
