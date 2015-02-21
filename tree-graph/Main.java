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

		// Testing binary tree
		/*BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> leftLeft = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> leftRight = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> rightLeft = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> rightRight  = new BinaryTreeNode<Integer>(7);

		BinaryTree<Integer> binTree = new BinaryTree<Integer>(root);
		binTree.addLeft(root,left);
		binTree.addRight(root,right);
		binTree.addLeft(root.left,leftLeft);
		binTree.addRight(root.left,leftRight);
		binTree.addLeft(root.right,rightLeft);
		binTree.addRight(root.right,rightRight);

		binTree.inorder(root);*/

		// Testing N-ary tree
		/*NaryTreeNode<Integer> root = new NaryTreeNode<Integer>(1);
		root.addChild(new NaryTreeNode<Integer>(2));
		root.addChild(new NaryTreeNode<Integer>(3));
		root.addChild(new NaryTreeNode<Integer>(4));
		root.children.get(0).addChild(new NaryTreeNode<Integer>(5));
		root.children.get(0).addChild(new NaryTreeNode<Integer>(6));
		root.children.get(0).addChild(new NaryTreeNode<Integer>(7));
		root.children.get(1).addChild(new NaryTreeNode<Integer>(8));
		root.children.get(1).addChild(new NaryTreeNode<Integer>(9));
		root.children.get(1).addChild(new NaryTreeNode<Integer>(10));
		root.children.get(2).addChild(new NaryTreeNode<Integer>(11));
		root.children.get(2).addChild(new NaryTreeNode<Integer>(12));
		root.children.get(2).addChild(new NaryTreeNode<Integer>(13));
		NaryTree<Integer> naryTree = new NaryTree<Integer>(root);
		System.out.println("DFS|Precorder:");
		naryTree.DFS(root);
		System.out.println("Postorder:");
		naryTree.postorder(root);
		System.out.println("BFS:");
		naryTree.BFS(root);*/

		// Testing graph
		Graph graph = new Graph(6);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(1,4);
		graph.addEdge(2,3);
		graph.addEdge(2,4);
		graph.addEdge(3,4);
		graph.addEdge(4,5);
		System.out.println("DFS:");
		graph.DFS(0);
		System.out.println("BFS:");
		graph.BFS(0);
		Graph graphReversed = graph.reverse();
		System.out.println("DFS:");
		graphReversed.DFS(5);
		System.out.println("BFS:");
		graphReversed.BFS(5);
	}
}
