package com.parvin.treesAndGraphs;

import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearchTree {

	public static void main(String args[]) {
		int[] input = { 1, 2, 4, 6, 8, 10, 11, 12, 13, 15, 18, 21, 23 };
		TreeNode root = createMinimalBST(input);
		System.out.print("Root node of the BST " + root.val);
		System.out.println();
		
		TreeNode rootNode = new TreeNode(10);
		rootNode.left = new TreeNode(4);
		rootNode.right = new TreeNode(20);
		rootNode.left.left = new TreeNode(2);
		rootNode.right.left = new TreeNode(15);
		rootNode.right.right = new TreeNode(40);
		
		System.out.println(kthLargestNode(rootNode, 2));
	}

	private static TreeNode createMinimalBST(int[] input) {
		return createBST(input, 0, input.length - 1);
	}

	private static TreeNode createBST(int[] input, int start, int end) {
		if (start >= end) {
			return null;
		} else {
			int mid = (start + end) / 2;
			TreeNode root = new TreeNode(input[mid]);
			root.left = createBST(input, 0, mid - 1);
			root.right = createBST(input, mid + 1, end);
			return root;
		}
	}

	public TreeNode maxDepthNode(TreeNode root) {
		return maxDepth(root, 0, new BinarySearchTree().new NodeDetails()).node;
	}

	private NodeDetails maxDepth(TreeNode root, int depth, NodeDetails nodeDetails) {
		if (root == null) {
			return nodeDetails;
		} else if (root.left == null || root.right == null) {
			nodeDetails.node = root;
			nodeDetails.nodeDepth = depth;
			return nodeDetails;
		} else {
			NodeDetails leftSide = maxDepth(root.left, depth + 1, nodeDetails);
			NodeDetails rightSide = maxDepth(root.right, depth + 1, nodeDetails);

			if (leftSide.nodeDepth >= rightSide.nodeDepth) {
				return leftSide;
			} else {
				return rightSide;
			}
		}
	}
	
	private static int kthLargestNode(TreeNode root, int k) {
		AtomicInteger i = new AtomicInteger(0);
		return kthLargestNode(root, k, i);
	}

	private static int kthLargestNode(TreeNode root, int k, AtomicInteger i) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		
		int right = kthLargestNode(root.right, k, i);
		
		if(right != Integer.MAX_VALUE) {
			return right;
		}
		
		if(i.incrementAndGet()==k) {
			return root.val;
		}
		
		return kthLargestNode(root.left, k, i);
	}

	class NodeDetails {
		TreeNode node;
		int nodeDepth;
	}
}
