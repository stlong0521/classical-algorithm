//****************************************************************************************
// Author: Tianlong Song
// Name: Main.java
// Description: Main class for testing 
// Date created: 02/09/2015
//****************************************************************************************
import java.io.*;
import java.util.*;

class Main {

	public static void main(String args[]) {
		// Testing hash table 
		HashTable hashTable = new HashTable(100);
		hashTable.put(new ObjData(2,2222));
		hashTable.put(new ObjData(3,3333));
		hashTable.put(new ObjData(5,5555));
		hashTable.put(new ObjData(105,5105));
		ObjData objData;
		objData = hashTable.get(4);
		objData = hashTable.get(3);
		System.out.println(objData.value);
		hashTable.remove(6);
		hashTable.remove(2);
		objData = hashTable.get(2);
	}
}
