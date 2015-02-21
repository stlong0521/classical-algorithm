//****************************************************************************************
// Author: Tianlong Song
// Name: HashTable.java
// Description: Implementaiton of hash tables using arrays 
// Date created: 02/11/2015
//****************************************************************************************
import java.io.*;
import java.util.*;

class ObjData {
	int key;
	int value;

	ObjData(int key,int value) {
		this.key = key;
		this.value = value;
	}
}

class HashTable {

	private final int size;
	private List<ArrayList<ObjData>> list;	

	HashTable(int size) {
		this.size = size;
		list = new ArrayList<ArrayList<ObjData>>(size);
		for(int i=0;i<size;i++) {
			list.add(new ArrayList<ObjData>());
		}	
	}
	
	// Hash function: modular
	public int hash(int key) {
		return key%size;
	}

	// Obtain an item based on its key
	public ObjData get(int key) {
		for(ObjData x: list.get(hash(key))) {
			if(x.key==key)
				return x;
		}
		return null; // The key does not exist!
	}
	
	// Hash a new item into the table, do nothing if key conflicts 
	public void put(ObjData entry) {
		if(get(entry.key)==null)
			list.get(hash(entry.key)).add(entry);
	}

	// Remove an item based on its key, if exists
	public void remove(int key) {
		ObjData entry = get(key);
		if(entry!=null)
			list.get(hash(key)).remove(entry);
	}
}
