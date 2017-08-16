package main.examples;

public class CheckBST {
	

    public boolean checkBST(Node root) {
    	return isBST(root, 0, 10000);
    }
    
    public boolean isBST(Node node, int min, int max) {
    	if (node==null)
    		return true;
    	
    	if ( node.data < min || node.data > max )
    		return false;
    	
    	return ( isBST(node.left, min, node.data-1) &&
    			isBST(node.right, node.data+1, max));
    }

    
    public static void main(String[] args) {
    	
    }
    
    public Node createTree() {
    	Node leaf1 = new Node(1, null, null);
    	Node leaf2 = new Node(3, null, null);
    	Node leaf3 = new Node(5, null, null);
    	Node leaf4 = new Node(7, null, null);
    	Node leaf5 = new Node(2, leaf1, leaf2);
    	Node leaf6 = new Node(6, leaf3, leaf4);
    	Node root = new Node(4, leaf5, leaf6);
    	return root;
    }

}

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data, Node left, Node right) {
    	this.data = data;
    	this.left = left;
    	this.right = right;
    }
    
	public int getData() {
		return data;
	}
	
	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}
    
 }

