public class Main {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(5);
        System.out.println("size = " + list.size());
        System.out.println("contains 20 = " + list.contains(20));
        list.removeFirst();
        System.out.println("after removeFirst size = " + list.size());
        for (int v : list) System.out.print(v + " ");
        System.out.println();


        MyStack<String> stack = new MyStack<>();
        stack.push("a");
        stack.push("b");
        System.out.println("peek = " + stack.peek());
        System.out.println("pop = " + stack.pop());
        System.out.println("size = " + stack.size());


        System.out.println(BracketChecker.isBalanced("(a + b) * [c - d]"));
        System.out.println(BracketChecker.isBalanced("{[()()]}"));
        System.out.println(BracketChecker.isBalanced("([)]"));
        System.out.println(BracketChecker.isBalanced("((a + b)"));
        System.out.println(BracketChecker.isBalanced(""));


        System.out.println(ExpressionEvaluator.evaluate("3 + 4 * 2"));
        System.out.println(ExpressionEvaluator.evaluate("(3 + 4) * 2"));
        System.out.println(ExpressionEvaluator.evaluate("10 / 2 - 3"));
        System.out.println(ExpressionEvaluator.evaluate("2 * (3 + (4 - 1))"));
        try {
            ExpressionEvaluator.evaluate("5 / 0");
        } catch (ArithmeticException e) {
            System.out.println("Поймали: " + e.getMessage());
        }
    }
}
