package main.examples;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaleOfTwoStacks {
	
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }

}

class MyQueue<E> {
	
	private class Element<E> {
        // The data value of the element
        private E data;
        // The next element in the queue
        private Element<E> next;
        
        Element(E data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // The first element in the queue
    private Element<E> front;
    // The last element in the queue
    private Element<E> back;
    
    public MyQueue() {
        this.front = null;
        this.back = null;
    }
    
    public boolean isEmpty() {
    	return this.front == null || this.back == null;
    }
	
    public void enqueue(E data) {
    	Element<E> element = new Element<>(data);
    	if (isEmpty()) {
    		this.front = element;
    	} else {
    		this.back.next = element;
    	}
    	this.back = element;
    }
    
    public Element<E> dequeue() {
    	if (isEmpty()) {
    		throw new NoSuchElementException();
    	}
		Element<E> head = this.front;
		this.front = this.front.next;
		return head;
    	
    }
    
    public E peek() {
    	if (isEmpty()) {
    		throw new NoSuchElementException();
    	}
		Element<E> head = this.front;

		return head.data;
    	
    }
	
}
