import java.util.Arrays;

public class MyHeap<T extends Comparable<T>>{
    private static final int DEFAULT_CAPACITY = 10;
    public T[] array;
    public int size;
    public boolean isMax;
    
    //Constructor
    @SuppressWarnings("unchecked")
	public MyHeap(){
        this(true);
    }
    public MyHeap(T[] array){
        this(true);
        this.array = array;
        heapify();
    }

    public MyHeap(boolean max){
        array = (T[])new Comparable[10];
        array[0]=null;
        size=0;
        isMax=max;
    }

    private boolean compare(T t1, T t2){
        if(isMax){
            return t1.compareTo(t2)>=0;
        }else{
            return t1.compareTo(t2)<=0;
        }
    }

    //make existing array into a heap array
    private void heapify(){
        size=array.length;
        array = this.resize();
        array[size]=array[0];
        array[0]=null;
        for(int i = size/2;i>0;i--){
            bubbleDown(i);
        }
    }
    
    
    //add a value
    public void add(T value) {
        // grow array if needed
        if (size >= array.length - 1) {
            array = this.resize();
        }        
        // place element into heap at bottom
        size++;
        int index = size;
        array[index] = value;
        //push it up to where it should be
        bubbleUp(size);
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    //max element in the heap (root)
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        
        return array[1];
    }

    
    //removes (and returns) root
    public T remove(){
        T result = peek();
        array[1]=array[size];
        bubbleDown(1);
        size--;
        return result;
    }    
    
    public String toString() {
        return Arrays.toString(array);
    }

    
    //put the root in its proper place
    private void bubbleDown(int k){
        if((k<size/2)&& !(compare(array[k],array[leftIndex(k)])&&(compare(array[k],array[rightIndex(k)])))){
            if(compare(array[leftIndex(k)],array[rightIndex(k)])){
                swap(leftIndex(k),k);
                bubbleDown(leftIndex(k));
            }else{
                swap(rightIndex(k),k);
                bubbleDown(rightIndex(k));
            }
        }
    }
    
    
    //put the newly inserted element in its place
    private void bubbleUp(int k){
        if((hasParent(k))&&(compare(array[k],array[parentIndex(k)]))){
            swap(parentIndex(k),k);
            bubbleUp(parentIndex(k));
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
    
    
    public T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }
    
    
    public void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;        
    }   
}