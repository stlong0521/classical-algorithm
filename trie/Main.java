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
		// Testing trie
		Trie trie = new Trie();
		trie.addWord("abc");
		trie.addWord("ab");
		trie.addWord("b");
		trie.addWord("a");
		trie.printTrie(trie.root,"");
		trie.findWord("abc");
		trie.removeWord("abc");
		trie.printTrie(trie.root,"");
	}
}
