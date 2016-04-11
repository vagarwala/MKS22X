import java.util.*;

public class MyStack<T> {
	private MyLinkedList<T> myList;
	
	public MyStack() {
		myList = new MyLinkedList<T>();
	}
	
	public void push(T item) {
		myList.add(item);
	}
	
	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return myList.remove(size()-1);
	}
	
	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return myList.get(size()-1);
	}
	
	public int size() {
		return myList.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
}