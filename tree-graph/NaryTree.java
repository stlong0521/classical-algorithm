//****************************************************************************************
// Author: Tianlong Song
// Name: NaryTree.java
// Description: N-ary tree 
// Date created: 02/09/2015
//****************************************************************************************
import java.io.*;
import java.util.*;

class NaryTreeNode<E extends Comparable<E>> {
	E key;
	ArrayList<NaryTreeNode<E>> children;

	NaryTreeNode(E key) {
		this.key = key;
		children = new ArrayList<NaryTreeNode<E>>();
	}

	public void addChild(NaryTreeNode<E> child) {
		children.add(child);
	}
}

class NaryTree<E extends Comparable<E>> {

	NaryTreeNode<E> root;	

	NaryTree(NaryTreeNode<E> root) {
		this.root = root;
	}

	// Postorder tree walk, starting from a designated node
	public void postorder(NaryTreeNode<E> node) {
		for(NaryTreeNode<E> child: node.children) {
			postorder(child);
		}
		System.out.println(node.key);
	}
	
	// Preorder tree walk and DFS traversal are equivalent
	public void DFS(NaryTreeNode<E> node) {
		System.out.println(node.key);
		for(NaryTreeNode<E> child: node.children) {
			DFS(child);
		}
	}

	// BFS traversal
	public void BFS(NaryTreeNode<E> root) {
		Queue<NaryTreeNode<E>> queue = new LinkedList<NaryTreeNode<E>>();
		queue.add(root);

		while(queue.peek()!=null) { // Iterate until empty queue
			for(NaryTreeNode<E> child: queue.peek().children) {
				queue.add(child);
			}
			System.out.println(queue.poll().key);
		}
	}
}
