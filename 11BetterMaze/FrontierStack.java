import java.util.*;
public class FrontierStack<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    private MyStack<T> s;

    public FrontierStack() {
		s = new MyStack<T>();
    }

    public void add(T value) {
		s.push(value);
    }

    public T next() {
		if (s.isEmpty()) {
			throw new NoSuchElementException();
		}
		return s.pop();
    }

    public boolean hasNext() {
        return (!s.isEmpty());
    }

}