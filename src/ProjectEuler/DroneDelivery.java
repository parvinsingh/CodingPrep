package ProjectEuler;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

//https://projecteuler.net/problem=724

public class DroneDelivery {
	private int n=0;
	private Random rand;
	private HashMap<Integer, Drone> drones;
	private Queue<Drone> stationaryDrones = new ArrayDeque<Drone>();
	
	public static void main(String args[]) {
		DroneDelivery dd = new DroneDelivery(1000000);
		dd.startDeliveries();
		int totalDistance = 0;
		for(Map.Entry<Integer, Drone> d: dd.drones.entrySet()) {
			//all of the moving drones have to be moved forward
			totalDistance = totalDistance + d.getValue().getDistance();
		}
		System.out.println("Average Distance = " + totalDistance/(1000000));
	}

	public DroneDelivery(int numOfDrones){
		this.n = numOfDrones;
		
		drones = new HashMap<Integer, Drone>(numOfDrones);
		
		for(int i=0; i<n; i++) {
			stationaryDrones.add(new Drone());
		}
		
		rand = new Random();
		
	}
	
	public void startDeliveries() {
		AtomicInteger i = new AtomicInteger();
		while(!stationaryDrones.isEmpty()) {
			int droneNum = rand.nextInt(n);
			for(Map.Entry<Integer, Drone> e: drones.entrySet()) {
				//all of the moving drones have to be moved forward
				Drone d = e.getValue();
				d.move();
			}
			if(drones.containsKey(droneNum)) {
				//drone is already moving
				Drone d = drones.get(droneNum);
				d.startOrIncreaseSpeed();
			}else {
				//drone is not in map, so stationary
				Drone d = stationaryDrones.poll();
				d.startOrIncreaseSpeed();
				drones.put(droneNum, d);
			}
			i.incrementAndGet();
		}
		
		//once queue is empty, move once and stop
		for(Map.Entry<Integer, Drone> e: drones.entrySet()) {
			//all of the moving drones have to be moved forward
			Drone d = e.getValue();
			d.move();
		}
		System.out.println(i);
		System.out.println();
	}
	
	class Drone{
		int distance;
		boolean isMoving;
		int speed;
		
		protected Drone(){
			isMoving = false;
		}
		
		private int getDistance() {
			return distance;
		}
		
		private void move() {
			distance = distance + speed;
		}
		
		private void startOrIncreaseSpeed() {
			if(isMoving) {
				speed = speed+1;
			}else {
				isMoving = true;
				speed = 1;
			}
		}
	}
}
