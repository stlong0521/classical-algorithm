//****************************************************************************************
// Author: Tianlong Song
// Name: BinaryTree.java
// Description: Binary tree 
// Date created: 02/09/2015
//****************************************************************************************
import java.io.*;

class BinaryTreeNode<E extends Comparable<E>> {
	E key;
	BinaryTreeNode<E> left;
	BinaryTreeNode<E> right;

	BinaryTreeNode(E key) {
		this.key = key;
		left = null;
		right = null;
	}
}

class BinaryTree<E extends Comparable<E>> {

	BinaryTreeNode<E> root;	

	BinaryTree(BinaryTreeNode<E> root) {
		this.root = root;
	}

	// Add a child as the left child of a parent
	public void addLeft(BinaryTreeNode<E> parent, BinaryTreeNode<E> child) {
		parent.left = child;
	}

	// Add a child as the right child of a parent
	public void addRight(BinaryTreeNode<E> parent, BinaryTreeNode<E> child) {
		parent.right = child;
	}

	// Inorder tree walk, starting from a designated node
	public void inorder(BinaryTreeNode<E> node) {
		if(node.left!=null)
			inorder(node.left);
		System.out.println(node.key);
		if(node.right!=null)
			inorder(node.right);	
	}
	
	// Preorder tree walk, starting from a designated node
	public void preorder(BinaryTreeNode<E> node) {
		System.out.println(node.key);
		if(node.left!=null)
			preorder(node.left);
		if(node.right!=null)
			preorder(node.right);	
	}
	
	// Postorder tree walk, starting from a designated node
	public void postorder(BinaryTreeNode<E> node) {
		if(node.left!=null)
			postorder(node.left);
		if(node.right!=null)
			postorder(node.right);	
		System.out.println(node.key);
	}
}
