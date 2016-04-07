import java.util.*;
public class Postfix{
    static int evalPf(String str){
        Scanner sc = new Scanner(str);
        MyStack<Integer> stack = new MyStack<Integer>();

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                stack.push(sc.nextInt());
                continue;
            }
            int b = stack.pop();
            int a = stack.pop();
            char op = sc.next().charAt(0);
            if      (op == '+') stack.push(a + b);
            else if (op == '-') stack.push(a - b);
            else if (op == '*') stack.push(a * b);
            else if (op == '/') stack.push(a / b);
            else if (op == '%') stack.push(a % b);
        }
        sc.close();
        return stack.pop();
    }
    public static void main(String[] args){
        System.out.println(evalPf("3 4 + 7 * 1 -"));
    }
}