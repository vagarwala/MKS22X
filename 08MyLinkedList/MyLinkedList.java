public class MyLinkedList<T>{

    private class LNode<T>{
		T value;
		LNode<T> next;

		public LNode(T val){
		    value = val;
		    next = null;
		}

		public LNode(T _val, LNode<T> _next){
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

		public LNode<T> getNext(){
		    return next;
		} 

		public LNode<T> setNext(LNode<T> Next){
		    next = Next;
		    return next;
		}
    }
    private LNode<T> start;
    private LNode<T> last;
    private int size;

    // no constructor necessary bc things will automatically be init to null and 0


    public int size(){
		return size;
    }

    public T get(int index){
    	if(index < 0 || index > size)
    		return null;
		LNode<T> current = start;
		for(int i = 0; i < index; i++){
		    current = current.getNext();
		}
		return current.getData();
    }

    public T set(int index, T val){
		LNode<T> current = start;
		for(int i = 0; i < index; i++){
		    current = current.getNext();
		}
		if (index == size - 1)
			last = current;
		return current.setData(val);
    }

    public boolean add(T value){
		if(start==null){
		    start = new LNode<T>(value);
		    last = start;
		}else{
		    LNode<T> Next = new LNode<T>(value);
		    last.setNext(Next);
		    last = Next;
		    
		}
		size++;
		return true;
    }

    public boolean add(int index,T value){
    	if(index < 0 || index > size)
    		return false;
    	LNode<T> temp = new LNode<T>(value);
		if (index == size)
			return add(thing);
		if (index == 0){
			temp.setNext(start);
			start = temp;
			return true;
		}
		LNode<T> current = start;
		for(int i = 1; i < index; i++){
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
		return true;
    }

    public T remove(int index){
    	if(index < 0 || index > size)
    		return null;
    	if (index == 0){
    		T removed = start.getData();
    		start = start.getNext();
    		size --;
    		return ret;
    	}
		LNode<T> current = start;
		for(int i = 1; i < index; i++){
			current = current.getNext();
		}
		LNode<T> temp = current.getNext();
		current.setNext(temp.getNext());
		size--;
		return temp.getData();
    }

    public int indexOf(T value) {
        int index = 0;
        LNode<T> current = start;
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
        LNode<T> current = start;
        while (current != null) {
            if (current.getData() == value) {
                return true;
            }
            index++;
            current = current.getNext();
        }
        return false;
    }

    public void clear(){
    	size = 0;
    }
  
    public boolean isEmpty(){
    	return start == null || size == 0;
    }

    public String toString(){
    	if (isEmpty()){
        	return "[ ]";
        }
		String output = "[";
		LNode<T> current = start;
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
