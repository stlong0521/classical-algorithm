//****************************************************************************************
// Author: Tianlong Song
// Name: Main.java
// Description: Main class for testing 
// Date created: 02/20/2015
//****************************************************************************************
import java.io.*;
import java.util.*;

class Main {

	public static void main(String args[]) {
		// Testing knapsack 
		Knapsack knapsack = new Knapsack();
		int vecValue[] = {10,50,20,80,30,90,100,40,60,70};
		int vecWeight[] = {1,2,3,4,5,6,7,8,9,10};
		int weightLimit = 40;
		knapsack.solve(vecValue,vecWeight,weightLimit);
	}
}
