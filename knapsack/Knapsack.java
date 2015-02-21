//****************************************************************************************
// Author: Tianlong Song
// Name: Knapsack.java
// Description: 0-1 knapsack problem 
// Date created: 02/20/2015
//****************************************************************************************
import java.io.*;
import java.util.*;

class Knapsack {

	// Solve the 0-1 knapsack problem
	public void solve(int[] vecValue,int[] vecWeight,int weightLimit) {
		// Condition check
		if(vecValue.length!=vecWeight.length) {
			System.out.println("Illegal parameters! Value vector and weight vector lengths do not agree!");
			return;
		}

		// Initilize a value matrix and a back pointer matrix
		int numItem = vecValue.length;
		int[][] valMatrix = new int[numItem+1][weightLimit+1];
		boolean[][] backPTR = new boolean[numItem+1][weightLimit+1];

		// Iteration
		for(int i=1;i<=numItem;i++) {
			for(int w=1;w<=weightLimit;w++) {
				if(vecWeight[i-1]>w) {
					valMatrix[i][w] = valMatrix[i-1][w];
				} else {
					int val1 = valMatrix[i-1][w-vecWeight[i-1]]+vecValue[i-1];
					int val2 = valMatrix[i-1][w];
					if(val1>val2) {
						valMatrix[i][w] = val1;
						backPTR[i][w] = true;
					} else
						valMatrix[i][w] = val2;
				}
			}
		}

		// Output the result
		System.out.println("The maximum value: " + valMatrix[numItem][weightLimit]);
		System.out.println("Selected items:");
		int w = weightLimit;
		for(int i=numItem;i>0;i--) {
			if(backPTR[i][w]) {
				System.out.println("Item " + i + ": " + "value(" + vecValue[i-1] + ") weight(" + vecWeight[i-1] + ")");
				w -= vecWeight[i-1];
			}
		}	
	}
}
