import java.util.*;

public class MyQueue<T> {
	private MyLinkedList<T> myList;
	
	public MyQueue() {
		myList = new MyLinkedList<T>();
	}
	
	public void enqueue(T item) {
		myList.add(item);
	}
	
	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return myList.remove(0);
	}
	
	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return myList.get(0);
	}
	
	public int size() {
		return myList.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
}