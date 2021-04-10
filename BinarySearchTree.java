package binarysearchtree;

public class BinarySearchTree<E extends Comparable<E>> {

	public class Node<T>{
		
		T data;
		Node<T> leftNode;
		Node<T> rightNode;
		
		//Empty node constructor
		public Node() {
			leftNode = null;
			rightNode = null;
			data = null;
		}
		
		//Node constructor with data only
		public Node(T data) {
			leftNode = null;
			rightNode = null;
			this.data = data;
		}
		
		//Full node constructor
		public Node(T data, Node<T> l, Node<T> r) {
			leftNode = l;
			rightNode = r;
			this.data = data;
		}
		
		//Sets data of this node to the data given
		public void setData(T data) {
			this.data = data;
		}
		
		public T getData() {
			return data;
		}
		
		//Sets the left node of this node to the node given
		public void setLeftNode(Node<T> l) {
			leftNode = l;
		}
		
		public Node<T> getLeftNode(){
			return leftNode;
		}
		
		//Sets the right node of this node to the node given
		public void setRightNode(Node<T> r) {
			rightNode = r;
		}
		
		public Node<T> getRightNode(){
			return rightNode;
		}
		
		public boolean hasChild() {
			if(leftNode != null || rightNode != null) {
				return true;
			}
			return false;
		}
	}
	
	Node<E> head;
	int size = 0;
	int traversalCount = 0;
	
	public BinarySearchTree() {
		
		head = new Node<E>();
	}
	
	//Adds a node to it's proper spot in the binary search tree
	public void add(E data) {
		if(size == 0) {
			head.setData(data);
			size++;
		}
		else if(size == 1) {
			if(data.compareTo(head.getData()) < 0) {
				head.setLeftNode(new Node<E>(data));
			}
			else {
				head.setRightNode(new Node<E>(data));
			}
			size++;
		}
		else {
			Node<E> temp = head;
			while(temp != null) {
				//If the newly-added data is less than the current node
				if(data.compareTo(temp.getData()) < 0) {
					if(temp.getLeftNode() == null) {
						temp.setLeftNode(new Node<E>(data));
						size++;
						return;
					}
					else {
						temp = temp.getLeftNode();
					}
				}
				//If the newly-added data is greater than or equal to the current node
				else if(data.compareTo(temp.getData()) > 0 || data.compareTo(temp.getData()) == 0){
					if(temp.getRightNode() == null) {
						temp.setRightNode(new Node<E>(data));
						size++;
						return;
					}
					else {
						temp = temp.getRightNode();
					}
				}
			}
			size++;
		}
	}
	
	//Removes the first node found that has data matching the argument, or does nothing if no such data
	public void remove(E data) {
		if(size == 0) {
			return;
		}
		Node<E> temp = head;
		Node<E> tempParent = head;
		boolean leftOfParent = false;
		while(temp.hasChild()) {
			//If the data to be removed is less than the current node
			if(data.compareTo(temp.getData()) < 0) {
				tempParent = temp;
				if(temp.getLeftNode() == null) {
					return;
				}
				temp = temp.getLeftNode();
				leftOfParent = true;
			}
			//If the data to be removed is greater than the current node
			else if(data.compareTo(temp.getData()) > 0){
				tempParent = temp;
				if(temp.getRightNode() == null) {
					return;
				}
				temp = temp.getRightNode();
				leftOfParent = false;
			}
			//Data to be removed is found
			else {
				size--;
				//Node has 2 children
				if(temp.getLeftNode() != null && temp.getRightNode() != null) {
					Node<E> currentLocation = temp;
					//Find successor: go right one then left as far as you can
					if(temp.getRightNode() != null) {
						tempParent = temp;
						temp = temp.getRightNode();
					}
					while(temp.getLeftNode() != null) {
						tempParent = temp;
						temp = temp.getLeftNode();
					}
					//If the node to swap with the removed node has a right child
					if(temp.getRightNode() != null) {
						//Set the parent of the swapped node's left node equal to the right child
						tempParent.setLeftNode(temp.getRightNode());
					}
					//Set the left and right children of the swapped node equal to the removed node's
					temp.setLeftNode(currentLocation.getLeftNode());
					temp.setRightNode(currentLocation.getRightNode());
					
				}
				//Node has 1 child
				else if(temp.getLeftNode() != null || temp.getRightNode() != null) {
					//The 1 child is the left node; set the child equal to the node's location
					if(temp.getLeftNode() != null) {
						if(leftOfParent) {
							tempParent.setLeftNode(temp.getLeftNode());
						}
						else {
							tempParent.setRightNode(temp.getLeftNode());
						}
					}
					//The 1 child is the right node; set the child equal to the node's location
					else {
						if(leftOfParent) {
							tempParent.setLeftNode(temp.getRightNode());
						}
						else {
							tempParent.setRightNode(temp.getRightNode());
						}
					}
				}
				//Node has 0 children
				else {
					if(leftOfParent) {
						tempParent.setLeftNode(null);
					}
					else {
						tempParent.setRightNode(null);
					}
				}
				return;
			}
		}
	}
	
	//Prints the tree in inOrder fashion
	public void inOrderTraversal(Node<E> n) {
		if(n == null) {
			return;
		}
		
		inOrderTraversal(n.getLeftNode());
		
		if(traversalCount + 1 != size) {
			System.out.print(n.getData() + ", ");
			traversalCount++;
		}
		else {
			System.out.print(n.getData() + "\n");
			traversalCount = 0;
		}
		
		inOrderTraversal(n.getRightNode());
	}
	
	public void inOrderTraversal() {
		inOrderTraversal(head);
	}
	
	//Prints the tree in postOrder fashion
	public void postOrderTraversal(Node<E> n) {
		if(n == null) {
			return;
		}
		
		postOrderTraversal(n.getLeftNode());
		
		postOrderTraversal(n.getRightNode());
		
		if(traversalCount + 1 != size) {
			System.out.print(n.getData() + ", ");
			traversalCount++;
		}
		else {
			System.out.print(n.getData() + "\n");
			traversalCount = 0;
		}
	}
	
	public void postOrderTraversal(){
		postOrderTraversal(head);
	}
	
	//Prints the tree in preOrder fashion
	public void preOrderTraversal(Node<E> n) {
		if(n == null) {
			return;
		}
		
		if(traversalCount + 1 != size) {
			System.out.print(n.getData() + ", ");
			traversalCount++;
		}
		else {
			System.out.print(n.getData() + "\n");
			traversalCount = 0;
		}
		
		preOrderTraversal(n.getLeftNode());
		
		preOrderTraversal(n.getRightNode());	
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(head);
	}
	
	//Tests methods
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.add(100);
		bst.add(30);
		bst.add(250);
		bst.add(2);
		bst.add(147);
		bst.add(101);
		bst.add(2);
		
		bst.preOrderTraversal();
		bst.postOrderTraversal();
		bst.inOrderTraversal();
		
		bst.remove(2);
		bst.remove(250);
		bst.remove(147);
		bst.add(3);
		
		bst.preOrderTraversal();
		bst.postOrderTraversal();
		bst.inOrderTraversal();
	}
	
}
