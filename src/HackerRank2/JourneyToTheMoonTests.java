package HackerRank2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class JourneyToTheMoonTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testAstronautPairs1() {
		int[][] input = {{0,1},{2,3},{0,4}};
		int result = JourneyToTheMoon.journeyToMoon(5, input);
		Assert.assertEquals(6, result);
	}

	@Test
	public void testAstronautPairs2() {
		int[][] input = {{0,2}};
		int result = JourneyToTheMoon.journeyToMoon(4, input);
		Assert.assertEquals(5, result);
	}

}
