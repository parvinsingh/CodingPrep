package allTestCases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.parvin.interviewprep.LockCombination;

public class TestLockCombinations {
	
	@BeforeAll
	static void setUp() throws Exception {
	}

	@Test
	void testCase1() {
		boolean[] validCombo = {false, false, true, false, true};
		LockCombination lock = new LockCombination(validCombo, 5);
		assertTrue(lock.isValidCombination());
	}
	
	@Test
	void testCase2() {
		boolean[] validCombo = {true, false, true, false, true};
		LockCombination lock = new LockCombination(validCombo, 5);
		assertTrue(lock.isValidCombination());
	}

	@Test
	void testCaseCheckComboReturnsFalse() {
		boolean[] validCombo = {false, true, false, true, true};
		LockCombination lock = new LockCombination(validCombo, 5);
		boolean[] tobeValidated = {false, false, false, true, true};
		assertFalse(lock.checkCombo(tobeValidated));
	}
	
	@Test
	void testCaseCheckComboReturnsTrue() {
		boolean[] validCombo = {false, true, false, true, true};
		LockCombination lock = new LockCombination(validCombo, 5);
		boolean[] tobeValidated = {false, true, false, true, true};
		assertTrue(lock.checkCombo(tobeValidated));
	}
	
}
