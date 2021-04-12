package com.parvin.leetcodeQuestions;

public class Trie {
	
	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.insert("cat");
		trie.insert("mat");
		trie.insert("pat");
		trie.insert("bat");
		trie.insert("rat");
		
		boolean result = trie.search("rat");
		System.out.println(result);
	}
	
    private TrieNode root;
 
    public Trie() {
        root = new TrieNode();
    }
 
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c-'a';
            TrieNode par = p;
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index]=temp;//create a node and assign it inside array
                p = temp;//move cursor to the next node
            }else{
                p=p.arr[index];
            }
            p.parent = par;
        }
        p.isEnd=true;
    }
 
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if(p==null){
            return false;
        }else{
            if(p.isEnd)
                return true;
        }
 
        return false;
    }
 
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if(p==null){
            return false;
        }else{
            return true;
        }
    }
 
    protected TrieNode searchNode(String s){
        TrieNode p = root;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            int index = c-'a';
            if(p.arr[index]!=null){
                p = p.arr[index];
            }else{
                return null;
            }
        }
 
        if(p==root)
            return null;
 
        return p;
    }
}


class TrieNode {
    TrieNode[] arr;
    TrieNode parent;
    boolean isEnd;
    // Initialize your data structure here.
    public TrieNode() {
        this.arr = new TrieNode[26];
        parent = null;
    }
 
}
