import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    MyQueue<T> q;

    public FrontierQueue() {
        q = new MyQueue<T>();
    }

    public void add(T value) {
        q.enqueue(value);
    }

    public T next() {
        if (q.isEmpty()) {
            throw new NoSuchElementException();
        }
        return q.dequeue();
    }

    public boolean hasNext() {
        return (!q.isEmpty());
    }

}