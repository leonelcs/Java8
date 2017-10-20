package main.examples;

public class KmpLinkedList {

	public static class LinkedListNode {
		String val;
		LinkedListNode next;

		LinkedListNode(String node_value) {
			val = node_value;
			next = null;
		}
	}

	static int find(LinkedListNode list, LinkedListNode sublist) {
		int counter = 0;
		int index = -1;
		LinkedListNode sub = sublist;

		do {
			if (list.val == sub.val) {
				if (index == -1)
					index = counter;
				if (sub.next != null) {
					sub = sub.next;
					if (sub.next == null) {
						return index;
					}
				}
			} else {
				index = -1;
				sub = sublist;
			}
			list = list.next;
			counter++;

		} while (list.next != null);

		return index;
	}

}
