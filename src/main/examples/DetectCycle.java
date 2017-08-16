package main.examples;

public class DetectCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeL n3 = new NodeL(2, null);
		NodeL n2 = new NodeL(2, n3);
		NodeL n1 = new NodeL(1, n2);
		n3.next = n2;
		System.out.println(hasCycle(n1));
		
		NodeL sc1 = new NodeL(1, null);
		System.out.println(hasCycle(sc1));
		

	}
	
	static boolean hasCycle(NodeL head) {
		NodeL slow, fast;
		slow = fast = head;
		
		while (true) {
			slow = slow.next;
			
			if (fast.next!=null)
				fast = fast.next.next;
			else
				return false;
			
			if (slow == null || fast == null)
				return false;
			
			if (slow==fast)
				return true;
			
		}

	}

}

class NodeL {
    int data;
    NodeL next;
    
    public NodeL(int data, NodeL next) {
    	this.data = data;
    	this.next = next;
    }

}
