package dsa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeDemo {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class BinaryTree {
		static int index = -1;

		public static Node buildTree(int[] nodes) {
			index++;
			if (nodes[index] == -1) {
				return null;
			}
			Node newNode = new Node(nodes[index]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);
			return newNode;

		}

		public static void preorder(Node rootNode) {
			if (rootNode == null) {
				return;
			}
			System.out.print(rootNode.data + " ");
			preorder(rootNode.left);
			preorder(rootNode.right);
		}

		public static void inorder(Node rootNode) {
			if (rootNode == null) {
				return;
			}
			inorder(rootNode.left);
			System.out.print(rootNode.data + " ");
			inorder(rootNode.right);
		}

		public static void postorder(Node rootNode) {
			if (rootNode == null) {
				return;
			}
			inorder(rootNode.left);
			inorder(rootNode.right);
			System.out.print(rootNode.data + " ");
		}

		public static void levelOrder(Node root) {
			if (root == null) {
				return;
			}
			Queue<Node> que = new LinkedList<>();
			que.add(root);
			que.add(null);
			while (!que.isEmpty()) {
				Node currNode = que.remove();
				if (currNode == null) {
					System.out.println();
					if (que.isEmpty()) {
						break;
					} else {
						que.add(null);
					}
				} else {
					System.out.print(currNode.data);
					if (currNode.left != null) {
						que.add(currNode.left);
					}
					if (currNode.right != null) {
						que.add(currNode.right);
					}
				}
			}
		}

		public static int countNodes(Node root) {
			if (root == null) {
				return 0;
			}
			int leftCount = countNodes(root.left);
			int rightCount = countNodes(root.right);
			return leftCount + rightCount + 1;
		}

		public static int sumOfNodes(Node root) {
			if (root == null) {
				return 0;
			}
			int leftSum = sumOfNodes(root.left);
			int rightSum = sumOfNodes(root.right);
			return leftSum + rightSum + root.data;
		}

		public static int height(Node root) {
			if (root == null) {
				return 0;
			}
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}

		public static int diameter(Node root) {
			if (root == null) {
				return 0;
			}
			int leftDiameter = diameter(root.left);
			int rightDiameter = diameter(root.right);
			int diameter3 = height(root.left) + height(root.right) + 1;
			return Math.max(diameter3, Math.max(leftDiameter, rightDiameter));
		}

		public static Map<Integer, Integer> dim = new HashMap<>();

		public static class TreeInfo {
			int ht;
			int diam;

			public TreeInfo(int ht, int diam) {
				this.ht = ht;
				this.diam = diam;
			}
		}

		public static TreeInfo diameterOn(Node root) {
			if (root == null) {
				return new TreeInfo(0, 0);
			}
			TreeInfo left = diameterOn(root.left);
			TreeInfo right = diameterOn(root.right);
			int myHeight = Math.max(left.ht, right.ht) + 1;
			int dim1 = left.diam;
			int dim2 = right.diam;
			int dim3 = left.ht + right.ht + 1;
			int mydim = Math.max(dim3, Math.max(dim1, dim2));
			TreeInfo tree = new TreeInfo(myHeight, mydim);
			return tree;
		}

		public static Node invertTree(Node root) {
			if (root == null) {
				return root;
			}
			
			Node left = invertTree(root.left);
			Node right = invertTree(root.right);

			// swapping
			root.left = right;
			root.right = left;
			System.out.print(root.data + " ");
			return root;
		}
	}

	public static void main(String[] args) {
		//int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
		int[] nodes = { 4,2,7,-1,-1,1,-1,-1,3,-1,6,-1,9,-1,-1};
		Node rootNode = BinaryTree.buildTree(nodes);
		System.out.println(rootNode.data);
		BinaryTree.preorder(rootNode);
		BinaryTree.inorder(rootNode);
		BinaryTree.postorder(rootNode);
		BinaryTree.levelOrder(rootNode);
		System.err.println("Count nodes:" + BinaryTree.countNodes(rootNode));
		System.err.println("Sum of nodes:" + BinaryTree.sumOfNodes(rootNode));
		System.err.println("Height:" + BinaryTree.height(rootNode));
		System.err.println("Diameter:" + BinaryTree.diameter(rootNode));
		System.err.println("Diameter o2:" + BinaryTree.diameterOn(rootNode).diam);
		
		System.err.println("Invert:" + BinaryTree.invertTree(rootNode));
	}
}
