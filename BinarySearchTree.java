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
		head = removeHelper(head, data);
	}
	
	private Node<E> removeHelper(Node<E> node, E data) {
		if(node == null) {
			return null;
		}
		
		int comparison = data.compareTo(node.getData());
		
		if(comparison < 0) {
			node.setLeftNode(removeHelper(node.getLeftNode(), data));
		}
		else if(comparison > 0) {
			node.setRightNode(removeHelper(node.getRightNode(), data));
		}
		else {
			// Node to be removed found
			size--;
			
			// Case 1: Node has no children
			if(node.getLeftNode() == null && node.getRightNode() == null) {
				return null;
			}
			// Case 2: Node has only right child
			else if(node.getLeftNode() == null) {
				return node.getRightNode();
			}
			// Case 3: Node has only left child
			else if(node.getRightNode() == null) {
				return node.getLeftNode();
			}
			// Case 4: Node has both children
			else {
				// Find inorder successor (smallest in right subtree)
				Node<E> successor = findMin(node.getRightNode());
				// Replace node's data with successor's data
				node.setData(successor.getData());
				// Remove the successor
				node.setRightNode(removeHelper(node.getRightNode(), successor.getData()));
				size++; // Increment back since we decremented above but we're removing successor
			}
		}
		return node;
	}
	
	private Node<E> findMin(Node<E> node) {
		while(node.getLeftNode() != null) {
			node = node.getLeftNode();
		}
		return node;
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
