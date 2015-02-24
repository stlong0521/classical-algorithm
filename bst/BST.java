//****************************************************************************************
// Author: Tianlong Song
// Name: BST.java
// Description: Regular binary search tree 
// Date created: 02/23/2015
//****************************************************************************************
import java.io.*;
import java.util.*;

class BSTNode<E extends Comparable<E>> {
	E key;
	BSTNode<E> left;
	BSTNode<E> right;

	BSTNode(E key) {
		this.key = key;
		left = null;
		right = null;
	}
}

class BST<E extends Comparable<E>> {

	BSTNode<E> root;	

	BST(BSTNode<E> root) {
		this.root = root;
	}
	
	// Find an item, return false if it does not exist
	public boolean exists(BSTNode<E> node) {
		BSTNode<E> curr = root;
	
		while(true) {
			if(node.key.compareTo(curr.key)==0)
				return true;
			else if(node.key.compareTo(curr.key)<0) {
				if(curr.left==null)
					return false;
				else
					curr = curr.left;
			} else {
				if(curr.right==null)
					return false;
				else
					curr = curr.right;
			}
		}
	}

	// Add a new item, return false if it already exists
	public boolean add(BSTNode<E> node) {
		BSTNode<E> curr = root;
	
		while(true) {
			if(node.key.compareTo(curr.key)==0)
				return false;
			else if(node.key.compareTo(curr.key)<0) {
				if(curr.left==null) {
					curr.left = node;
					return true;
				}
				else
					curr = curr.left;
			} else {
				if(curr.right==null) {
					curr.right= node;
					return true;
				}
				else
					curr = curr.right;
			}
		}
	}
	
	// Remove an existing item, return false if it does not exist
	public boolean remove(BSTNode<E> node) {
		// Determine its existence
		if(!exists(node))
			return false;

		// The node to be removed is root, special handling needed
		if(node==root) {
			// The node to be removed has no more than one children
			if(node.left==null) {
				root = node.right;
			} else if(node.right==null) {
				root = node.left;
			} else { // The node to be removed has two children
				BSTNode<E> successor = successor(node);
				remove(successor); // The successor must have at most one child
				root = successor;
				successor.left = node.left;
				successor.right = node.right;
			}
			return true;
		}

		// The node to be removed is not root, find the node first
		BSTNode<E> curr = root;
		Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
		while(true) {
			if(node.key.compareTo(curr.key)==0)
				break;
			else if(node.key.compareTo(curr.key)<0) {
				stack.push(curr);
				curr = curr.left;
			} else {
				stack.push(curr);
				curr = curr.right;
			}
		}
		curr = stack.pop(); // Parent of the node to be removed
		
		// The node to be removed has no more than one children
		if(node.left==null) {
			if(curr.left==node)
				curr.left = node.right;
			else
				curr.right = node.right;
		} else if(node.right==null) {
			if(curr.left==node)
				curr.left = node.left;
			else
				curr.right = node.left;
		} else { // The node to be removed has two children
			BSTNode<E> successor = successor(node);
			remove(successor); // The successor must have at most one child
			if(curr.left==node)
				curr.left = successor;
			else
				curr.right = successor;
			successor.left = node.left;
			successor.right = node.right;
		}
		return true;
	}

	// Find the successor 
	public BSTNode<E> successor(BSTNode<E> node) {
		BSTNode<E> curr;
		
		// Has a right subtree
		if(node.right!=null) {
			curr = node.right;
			while(true) {
				if(curr.left==null)
					return curr;
				else
					curr = curr.left;
			}
		}

		// Has no right subtree
		Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
		curr = root;
		while(true) {
			if(node.key.compareTo(curr.key)==0)
				break;
			else if(node.key.compareTo(curr.key)<0) {
				stack.push(curr);
				curr = curr.left;
			} else {
				stack.push(curr);
				curr = curr.right;
			}
		}
		while(stack.peek().key.compareTo(node.key)<0)
			stack.pop();
		return stack.peek();
	}
	
	// Find the predecessor 
	public BSTNode<E> predecessor(BSTNode<E> node) {
		BSTNode<E> curr;
		
		// Has a left subtree
		if(node.left!=null) {
			curr = node.left;
			while(true) {
				if(curr.right==null)
					return curr;
				else
					curr = curr.right;
			}
		}

		// Has no left subtree
		Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
		curr = root;
		while(true) {
			if(node.key.compareTo(curr.key)==0)
				break;
			else if(node.key.compareTo(curr.key)<0) {
				stack.push(curr);
				curr = curr.left;
			} else {
				stack.push(curr);
				curr = curr.right;
			}
		}
		while(stack.peek().key.compareTo(node.key)>0)
			stack.pop();
		return stack.peek();
	}

	// Inorder tree walk, starting from a designated node
	public void inorder(BSTNode<E> node) {
		if(node.left!=null)
			inorder(node.left);
		System.out.println(node.key);
		if(node.right!=null)
			inorder(node.right);
	}
}	
