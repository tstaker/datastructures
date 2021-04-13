//Author: Tyler Staker

import java.util.ArrayList;
import java.util.NoSuchElementException;

//Queue data structure
public class Stack<T> {

	ArrayList<T> stack;
	
	public Stack() {
		stack = new ArrayList<T>();
	}
	
	//Returns the number of elements in the stack
	public int size() {
		return stack.size();
	}
	
	//Returns the index of the found element, or -1 if no matching element is found
	public int contains(T item) {
		int index = 0;
		for(int i = size() - 1; i >= 0; i--) {
			if(stack.get(i) == item) {
				return index;
			}
			index++;
		}
		return -1;
	}
	
	//Adds an element to the end of the stack
	public void push(T item) {
		stack.add(item);
	}
	
	//Removes the newest element in the stack
	public T pop() throws NoSuchElementException{
		//Cannot pop off an empty stack
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		return stack.remove(size() - 1);
	}
	
	//Returns the top element of the stack
	public T peek() throws NoSuchElementException{
		//Cannot peek if stack is empty
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		return stack.get(size() - 1);
	}
	
	//Prints the stack's elements in order, separated by commas
	public void printStack() {
		for(int i = size() - 1; i >= 0; i--) {
			if(i != 0) {
				System.out.print(stack.get(i) + ", ");
			}
			else {
				System.out.print(stack.get(i));
			}
		}
	}
	
	//Tests methods
	public static void main(String[] args) {
		Stack<Integer> newStack = new Stack<Integer>();
		newStack.push(6);
		newStack.push(999);
		newStack.push(8);
		newStack.push(6);
		newStack.push(45);
		
		System.out.println(newStack.peek());
		System.out.println(newStack.contains(45));
		
		newStack.pop();
		newStack.printStack();
	}

}
