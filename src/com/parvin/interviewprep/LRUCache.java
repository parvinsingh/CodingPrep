package com.parvin.interviewprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {
	
	public static void main(String args[]) {
		 LRUCache obj = new LRUCache(2);
		 obj.put(1, 1);
		 obj.put(2, 2);
		 int param = obj.get(1);
		 obj.put(3,3);
		 param = obj.get(2);
		 obj.put(4,4);
		 param = obj.get(1);
	}
	
	LinkedHashMap<Integer, Integer> cache = 
			new LinkedHashMap<Integer, Integer>();
	int m_capacity = 0;
	
	public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity);
        this.m_capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
        	int val = cache.remove(key);
        	cache.put(key, val);
        	return val;
        }else {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
    	if(cache.size() >= m_capacity){
    		List<Integer> keys = new ArrayList<Integer>(cache.keySet()); 
    		cache.remove(keys.get(0));
    	}
		cache.put(key, value);
    }
}
