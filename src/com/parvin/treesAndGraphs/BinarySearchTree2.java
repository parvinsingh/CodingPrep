package com.parvin.treesAndGraphs;
import java.util.ArrayList;
import java.util.Arrays;


public class BinarySearchTree2 {
	
	public static void main(String args[]){
		int[] input = {1,2,4,6,8,10,11,12,13,15,18,21,23};
		TreeNode root = createMinimalBST(input);
		System.out.print("Root node of the BST " + root.val);
		System.out.println("In Order Format: ");
		inOrder(root);
		System.out.println("Post Order Format: ");
		postOrder(root);
		System.out.println();
		System.out.println("max Depth of Tree " + maxDepth(root));
		System.out.println();
		TreeNode bottomNode = maxDepthNode(root);
		if(bottomNode!=null){
			System.out.println("Bottom most Node of the Tree " + bottomNode.val);
		}
		
		//Instantiating arraylists
		ArrayList<String> listOfStrings = new ArrayList<String>(
				Arrays.asList("abc","def","ghi"));
		
		//Instantiating arraylists
		ArrayList<String> listOfStrings2 = new ArrayList<String>(){
			{
				add("abc");
				add("abc");
			}
		};	
		
		
	}

	public boolean isValidBST(TreeNode root){
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
	
	private boolean isValidBST(TreeNode root, double min, double max){
		if(root==null){
			return true;
		}
		if(root.val <= min || root.val >= max){
			return false;
		}
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
	
	private boolean searchNode(int data, TreeNode root){
		if(root==null){
			return false;
		}
		if(root.val == data){
			return true;
		}
		if(data < root.val){
			searchNode(data, root.left);
		}else if(data > root.val){
			searchNode(data, root.right);
		}
		return false;
	}
	
	private TreeNode insertNode(int data, TreeNode node){
		if(node == null){
			node = new TreeNode(data);
		}else{
			if(data < node.val){
				node.left = insertNode(data, node.left);
			}else if (data >= node.val){
				node.right = insertNode(data, node.right);
			}
		}
		return node;
	}
	
	private int sizeOfTree(TreeNode node){
		if(node == null){
			return 0;
		}else{
			int leftCount = sizeOfTree(node.left);
			int rightCount = sizeOfTree(node.right);
			return leftCount + 1 + rightCount;
		}
	}
	
	/*
	 * find maxDepth of a BST,
	 * also the height of tree
	 */
	private static int maxDepth(TreeNode node){
		if(node==null){
			return 0;
		}else{
			int leftDepth = maxDepth(node.left);
			int rightDepth = maxDepth(node.right);
			return Math.max(leftDepth, rightDepth)+1;
		}
	}
	
	 private static TreeNode maxDepthNode(TreeNode root){
		if(root==null) return null;
		BinarySearchTree2 bst = new BinarySearchTree2();
		BinarySearchTree2.NodeDetails nodeDetails =
					bst.new NodeDetails();
		maxDepthNode(root, 0, nodeDetails);
		
		return nodeDetails.node;
	 }
	
	private static NodeDetails maxDepthNode(TreeNode node, int depth, NodeDetails nodeDetails){
		if(node==null) return nodeDetails;
		if(node.left==null && node.right==null){		
			nodeDetails.node = node;
			nodeDetails.depth = depth;
			return nodeDetails;
		}else{
			NodeDetails leftDepth = maxDepthNode(node.left, depth+1, nodeDetails);
			NodeDetails rightDepth = maxDepthNode(node.right, depth+1, nodeDetails);
			
			if(leftDepth.depth >= rightDepth.depth){
				return leftDepth;
			}else{
				return rightDepth;
			}
		}
		
	}
	
	class NodeDetails {
		int depth;
		TreeNode node;
	}
	/*
	 * InOrder Traversal of a BST
	 * LeftNode , Node , RightNode 
	 */
	private static void inOrder(TreeNode node){
		if(node==null){
			return;
		}
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}
	
	/*
	 * PostOrder Traversal of a BST
	 * Left Node, right Node, Node
	 */
	private static void postOrder(TreeNode node){
		if(node==null){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + " ");
		
	}
	
	/*
	 *  Given a tree and a sum, returns true if there is a path from the root 
		 down to a leaf, such that adding up all the values along the path 
		 equals the given sum.
		 Strategy: subtract the node value from the sum when recurring down, 
		 and check to see if the sum is 0 when you run out of tree. 
	 */
	private boolean hasPathSum(TreeNode node, int sum){
		if(node==null){
			return (sum==0);
		}else{
			return hasPathSum(node.left, sum-(node.val)) || hasPathSum(node.right, sum-(node.val)); 
		}
	}
	
	/*
	 * Mirror the tree
	 */
	private void mirror(TreeNode node){
		if(node!=null){
			mirror(node.left);
			mirror(node.right);
			
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}
	
	/*
	 * Check if a BST is balanced or not
	 * BST is balanced if the height of two subtrees 
	 * of any node does not differ by more than one
	 * O(N logN) time
	 */
	private boolean isBalancedBST(TreeNode node){
		if(node == null){
			return false;
		}else{
			return (Math.abs(maxDepth(node.left) - maxDepth(node.right)) <= 1);
		}
	}
	
	/*
	 * O(N) time and O(H) complexity, where H is the height of the tree
	 */
	private boolean isBalanced(TreeNode node){
		if(checkHeight(node)==-1){
			return false;
		}else{
			return true;
		}
	}
	private int checkHeight(TreeNode node){
		if(node==null){
			return 0;
		}else{
			int leftHeight = checkHeight(node.left);
			if(leftHeight == -1) return -1;
			
			int rightHeight = checkHeight(node.right);
			if(rightHeight == -1) return -1;
			
			int heightDiff = leftHeight - rightHeight;
			
			if(Math.abs(heightDiff) > 1){
				return -1;
			}else{
				return Math.max(leftHeight, rightHeight)+1;
			}
		}
	}
	
	/*
	 * Given a sorted increasing order Array
	 * write an algorithm to create a minimalHeightBST 
	 */
	private static TreeNode createMinimalBST(int input[]){
		return createMinimalBST(input, 0, input.length-1);
	}
	private static TreeNode createMinimalBST(int input[], int start, int end){
		if(start > end){
			//base check
			return null;
		}
		int mid = (start+end)/2;
		TreeNode node = new TreeNode(input[mid]);
		node.left = createMinimalBST(input, start, mid-1);
		node.right = createMinimalBST(input, mid+1, end);
		
		return node;
	}
	
	/*
	 * Print Node
	 * Print Left Side
	 * Print Print Leaf nodes
	 * Print Right Side
	 * 
	 */
	private void printEdgesOfTree(TreeNode node){
		if(node==null) return;
		System.out.println(node.val);
		printLeftSide(node.left);
		printLeafNode(node);
		printRightSide(node.right);
	}
	
	/*
	 * Top down approach of printing
	 */
	private void printLeftSide(TreeNode node){
		if(node!=null){
			if(node.left!=null){
				System.out.println(node.val);
				printLeftSide(node.left);
			}else if(node.right!=null){
				System.out.println(node.val);
				printLeftSide(node.right);
			}
		//we come here when it is a leaf node. Do not print the Leaf node now.	
		}
		
	}
	
	/*
	 * Bottom UP approach of printing
	 */
	private void printRightSide(TreeNode node){
		if(node!=null){
			if(node.right!=null){
				//we first move all the way to the bottom before we start printing
				printRightSide(node.right);
				System.out.println(node.val);
			}else if(node.left!=null){
				printRightSide(node.left);
				System.out.println(node.val);
			}
		//we come here when it is a leaf node. Do not print the Leaf node now.	
		}
	}
	
	private void printLeafNode(TreeNode node){
		if(node!=null){
			printLeafNode(node.left);
			if(node.left==null && node.right==null){
				System.out.println(node.val);
			}
			printLeafNode(node.right);
		}
	}
	
	//design an algo to print all paths which sum to a given value
	//the path must go in a straight line down.
	
	
}

