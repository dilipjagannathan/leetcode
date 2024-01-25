import java.util.ArrayList;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()){
            if (c == ']') {
                ArrayList<Character> list = new ArrayList<>();
                while (stack.peek() != '[') {
                    list.add(stack.pop());
                }
                stack.pop();
                int base = 1;
                int k = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + base * (stack.pop() - '0');
                    base = base * 10;
                }

                while (k!=0) {
                    for (int i = list.size() - 1; i>=0; i--) {
                        stack.push(list.get(i));
                    }
                    k--;
                }
            } else {
                stack.push(c);
            }



        }

        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);

    }
}
