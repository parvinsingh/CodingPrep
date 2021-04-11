package com.parvin.arrayquestions;

/**
 * Implement methods in a Circular buffer using an int[]
 * CircularBuffer should be initialized with a capacity.
 * @author papanesa
 *
 */

public class CircularBuffer<T> {

	T[] arr = null;
	int capacity=0;
	int length = 0;
	int index = 0;
	
	public CircularBuffer(int capacity){
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}
	
	void add(T val) {
		if(length < capacity) {
			length++;
		}else {
			if(index == length) {
				index = 0;
			}
		}
		arr[index] = val;
		index++;
	}
	
	String getString() {
		StringBuffer buff = new StringBuffer();
		for(Object a: arr) {
			buff.append((T)a).append(',');
		}
		buff.setLength(buff.length()-1);
		return buff.toString();
	}
	
	int getLength() {
		return length;
	}
	
	public static void main(String args[]) {
		CircularBuffer<Integer> buffer = new CircularBuffer<Integer>(10);
		for(int i=0; i<=15; i++) {
			buffer.add(i);
		}
		System.out.println(buffer.getLength());
		System.out.println(buffer.getString());
		System.out.println("============");
		
		CircularBuffer<Double> doubleBuffer = new CircularBuffer<Double>(10);
		Double d = 0.5;
		for(int i=0; i<=15; i++) {
			doubleBuffer.add(d+i);
		}
		System.out.println(doubleBuffer.getLength());
		System.out.println(doubleBuffer.getString());
	}
}
