import java.util.Map;

public class BracketChecker {

    public static boolean isBalanced(String expression) {
        MyStack<Character> stack = new MyStack<>();
        Map<Character, Character> pairs = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );

        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {

                stack.push(c);
            } else if (pairs.containsKey(c)) {

                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (top != pairs.get(c)) {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }
}