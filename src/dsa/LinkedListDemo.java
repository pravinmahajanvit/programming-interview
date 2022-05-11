package dsa;

public class LinkedListDemo {

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

		public void buildTree(int[] values, int rootNodeValue) {

			if (rootNodeValue == -1) {
				return;
			}
			Node rootNode = new Node(rootNodeValue);
			for (int i = 0; i < values.length; i++) {
				Node newNode = new Node(values[i]);
				if (newNode.data < rootNode.data) {
					rootNode.left = newNode;
				}
				if (newNode.data > rootNode.data) {
					rootNode.right = newNode;
				}
			}

		}
	}
	public static void main(String[] args) {
		BinaryTree binaryTree=new BinaryTree();
		int[] arr = {5,3,6};
	}
}
