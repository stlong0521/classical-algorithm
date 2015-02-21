//****************************************************************************************
// Author: Tianlong Song
// Name: Trie.java
// Description: Trie implementation 
// Date created: 02/12/2015
//****************************************************************************************
import java.io.*;
import java.util.*;

class TrieNode {
	char letter;
	List<TrieNode> links;
	boolean isFullWord; // Indicating whether it is a fullword from root to this node

	TrieNode(char letter) {
		this.letter = letter;
		links = new ArrayList<TrieNode>();
		isFullWord = false;
	}
}

class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode('\0');	
	}

	// Obtain the trie node that contains a given letter in the children list of a given node
	public TrieNode contains(TrieNode node,char letter) {
		for(TrieNode x: node.links) {
			if(x.letter==letter)
				return x;
		}
		return null;
	}

	// Add a new word
	public void addWord(String word) {
		TrieNode curr = root;
		for(int i=0;i<word.length();i++) {
			TrieNode node = contains(curr,word.charAt(i));
			if(node==null) {
				node = new TrieNode(word.charAt(i));
				curr.links.add(node);
				curr = node;
			} else {
				curr = node;
			}
		}
		curr.isFullWord = true;
	}

	// Find a word
	public boolean findWord(String word) { 
		TrieNode curr = root;
		for(int i=0;i<word.length();i++) {
			TrieNode node = contains(curr,word.charAt(i));
			if(node==null) {
				return false;
			} else {
				curr = node;
			}
		}
		if(!curr.isFullWord)	
			return false;
		return true;
	}

	// Remove a word, return false if the word does not exist	
	public boolean removeWord(String word) {
		Stack<TrieNode> stack = new Stack<TrieNode>();
		TrieNode curr = root;
		stack.push(root);
		for(int i=0;i<word.length();i++) {
			TrieNode node = contains(curr,word.charAt(i));
			if(node==null) {
				return false;
			} else {
				curr = node;
				stack.push(curr);
			}
		}
		if(!curr.isFullWord)	
			return false;
		curr.isFullWord = false;
		do {
			curr = stack.pop();
			// Remove the current node if it has no children and it is not a fullword from root to this node
			if(curr.links.size()==0&&!curr.isFullWord) 
				stack.peek().links.remove(curr); // stack.peek() contains the parent of the current node
			else
				break;
		} while(stack.peek()!=root);
		return true;
	}

	// Print all words in the trie, call printTrie(root,"")
	public void printTrie(TrieNode node,String s) {
		for(TrieNode x: node.links) {
			String str = s + x.letter;
			printTrie(x,str);
		}
		if(node.isFullWord)
			System.out.println(s);
	}
}
