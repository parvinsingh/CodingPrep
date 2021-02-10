package com.parvin.treesAndGraphs;

public class ReorderTree {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(2);
		System.out.println("Before reorder");
		printTree(root);
		
		reorder(root);
		System.out.println("After reorder");
		printTree(root);
	}
	
	private static void printTree(TreeNode node) {
		if(node == null) {
			return;
		}
		System.out.println(node.getVal()+"-");
		printTree(node.getLeft());
		printTree(node.getRight());
	}

	private static void reorder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		if(left == null 
				&& right == null) {
			return;
		}
		reorder(left);//7
		reorder(right);//2
		
		int temp = -1;//left->null  right>node
		
		if(left != null && (left.getVal() > right.getVal() && left.getVal() > root.getVal())) {
			temp = root.getVal();
			root.setVal(left.getVal());
			left.setVal(temp);
		}else if(right != null && right.getVal() > left.getVal() && right.getVal() > root.getVal()) {
			temp = root.getVal();
			root.setVal(right.getVal());
			right.setVal(temp);
		}
		
	}
	
}
