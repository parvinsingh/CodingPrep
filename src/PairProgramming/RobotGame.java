package PairProgramming;

import java.util.Scanner;

public class RobotGame {

	String direction = null;
	Coordinates ordinates = null;
	
	public RobotGame(String direction, int latitude, int longitude) {
		this.direction = direction;
		this.ordinates = new Coordinates(latitude, longitude);
	}
	
	public static void main(String args[]) {
		String startDirection = "N";
		RobotGame rg = new RobotGame(startDirection, 0, 0);
		
		System.out.println("Robot is facing = " + rg.direction);
		System.out.println("Robot has the Latitude:Longitude = " + rg.ordinates.latitude + ":" + rg.ordinates.longitude);
		
		displayHelpContent();
		
		Scanner s = new Scanner(System.in);
		String cmd = s.next();
		
		while(!cmd.equalsIgnoreCase("Q"))
        {
			rg.playGame(cmd);
			System.out.println("After the command");
			System.out.println("Robot has the Latitude:Longitude = " + rg.ordinates.latitude + ":" + rg.ordinates.longitude);
			System.out.println("Robot is facing = " + rg.direction);
            
			System.out.println("Continue playing ! Enter L, R, M or ?");
			cmd = s.next();
        }
		
		if(cmd.equalsIgnoreCase("Q")) {
			System.exit(1);	
		}
	}
	
	public void playGame(String cmd) {
		switch(cmd){
			case("L"):
			case("R"):
				this.changeOrientation(cmd);
				break;
			case("M"):
				this.moveForward(cmd);
				break;
			default:
				displayHelpContent();
		}
	}
	
	private void reset() {
		System.out.println("Game ends!!");
	}

	private static void displayHelpContent() {
		System.out.println("Enter the following keys to move the robot");
		System.out.println("M - Move forward");
		System.out.println("L - Turn Left");
		System.out.println("R - Turn Right");
		System.out.println("Q - Quit");
		System.out.println("? - Help");
	}

	protected void moveForward(String cmd) {
		switch(direction) {
			case("N"):
				ordinates.changeLatitude(true);
				break;
			case("S"):
				ordinates.changeLatitude(false);
				break;
			case("E"):
				ordinates.changeLongitude(true);
				break;
			case("W"):
				ordinates.changeLongitude(false);
				break;
		}
	}

	protected void changeOrientation(String cmd) {
		switch(direction) {
			case("N"):
				direction = cmd.equals("L") ? "W" : "E";
				break;
			case("S"):
				direction = cmd.equals("L") ? "E" : "W";
				break;
			case("E"):
				direction = cmd.equals("L") ? "N" : "S";
				break;
			case("W"):
				direction = cmd.equals("L") ? "S" : "N";
				break;
		}
	}

	class Coordinates {
		int latitude;
		int longitude;
		
		Coordinates(int latitude, int longitude){
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
		private Coordinates changeLatitude(boolean increment) {
			if(increment) {
				return new Coordinates(++latitude, longitude);
			}else {
				return new Coordinates(--latitude, longitude);
			}
		}

		private Coordinates changeLongitude(boolean increment) {
			if(increment) {
				return new Coordinates(latitude, ++longitude);
			}else {
				return new Coordinates(latitude, --longitude);
			}
		}
	}
	
}
