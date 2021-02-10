package com.parvin.diningPhilosopher;

public class Philosopher {
	private Chopstick left, right;
	
	public Philosopher(Chopstick left, Chopstick right) {
		this.left = left;
		this.right = right;
	}
	
	public boolean eat() {
		if(!left.pickUp()) {
			return false;
		}
		
		
	}
}
