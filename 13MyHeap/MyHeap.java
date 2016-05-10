import java.util.Arrays;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    public T[] array;
    public int size = 0;
    public boolean isMax;
    
    /**
     * Constructs a new MyHeap.
     */
    public MyHeap(){
        array = (T[])new Comparable[DEFAULT_CAPACITY];
        size = 0;
        isMax = true;
    }

    public MyHeap(boolean max){
        array = (T[])new Comparable[DEFAULT_CAPACITY];
        size = 0;
        isMax = max;
    }

    public MyHeap(T[] data){
        size = 0;
        isMax = true;
        array = (T[])new Comparable[DEFAULT_CAPACITY];
        heapify(data);
    }

    private void heapify(T[] data){
        for (T i : data){
            add(i);
        }
    }
    
    private boolean compare(int n) {
        if (isMax) {
            return n < 0;
        }
        return n > 0;
    }
    
    public void add(T value) {
        // grow array if needed
        if (size >= array.length - 1) {
            doubleSize();
        }        
        
        // place element into heap at bottom
        size++;
        int index = size;
        array[index] = value;
        
        pushUp();
    }
    
    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        
        return array[1];
    }

    public T delete() {
        // what do want return?
        T result = peek();
        
        // get rid of the last leaf/decrement
        array[1] = array[size];
        array[size] = null;
        size--;
        
        pushDown();
        
        return result;
    }
    
    
    public String toString() {
        return Arrays.toString(array);
    }

    
    public void pushDown() {
        int index = 1;
        
        // push down
        while (hasLeftChild(index)) {
            // which of my children is smaller?
            int smallerChild = leftIndex(index);
            
            // push with the smaller child, if I have a smaller child
            if (hasRightChild(index) && compare(array[leftIndex(index)].compareTo(array[rightIndex(index)]))) {
                smallerChild = rightIndex(index);
            } 
            
            if (compare(array[index].compareTo(array[smallerChild]))) {
                swap(index, smallerChild);
            } else {
                // otherwise, get outta here!
                break;
            }
            
            // make sure to update loop counter/index of where last el is put
            index = smallerChild;
        }        
    }
    
    
    public void pushUp() {
        int index = this.size;
        
        while (hasParent(index)
                && (compare(parent(index).compareTo(array[index])))) {
            // parent/child are out of order; swap them
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }        
    }
    
    
    public boolean hasParent(int i) {
        return i > 1;
    }
    
    
    public int leftIndex(int i) {
        return i * 2;
    }
    
    
    public int rightIndex(int i) {
        return i * 2 + 1;
    }
    
    
    public boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }
    
    
    public boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }
    
    
    public T parent(int i) {
        return array[parentIndex(i)];
    }
    
    
    public int parentIndex(int i) {
        return i / 2;
    }
    
    
    public void doubleSize() {
        array = Arrays.copyOf(array, array.length * 2);
    }
    
    
    public void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;        
    }
}