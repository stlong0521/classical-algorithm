//****************************************************************************************
// Author: Tianlong Song
// Name: BubbbleSort.java
// Description: Bubble sort
// Date created: 12/14/2014
//****************************************************************************************

class BubbleSort {
	public void sort(double[] nums) {
		int i,j;
		double tmp;
		for(i=0;i<nums.length-1;i++) {
			for(j=nums.length-1;j>i;j--) {
				if(nums[j]<nums[j-1]) {
					tmp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = tmp;
				}	
			}
		}
	}
}
