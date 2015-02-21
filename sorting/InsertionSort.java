//****************************************************************************************
// Author: Tianlong Song
// Name: InsertionSort.java
// Description: Insertion sort
// Date created: 12/14/2014
//****************************************************************************************

class InsertionSort{
	public void sort(double[] nums) {
		int i,j;
		double tmp;
		for(i=1;i<nums.length;i++) {
			// Insert the ith number to proper position 
			for(j=i;j>0;j--) {
				if(nums[j]<nums[j-1]) {
					tmp = nums[j-1];
					nums[j-1] = nums[j];
					nums[j] = tmp;
				} else {
					break;
				}
			}
		}
	}
}
