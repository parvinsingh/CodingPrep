package allTestCases;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.parvin.StringQuestions.WeightedUniformStrings;

public class TestWeightedUniformStrings {
	
	@BeforeAll
	static void setUp() throws Exception {
	}

	@Test
	void testCase1() {
		String input = "abccddde";
		int[] queries = {1,3,12,5,9,10};
		String[] expectedOutput = {"YES", "YES", "YES", "YES", "NO", "NO"};
		assertResult(input, queries, expectedOutput);
	}

	@Test
	void testCase2() {
		String input = "aaabbbbcccddd";
		int[] queries = {9,7,8,12,5};
		String[] expectedOutput = {"YES", "NO", "YES", "YES", "NO"};
		assertResult(input, queries, expectedOutput);
	}
	

	private void assertResult(String input, int[] queries, String[] expectedOutput) {
		String[] actualOutput = WeightedUniformStrings.uniformStrings(input, queries);
		assertArrayEquals(expectedOutput, actualOutput);
	}
	
}
