public class MyLinkedList{

    private class LNode{
		int value;
		LNode next;

		public LNode(int val){
		    value = val;
		    next = null;
		}

		public LNode(int _val, LNode _next){
	        next = _next;
	        value = _val;
	    }

	    public int getData(){
		    return value;
		}

		public void setData(int val){
		    value = val;
		}

		public LNode getNext(){
		    return next;
		} 

		public void setNext(LNode Next){
		    next = Next;
		}
    }
    private LNode start;
    private LNode last;
    private int size;

    // no constructor necessary bc things will automatically be init to null and 0


    public int size(){
		return size;
    }

    public Object get(int index){
    	if(index < 0 || index > size)
    		return null;
		LNode current = start;
		for(int i = 0; i < index; i++){
		    current = current.getNext();
		}
		return current.getData();
    }

    public int set(int index, int val){
		LNode current = start;
		for(int i = 0; i < index; i++){
		    current = current.getNext();
		}
		int output = current.getData();
		current.setData(val);
		return output;
    }

    public boolean add(int value){
		if(start==null){
		    start = new LNode(value);
		    last = start;
		}else{
		    LNode Next = new LNode(value);
		    last.setNext(Next);
		    last = Next;
		    
		}
		size++;
		return true;
    }

    public boolean add(int index,int value){
    	if(index < 0 || index > size)
    		return false;
		LNode current = start;
		for(int i = 1; i < index; i++){
			current = current.getNext();
		}
		LNode temp = new LNode(value);
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
		return true;
    }

    public Object remove(int index){
    	if(index < 0 || index > size)
    		return null;
		LNode current = start;
		for(int i = 1; i < index; i++){
			current = current.getNext();
		}
		LNode temp = current.getNext();
		current.setNext(temp.getNext());
		size--;
		return temp.getData();
    }

    public int indexOf(int value) {
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

	public boolean contains(int value){
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
		LNode current = start;
		while(current != null){
	    	output += current.getData();
	    	if(current.getNext() != null){
				output += ", ";
	    	}
	    	current=current.getNext();
		}
		return output + "]";
    }

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
		
    }
   
}
