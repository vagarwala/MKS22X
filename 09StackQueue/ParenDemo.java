public class ParenDemo{
    /*
    public static boolean isMatching(String str){
        if (str.isEmpty())
            return true;
        MyStack<Character> stack = new MyStack<Character>();
        for (int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            if (current == '{' || current == '(' || current == '[' || current == '<'){
                stack.push(current);
            }
            if (current == '}' || current == ')' || current == ']' || current == '>'){
                if (stack.isEmpty())
                    return false;
                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[' || current == '>' && last == '<')
                    stack.pop();
                else 
                    return false;
            }
        }
        return stack.isEmpty();
    }
    */
    public static boolean isMatching(String input) {

        char [] openChars =  {'[','{','('};
        char [] closeChars = {']','}',')'};

        MyStack<Character> stack = new MyStack<Character>();

        for (int i = 0; i < input.length(); i++) {

            String x = "" +input.charAt(i);

            if (String.valueOf(openChars).indexOf(x) != -1)
                stack.push(input.charAt(i));
            else{
                Character lastOpener = stack.peek();
                int idx1 = String.valueOf(openChars).indexOf(lastOpener.toString());
                int idx2 = String.valueOf(closeChars).indexOf(x);

                if (idx1 != idx2)
                    return false;
                else
                    stack.pop();
            }
        }

        if (stack.size() == 0)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        String input = "";
        if(args.length > 0)
            input = args[0];
        System.out.println(isMatching(input));
    }
}