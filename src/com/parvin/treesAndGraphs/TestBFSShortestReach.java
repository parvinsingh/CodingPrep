package com.parvin.treesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBFSShortestReach {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		int nodes = 3;
		int start = 2;
		int numOfEdges = 1;
		int[][] edges= {{2,3}};
		int[] result = BFSShortestReach.shortestReach(edges, nodes, start, numOfEdges);
		int[] expected = {-1,6};
		Assert.assertArrayEquals(expected, result);
	}

	@Test
	public void test2() {
		int nodes = 5;
		int start = 1;
		int numOfEdges = 3;
		int[][] edges= {{1,2},{1,3},{3,4}};
		int[] result = BFSShortestReach.shortestReach(edges, nodes, start, numOfEdges);
		int[] expected = {6,6,12,-1};
		Assert.assertArrayEquals(expected, result);
	}
}
