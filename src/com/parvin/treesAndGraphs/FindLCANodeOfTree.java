package com.parvin.treesAndGraphs;

public class FindLCANodeOfTree {

	public static void main(String args[])
    {
		TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        
    }
	
	//Single Traversal
	//Assumption: nodes are present in the Tree
	private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return null;
		
		if(root == p || root == q) return root;
		
		TreeNode left_LCA = findLCA(root.left, p, q);
		TreeNode right_LCA = findLCA(root.right, p, q);
		
		if(left_LCA != null && right_LCA != null){
			return root;
		}
		
		return left_LCA!=null ? left_LCA : right_LCA;
	}
}
