/**
 * 
 */
package com.parvin.leetcodeQuestions;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author papanesa
 *
 */
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
		int result = JourneyToTheMoon.astronautPairs(input, 5);
		Assert.assertEquals(6, result);
	}

	@Test
	public void testAstronautPairs2() {
		int[][] input = {{0,2}};
		int result = JourneyToTheMoon.astronautPairs(input, 4);
		Assert.assertEquals(5, result);
	}
}
