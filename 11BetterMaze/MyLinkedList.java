import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
	public Iterator<T> iterator() {
		return new MyLinkedListIterator(this);
	}
	
	public class MyLinkedListIterator implements Iterator<T> {
		int pos;
		LNode current;
		
		public MyLinkedListIterator(MyLinkedList<T> L) {
			pos = 0;
			current = L.start;
		}
		
		public boolean hasNext() {
			if (current.getNext() != null) {
				return true;
			}
			return false;
		}
		public T next() {
			pos = 1;
			T ret = current.getData();
			current = current.getNext();
			return ret;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
    private class LNode{
		T value;
		LNode next;

		public LNode(T val){
		    value = val;
		    next = null;
		}

		public LNode(T _val, LNode _next){
	        next = _next;
	        value = _val;
	    }

	    public T getData(){
		    return value;
		}

		public T setData(T val){
		    value = val;
		    return val;
		}

		public LNode getNext(){
		    return next;
		} 

		public LNode setNext(LNode Next){
		    next = Next;
		    return next;
		}

		public boolean hasNext(){
		    if(getNext()==null)
				return false;
		    return true;
		}
    }
    private LNode start;
    private LNode last;
    private int size;

    // no constructor necessary bc things will automatically be init to null and 0


    public int size(){
		return size;
    }

    public T get(int index){
    	if(index < 0 || index > size())
           throw new IndexOutOfBoundsException();
        if (isEmpty())
        	throw new NoSuchElementException();
		LNode current = start;
		for(int i = 0; i < index; i++){
		    current = current.getNext();
		}
		return current.getData();
    }

    public T set(int index, T val){
    	if(index < 0 || index >= size())
           throw new IndexOutOfBoundsException();
		LNode current = start;
		for(int i = 0; i < index; i++){
		    current = current.getNext();
		}
		if (index == size - 1)
			last = current;
		return current.setData(val);
    }

    public boolean add(T value){
    	if (value == null){
        	throw new NullPointerException();
        }
		if(start==null){
		    start = new LNode(value);
		    last = start;
		}else{
		    last.setNext(new LNode(value));
		    last = last.getNext();
		    
		}
		size++;
		return true;
    }

    public boolean add(int index,T value){
    	if (value == null){
        	throw new NullPointerException();
        }
    	if(index < 0 || index > size)
    		throw new IndexOutOfBoundsException();
    	LNode temp = new LNode(value);
		if (index == size)
			return add(value);
		if (index == 0){
			temp.setNext(start);
			start = temp;
			size ++;
			return true;
		}
		LNode current = start;
		for(int i = 1; i < index; i++){
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
		return true;
    }
/*
    public boolean push(T val){
    	if (val == null){
        	throw new NullPointerException();
        }
		if(start==null){
		    start = new LNode(value);
		    last = start;
		    return true;
		    size++;
		} else{
	    	LNode temp = new LNode(val);
	    	temp.getNext() = start;
	    	start = temp;
	    	size++;
	    }
    }
    */

    public T remove(int index){
        if (isEmpty())
        	throw new NoSuchElementException();
    	if(index < 0 || index > size())
           throw new IndexOutOfBoundsException();
    	if (index == 0){
    		T removed = start.getData();
    		start = start.getNext();
    		size --;
    		return removed;
    	}
		LNode current = start;
		for(int i = 1; i < index; i++){
			current = current.getNext();
		}
		LNode temp = current.getNext();
		current.setNext(temp.getNext());
		if(current.getNext()==null){
		    last=current;
		}
		size--;
		return temp.getData();
    }
/*
    public T pop(){
    	T elem = start.getData();
    	start = start.getNext();
    	size--;
    	return elem;
    }
    */

    public int indexOf(T value) {
        int index = 0;
        LNode current = start;
        while (current != null) {
            if (current.getData() == value) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

	public boolean contains(T value){
        int index = 0;
        LNode current = start;
        while (current != null) {
            if (current.getData() == value) {
                return true;
            }
            index++;
            current = current.getNext();
        }
        return false;
    }

    public boolean clear(){
    	start = null;
    	size = 0;
    	return true;
    }
  
    public boolean isEmpty(){
    	return start == null || size == 0;
    }

    public String toString(){
    	if (isEmpty()){
        	return "[ ]";
        }
		String output = "[";
		LNode current = start;
		while(current != null){
	    	output += current.getData().toString();
	    	if(current.getNext() != null){
				output += ", ";
	    	}
	    	current=current.getNext();
		}
		return output + "]";
    }
/*
    public static void main(String[] args){
    	MyLinkedList m = new MyLinkedList();
		m.add(3);
		m.add(2);
		m.add(1,7);
		System.out.println(m.toString());
		System.out.println(m.remove(1));
		System.out.println(m.toString());
		m.add(3);
		m.add(2);
		System.out.println(m.toString());
		System.out.println(m.get(1));
		System.out.println(m.toString());
		System.out.println(m.get(1));
		System.out.println(m.indexOf(2));
		m.set(1, 9);
		System.out.println(m.toString());

    	MyLinkedList myList = new MyLinkedList();
        myList.add(7);
        myList.add(16);
        myList.add(0, 9);
        myList.add(9, 4);
        myList.add(2, 6);
        System.out.println(myList.toString() + myList.size());
        System.out.println(myList.get(2));
        myList.set(3, 17);
        System.out.println(myList.toString() + myList.size());
        
        myList.remove(2);
        System.out.println(myList.toString() + myList.size());
        System.out.println(myList.indexOf(17));
        myList.clear();
        System.out.println(myList.toString() + myList.size());
		
    } */
   
}
