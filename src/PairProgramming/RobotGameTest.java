package PairProgramming;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RobotGameTest {

	private static RobotGame rg = null;
			
	@BeforeAll
	static void setUp() throws Exception {
		String startDirection = "N";
		rg = new RobotGame(startDirection, 0, 0);
	}

	@Test
	void testForInitialLocationAndOrientation() {
		RobotGame testRobot = new RobotGame("N", 0, 0);
		assertEquals("N", testRobot.direction);
		assertEquals(0, testRobot.ordinates.latitude);
		assertEquals(0, testRobot.ordinates.longitude);
	}
	
	@Test
	void testForMoveCommand() {
		int oldLat = rg.ordinates.latitude;
		int oldLon = rg.ordinates.longitude;
		rg.moveForward("M");
		int newLat = rg.ordinates.latitude;
		int newLon = rg.ordinates.longitude;
		assertTrue(1 == Math.abs(newLat-oldLat) || 1 == Math.abs(newLon-oldLon));;
	}

	@Test
	void testForTurnLeftCommand() {
		String expected = "N";
		rg.direction = "N";
		for(int i=0; i<4; i++) {
			rg.changeOrientation("L");
			//if we change the orientation 4 times, it will be back to its original orientation
		}
		String newDirection = rg.direction;
		assertTrue(expected.equals(newDirection));
	}
	
	@Test
	void testForTurnRightCommand() {
		String expected = "N";
		rg.direction = "N";
		for(int i=0; i<4; i++) {
			rg.changeOrientation("R");
			//if we change the orientation 4 times, it will be back to its original orientation
		}
		String newDirection = rg.direction;
		assertTrue(expected.equals(newDirection));
	}
}
