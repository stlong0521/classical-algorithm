//************************************************************************************************
// Author: Tianlong Song
// Name: Main.java
// Description: Interface with console
// Date created: 12/13/2014
//************************************************************************************************

import java.io.*;
import java.util.ArrayList;

class Main {
	public static void main(String args[]) {
		// Array to store double numbers
		double nums[] = null;
		// Console input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Console output
		PrintWriter pw = new PrintWriter(System.out,true);
		// Temporary variables
		String choice = null;
		String str = null;
		String[] numsInString = null;
		ArrayList<Double> numsArrayList = new ArrayList<Double>();
			
		if(args.length==0) {	// Main function called without parameters
			// Specify source of numbers to be sorted
			pw.println("**********Specify source of numbers to be sorted**********");
			pw.println("Read from console:  enter 'c' or 'C';");
			pw.println("Read from file:     enter 'f' or 'F';");
			pw.println("Quit:               enter anything else.");
			pw.println("**********************************************************");
			pw.print("Your choice: ");
			pw.flush();
			
			// User choice input
			try {
				choice = br.readLine();
			} catch(IOException ex) {
				pw.println("IO error! Program terminated.");
				System.exit(1);
			}	
			
			// Prepare numbers to be sorted
			switch(choice) {
				case "c":
				case "C":
					pw.print("Enter numbers (use space as delimiter): ");
					pw.flush();
					try {
						str = br.readLine();
					} catch(IOException ex) {
						pw.println("IO error! Program terminated.");
						System.exit(1);
					}
					numsInString = str.trim().split(" ");
					nums = new double[numsInString.length];
					for(int i=0;i<numsInString.length;i++) {
						try {
							nums[i] = Double.parseDouble(numsInString[i]);
						} catch(NumberFormatException ex) {
							pw.println("Illegal number format! Program terminated");
							System.exit(1);
						}
					}
					break;
				case "f":
				case "F":
					pw.print("Enter the file name: ");
					pw.flush();
					try {
						str = br.readLine();
					} catch(IOException ex) {
						pw.println("IO error! Program terminated.");
						System.exit(1);
					}
					try {
						FileReader fr = new FileReader(str);
						BufferedReader brFile = new BufferedReader(fr);
						while((str=brFile.readLine())!=null) {
							try {
								numsArrayList.add(Double.parseDouble(str));	
							} catch(NumberFormatException ex) {
								pw.println("Illegal number format! Program terminated");
								System.exit(1);
							}
						}
						fr.close();
						nums = new double[numsArrayList.size()];
						for(int i=0;i<numsArrayList.size();i++) {
							try {
								nums[i] = numsArrayList.get(i);
							} catch(NumberFormatException ex) {
								pw.println("Illegal number format! Program terminated");
								System.exit(1);
							}
						}
					} catch(FileNotFoundException ex) {
						pw.println("File does not exist! Program terminated");
						System.exit(1);
					} catch(IOException ex) {
						pw.println("IO error! Program terminated.");
						System.exit(1);
					}
					break;
				default:
					pw.println("You quitted the program.");
					System.exit(1);
			}
			
		} else {	// Main function called with parameters
			nums = new double[args.length];
			for(int i=0;i<args.length;i++) {
				try {
					nums[i] = Double.parseDouble(args[i]);
				} catch(NumberFormatException ex) {
					pw.println("Illegal number format! Program terminated");
					System.exit(1);
				}
			}
		}

		// Sorting algorithm selection
		pw.println("*****************Specify sorting algorithm****************");
		pw.println("Insertion Sort:     enter 'i' or 'I';");
		pw.println("Selection Sort:     enter 's' or 'S';");
		pw.println("Bubble Sort:        enter 'b' or 'B';");
		pw.println("Merge Sort:         enter 'm' or 'M';");
		pw.println("Quick Sort:         enter 'q' or 'Q';");
		pw.println("Heap Sort:          enter 'h' or 'H';");
		pw.println("Quit:               enter anything else.");
		pw.println("**********************************************************");
		pw.print("Your choice: ");
		pw.flush();

		// User choice input
		try {
			choice = br.readLine();
		} catch(IOException ex) {
			pw.println("IO error! Program terminated.");
			System.exit(1);
		}

		//Sorting
		switch(choice) {
			case "i":
			case "I":
				(new InsertionSort()).sort(nums);
				break;
			case "s":
			case "S":
				(new SelectionSort()).sort(nums);
				break;
			case "b":
			case "B":
				(new BubbleSort()).sort(nums);
				break;
			case "m":
			case "M":
				(new MergeSort()).sort(nums);
				break;
			case "q":
			case "Q":
				(new QuickSort()).sort(nums);
				break;
			case "h":
			case "H":
				(new HeapSort()).sort(nums);
				break;
			default:
				pw.println("You quitted the program.");
				System.exit(1);
		}

		// Sorted result output
		pw.print("The numbers in sorted order are:");
		for(double d:nums) {
			pw.print(" " + d);
		}
		pw.println();
	}
}
