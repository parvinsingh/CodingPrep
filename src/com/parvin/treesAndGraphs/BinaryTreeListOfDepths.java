package com.parvin.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * create a list of nodes at each depth in the BST
 */

public class BinaryTreeListOfDepths {

	//TimeComplexity = O(N) Space = O(N)
	public static List<LinkedList<TreeNode>> CreateList(TreeNode root){
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		current.add(root);
		result.add(current);
		
		while(current.size() > 0) {
			List<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			
			for(TreeNode p: parents) {
				current.add(p.left);
				current.add(p.right);
			}
			result.add(current);
		}
		return result;
	}
}
