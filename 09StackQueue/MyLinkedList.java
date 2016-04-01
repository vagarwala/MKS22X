import java.util.*;

public class MyLinkedList<T> implements Iterable<T> {

    private class LNode {
        T data;
        LNode next;
        LNode previous;
        
        public LNode(){

        }
        public LNode(T value){
            data = value;
        }

        public LNode getNext(){
            return next;
        }
        public LNode getPrevious(){
            return previous;
        }
        public T getData(){
            return data;
        }
        public void setData(T value){
            data = value;
        }
        public void setNext(LNode l){
            next = l;
        }
        public void setPrevious(LNode l){
            previous = l;
        }
    }


    public Iterator<T>iterator() {
        return new MyLinkedListIterator();
    }

    public class MyLinkedListIterator implements Iterator<T> {
        private LNode current;

        public MyLinkedListIterator() {
        }
        
        public boolean hasNext() {
            if (current == null) {
                return true;
            }
            return current.getNext() != null;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            if (current == null)
                current = start;
            else {
                current = current.getNext();        
            }
            return current.getData();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private LNode start;
    private int size;
    private LNode last;

    public MyLinkedList() {
        size = 0;
    }

    public boolean add(T value) {
        if (size == 0) {
            start = new LNode(value);
            last = start;
        }
        else {
            last.setNext(new LNode(value));
            last.getNext().setPrevious(last);
            last = last.getNext();
        }
        size++;
        return true;
    }

    public boolean add(int index, T value) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
        else if (index == 0) {
            LNode temp = start;
            start = new LNode(value);
            temp.setPrevious(start);
            start.setNext(temp);
            size++;
        }
        else if (index == size) {
            return add(value);
        }
        else {
            LNode current = start;
            for (int i = 0; i < index-1; i++)
                current = current.getNext();
            LNode temp = current.getNext();
            current.setNext(new LNode(value));
            temp.setPrevious(current.getNext());
            current.getNext().setPrevious(current);
            current.getNext().setNext(temp);
            size++;
        }
        return true;
    }
    
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        LNode current = start;
        for (int i = 0; i < index; i++)
            current = current.getNext();
        return current.getData();
    }

    public int size() {
        return size;
    }


    public T set(int index, T newValue) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        LNode current = start;
        for (int i = 0; i < index; i++)
            current = current.getNext();
        T temp = current.getData();
        current.setData(newValue);
        return temp;
    }
    
    public T remove(int index) {
        if (index >= size || index < 0 )
            throw new IndexOutOfBoundsException();
        else if (index == 0) {
            T temp = start.getData();
            start = start.getNext();
            size--;
            if (size > 0)
                start.setPrevious(null);
            return temp;
        }
        else if (index == size-1) {
            T temp = last.getData();
            last = last.getPrevious();
            size--;
            return temp;
        }
        else {
            LNode current = start;
            T temp = current.getData();
            for (int i = 0; i < index-1; i++)
                current = current.getNext();
            temp = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            current.getNext().setPrevious(current);
            size--;
            return temp;
        }
    }

    public int indexOf(T value) {
        LNode current = start;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(value))
                return i;
            else
                current = current.getNext();
        }
        return -1;
    }
    
    public String toString(){
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

}