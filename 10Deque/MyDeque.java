import java.util.*;

public class MyDeque<T>{
   protected int size;  // size
   protected int front;     // index of the front element
   protected int rear;      // index of the rear element
   protected T[] A;       // array deque

   @SuppressWarnings("unchecked")
   public MyDeque(){
      A = (T[]) new Object[10];
   }


    /**
     * Print only the content of the deque
     *
     */
    public String printDeque(){
        int i = front;
        String retStr="";
        while(i!=rear){
            retStr+=A[i] + " ";
            i = (i+1)%(A.length - 1);
        }
        retStr+=A[i];
        return retStr;
    }


    /**
     * Print the content of the whole array
     *
     */
    public void printArray(){
        for ( int i = 0; i < A.length; i++ )
           System.out.print( A[i].toString() + " " );
        System.out.println();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T getFirst(){
        if(size()==0){
            throw new NoSuchElementException();
        }
        return A[front]; 
    }

    public T getLast(){
        if(size()==0){
            throw new NoSuchElementException();
        }
        return A[rear]; 
    }

    @SuppressWarnings("unchecked")
    private void grow(){
        T[] newData = (T[])new Object[A.length*2];
        int i = front;
        int index = 0;
        while(i!=rear){
            newData[index]=A[i];
            i = (i+1)%(A.length);
            index++;
        }
        newData[index]=A[rear];
        front=0;
        rear=index;
        A=newData;
    }

    public void addFirst(T e){
        if(size() == A.length){
            grow();
        }
        front = (A.length + front - 1)%(A.length);
        if (size() == 0){
            front = 0;
            rear = 0;
        }
        A[front] = e;
        size++;
    }
    
    public void addLast(T e){
        if(size() == A.length)
            grow();
        rear = (rear+1)%(A.length);
        if (size() == 0)
            front = rear = 0;
        A[rear] = e;
        size++;

    }
    @SuppressWarnings("unchecked")
    public T removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        T result = A[front];
        front = (front+1)%(A.length);
        size --;
        return result;
    }
    @SuppressWarnings("unchecked")
    public T removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        T temp = A[rear];
        rear = (A.length + rear - 1)%(A.length);
        size--;
        return temp;
    }

    public static void main(String[]args) {
        MyDeque<Integer> m = new MyDeque<>();
        m.addFirst(3);
        m.addFirst(2);
        m.addLast(4);
        m.printDeque();
        m.addLast(5);
        m.addLast(6);
        m.addLast(7);
        m.addLast(8);
        m.addLast(9);
        m.addLast(10);
        m.addFirst(1);
        m.addFirst(0);
        m.printDeque();
        m.removeFirst();
        m.printDeque();
        m.removeLast();
        m.printDeque();
        
    }
}