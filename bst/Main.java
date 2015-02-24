//****************************************************************************************
// Author: Tianlong Song
// Name: Main.java
// Description: Main class for testing 
// Date created: 02/23/2015
//****************************************************************************************
import java.io.*;
import java.util.*;

class Main {

	public static void main(String args[]) {

		// Testing binary search tree 
		BSTNode<Integer> node1 = new BSTNode<Integer>(1);
		BSTNode<Integer> node2 = new BSTNode<Integer>(2);
		BSTNode<Integer> node3 = new BSTNode<Integer>(3);
		BSTNode<Integer> node4 = new BSTNode<Integer>(4);
		BSTNode<Integer> node5 = new BSTNode<Integer>(5);
		BSTNode<Integer> node6 = new BSTNode<Integer>(6);
		BSTNode<Integer> node7 = new BSTNode<Integer>(7);
		BSTNode<Integer> node8 = new BSTNode<Integer>(8);
		BST<Integer> bst1 = new BST<Integer>(node4);
		// Testing insertion
		bst1.add(node2);
		bst1.add(node6);
		bst1.add(node1);
		bst1.add(node3);
		bst1.add(node5);
		bst1.add(node7);
		bst1.inorder(bst1.root);
		// Testing existence
		if(bst1.exists(node7))
			System.out.println("Node 7 exists.");
		else
			System.out.println("Node 7 does not exist.");
		if(bst1.exists(node8))
			System.out.println("Node 8 exists.");
		else
			System.out.println("Node 8 does not exist.");
		// Testing successor and predecessor
		System.out.println("Node 2's successor is " + bst1.successor(node2).key);
		System.out.println("Node 3's successor is " + bst1.successor(node3).key);
		System.out.println("Node 4's predecessor is " + bst1.predecessor(node4).key);
		System.out.println("Node 5's predecessor is " + bst1.predecessor(node5).key);
		// Testing deletion
		bst1.remove(node1);
		bst1.inorder(bst1.root);
		bst1.remove(node2);
		bst1.inorder(bst1.root);
		bst1.remove(node4);
		bst1.inorder(bst1.root);
	}
}
