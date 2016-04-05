import java.util.*;

public class MyDeque<T>{
   public static final int INIT_CAPACITY = 8;   // initial array capacity
   protected int capacity;  // current capacity of the array
   protected int front;     // index of the front element
   protected int rear;      // index of the rear element
   protected T[] A;       // array deque

   @SuppressWarnings("unchecked")
   public MyDeque(){
      A = (T[]) new Object[ INIT_CAPACITY ];
      capacity = INIT_CAPACITY;
      front = rear = 0;
   }


    /**
     * Print only the content of the deque
     *
     */
    public void printDeque(){
        for ( int i = front; i != rear; i = (i+1) % capacity )
            System.out.print( A[i].toString() + " " );
        System.out.println();
    }


    /**
     * Print the content of the whole array
     *
     */
    public void printArray(){
        for ( int i = 0; i < capacity; i++ )
           System.out.print( A[i].toString() + " " );
        System.out.println();
    }

    public int size(){
        return (capacity - front + rear) % capacity;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public T getFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return A[front % capacity]; 
    }

    public T getLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return A[(front + rear - 1) % capacity]; 
    }
    @SuppressWarnings("unchecked")
    private void grow(){
        T[] B = (T[]) new Object[capacity*2];
        for(int i = 0; i < size(); i++){
            B[i] = A[i];
        }
        A = B;
    }

    public void insertFirst(T e){
        rear++;
        if(size() == capacity - 1){
            grow();
        }
        for(int i = size(); i >= front; i--){
            A[i+1] = A[i];
        }
        A[front] = e;
        front = front % capacity;
    }
    @SuppressWarnings("unchecked")
    public void insertLast(T e){
        if(size() == capacity - 1) {
            capacity= capacity*2;
        }

        T[] B = (T[]) new Object[capacity];

        for(int i = 0; i < size(); i++) {
            B[i] = A[i];
        }

        A = B;

        A[rear] = e;
        rear = (rear + 1) % capacity;

    }
    @SuppressWarnings("unchecked")
    public T removeFirst(){
        T result = A[front];
        A[front] = null;
        front = (front+1)%capacity;

        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else if(capacity >= 8){
            if(size() < capacity/2){
                capacity /= 2;
                T[] B = (T[]) new Object[capacity];
                int counter=0;
                for(int i = front; i < front+size(); i++){
                    B[counter] = A[i%(capacity*2)];
                    counter++;
                }
                A = B;
                front = 0;
                rear = size()-1;
            }
        }
        return result;
    }
    @SuppressWarnings("unchecked")
    public T removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else if(capacity >= 4){
            if(size() < capacity/2){
                T[] B = (T[]) new Object[capacity/2];
                for(int i = 0; i < capacity/2; i++){
                    B[i] = A[i];
                }
                A = B;
            }
        }
        T temp = A[rear - 1];
        A[rear] = null;
        rear = (rear - 1) % capacity;
        return temp;
    }

    public static void main(String[]args) {
        MyDeque<Integer> m = new MyDeque<>();
        m.insertFirst(3);
        m.insertFirst(2);
        m.insertLast(4);
        m.printDeque();
        m.insertLast(5);
        m.insertLast(6);
        m.insertLast(7);
        m.insertLast(8);
        m.insertLast(9);
        m.insertLast(10);
        m.insertFirst(1);
        m.insertFirst(0);
        m.printDeque();
        m.removeFirst();
        m.printDeque();
        m.removeLast();
        m.printDeque();
        
    }
}