package com.parvin.leetcodeQuestions.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.parvin.leetcodeQuestions.Trie;

class TrieTests {

	private static Trie testTrie = null;
	
	@BeforeAll
	static void setUp() throws Exception {
		testTrie = new Trie();
	}

	@Test
	void testInsertWorks() {
		testTrie.insert("mango");
		boolean actual = testTrie.search("mango");
		Assert.assertTrue(actual);
	}

	@Test
	void testInsertDoesNotWork() {
		testTrie.insert("peaches");
		boolean actual = testTrie.search("orange");
		assertFalse(actual);
	}
	
	@Test
	void testSearchWithPrefix() {
		testTrie.insert("peaches");
		boolean actual = testTrie.startsWith("pea");
		assertTrue(actual);
	}
	
	@Test
	void testSearchInEmptyTrie() {
		testTrie = new Trie();
		boolean actual = testTrie.startsWith("pea");
		assertFalse(actual);
	}
	
	@Test
	void testPrefixSearchCaseSensitivity() {
		assertThrows(ArrayIndexOutOfBoundsException.class, 
				() -> testTrie.insert("Peaches"));
	}
}
