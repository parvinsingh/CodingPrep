package com.parvin.leetcodeQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Initialize a tree with a single vertex, chosen arbitrarily from the graph.
Grow the tree by one edge: of the edges that connect the tree to vertices not yet in the tree, 
find the minimum-weight edge, and transfer it to the tree.
Repeat step 2 (until all vertices are in the tree).
 */
public class CostEffectiveGraph {

	public static void main(String args[]) {
		int[][] input = {{0,2,-1,1},
				 {2,0,-1,2},
				 {-1,-1,0,3},
				 {1,2,3,0}};
		CostEffectiveGraph ceg = new CostEffectiveGraph();
		TreeNode result = costOptimization(input, ceg);
		 
		
	}
	
	private static TreeNode costOptimization(int[][] input, CostEffectiveGraph ceg) {
		
		int[] vertices = new int[input.length];
		TreeNode r = ceg. new TreeNode(vertices[0]);
		
		
		for(int i=0; i<vertices.length; i++) {
			//if root edges does not have vertics[i] then I check and add edge
			addEdge(r, input, ceg);
		}
		return r;
	}
	
	private static void addEdge(TreeNode node, int[][] input, CostEffectiveGraph ceg) {
		int data = node.data;
		
		int min = findMin(input[data]);
		
		node.addEdges(ceg. new TreeNode(min));
		
	}
	
	private static int findMin(int[] ip) {
		int cost = Integer.MAX_VALUE;
		int costIndex = 0;
		for(int i=0; i<ip.length; i++) {
			if(ip[i]==0 || ip[i]==-1) {
				continue;
			}else {
				if(cost>ip[i]) {
					costIndex = i;
					cost = Math.min(cost, ip[i]);
				}
			}
		}
		return costIndex;
	}
	
	class TreeNode{
		int data;
		List<TreeNode> edges;
		
		TreeNode(int data){
			this.data = data;
		}
		
		void addEdges(TreeNode e){
			edges.add(e);
		}
	}
}
