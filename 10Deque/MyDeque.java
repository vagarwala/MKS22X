import java.util.*;
import java.util.Arrays;
public class MyDeque<T>{
	private T[] array;
	private int front, end;
	private int size;
	private int capacity;

	public MyDeque(int capacity){
		array = (T[]) new Object[capacity];
		front = 1;
		end = 0;
		size = 0;
		this.capacity = capacity - 1;
	}

	public int size(){
		return size;
	}

	private void grow(){
		T[] temp = (T[]) new Object[array.length * 2];
		System.arraycopy(array, 0, temp, 0, array.length);
		array = temp;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public T getFirst(){
		if (isEmpty())
			throw new NoSuchElementException();
		return array[(end+1)%capacity];
	}

	public T getLast(){  
	    if (isEmpty())
	      throw new NoSuchElementException();
	    return array[(end+1)%capacity];
	  }
	 
	 // Adds a new element at the front
	 public void addFirst(T val){  
	    if (size == capacity)
	        grow();
	    array[front] = val;
	    front = (front+1)%capacity; 
	    size++;
	  }
	 
	 // Adds a new node at the tail
	 public void addLast(T val) {  
	    if (size == capacity)
	        grow();
	    array[end] = val;
	    end = (end-1)%capacity; 
	    size++;
	  }
	 
	 // Removes the first node
	 public T removeFirst(){
	    if (isEmpty())
	      throw new NoSuchElementException();
	    front = (front-1)%capacity;
	    size--; 
	    return array[front];
	  }
	 
	 // Removes the last node
	 public T removeLast(){
	    if (isEmpty())
	      throw new NoSuchElementException();
	    end = (end+1)%capacity;
	    size--; 
	    return array[end];
	  }

	  public String toString(){
	  	return Arrays.toString(array);
	  }
}