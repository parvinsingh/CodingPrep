package com.parvin.interviewprep;

public class Pair<K, V> {

	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2){
		if(p1.getKey().equals(p2.getKey()) 
				&& p1.getValue().equals(p2.getValue())){
			return true;
		}
		return false;
	}
}
