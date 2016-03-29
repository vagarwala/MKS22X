public class ParenDemo{
    public static boolean isMatching(String str){
        if (str.isEmpty())
            return true;
        MyStack<Character> stack = new MyStack<Character>();
        for (int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            if (current == '{' || current == '(' || current == '['){
                stack.push(current);
            }
            if (current == '}' || current == ')' || current == ']'){
                if (stack.isEmpty())
                    return false;
                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                    stack.pop();
                else 
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        String input = "";
        if(args.length > 0)
            input = args[0];
        System.out.println(isMatching(input));
    }
}