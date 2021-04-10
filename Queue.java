package queue;

//Author: Tyler Staker

import java.util.ArrayList;
import java.util.NoSuchElementException;

//Queue data structure
public class Queue<T> {

	ArrayList<T> queue;
	
	public Queue() {
		queue = new ArrayList<T>();
	}
	
	//Returns the number of elements in the queue
	public int size() {
		return queue.size();
	}
	
	//Returns the index of the found element, or -1 if no element is found
	public int contains(T item) {
		for(int i = 0; i < size(); i++) {
			if(queue.get(i) == item) {
				return i;
			}
		}
		return -1;
	}
	
	//Adds an element to the end of the queue
	public void enqueue(T item) {
		queue.add(item);
	}
	
	//Removes the oldest element in the queue
	public T dequeue() throws NoSuchElementException{
		//Cannot dequeue an empty queue
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		return queue.remove(0);
	}
	
	//Returns the top element of the queue
	public T peek() throws NoSuchElementException{
		//Cannot peek an empty queue
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		return queue.get(0);
	}
	
	//Prints the queue's elements in order, separated by commas
	public void printQueue() {
		for(int i = 0; i < size(); i++) {
			if(i + 1 != size()) {
				System.out.print(queue.get(i) + ", ");
			}
			else {
				System.out.print(queue.get(i));
			}
		}
	}
	
	//Tests methods
	public static void main(String[] args) {
		Queue<Integer> newQueue = new Queue<Integer>();
		newQueue.enqueue(6);
		newQueue.enqueue(999);
		newQueue.enqueue(8);
		newQueue.enqueue(6);
		newQueue.enqueue(45);
		
		System.out.println(newQueue.peek());
		System.out.println(newQueue.contains(45));
		
		newQueue.dequeue();
		newQueue.printQueue();
	}

}
