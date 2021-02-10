package com.parvin.arrayquestions;

import java.util.Stack;

//This code needs to be tested for dest and buffer towers

public class TowerOfHanoi {

	private int index;
	private static Stack<Integer> disks;
	
	public static void main(String args[]) {
		int n=5;
		TowerOfHanoi th = new TowerOfHanoi();
		Tower[] towers = new Tower[3];
		for(int i=0; i<3; i++) {
			towers[i] = th. new Tower(0);
		}
		
		for(int i=n-1; i>=0; i--) {
			towers[0].add(i);
		}
		
		towers[0].moveDisks(n, th. new Tower(1), th. new Tower(2));
	}
	
	class Tower{
		public Tower(int i) {
			disks = new Stack<Integer>(); // create a new stack
			index = i; //associate a numeric index to the stack
		}
		
		private void add(int disk) {
			if(!disks.isEmpty() && disks.peek() <= disk) {
				System.out.println("Error placing disk");
			}else {
				disks.push(disk);
			}
		}
		
		private void moveTopDiskTo(Tower t) {
			int top = disks.pop();
			t.add(top);
		}
		
		private void moveDisks(int size, Tower towers, Tower towers2) {
			if(size > 0) {
				moveDisks(size-1, towers2, towers);
				moveTopDiskTo(towers);
				towers2.moveDisks(size-1, towers, this);
			}
		}
	}
}
