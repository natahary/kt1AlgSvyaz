public class ExpressionEvaluator {

    public static double evaluate(String expression) {
        MyStack<Double> numbers = new MyStack<>();
        MyStack<Character> operators = new MyStack<>();

        int i = 0;
        int n = expression.length();

        while (i < n) {
            char c = expression.charAt(i);


            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }


            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < n && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                numbers.push(Double.parseDouble(sb.toString()));
                continue;
            }


            if (c == '(') {
                operators.push(c);
                i++;
                continue;
            }


            if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    applyTopOperator(numbers, operators);
                }
                if (operators.isEmpty()) {
                    throw new IllegalArgumentException("Несбалансированные скобки");
                }
                operators.pop();
                i++;
                continue;
            }


            if (c == '+' || c == '-' || c == '*' || c == '/') {

                while (!operators.isEmpty()
                        && operators.peek() != '('
                        && priority(operators.peek()) >= priority(c)) {
                    applyTopOperator(numbers, operators);
                }
                operators.push(c);
                i++;
                continue;
            }

            throw new IllegalArgumentException("Недопустимый символ: " + c);
        }


        while (!operators.isEmpty()) {
            applyTopOperator(numbers, operators);
        }

        if (numbers.size() != 1) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        return numbers.pop();
    }


    private static int priority(char op) {
        if (op == '*' || op == '/') return 2;
        return 1;
    }


    private static void applyTopOperator(MyStack<Double> numbers, MyStack<Character> operators) {
        char op = operators.pop();
        double b = numbers.pop();
        double a = numbers.pop();

        double result;
        switch (op) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/':
                if (b == 0.0) {
                    throw new ArithmeticException("Деление на ноль в выражении");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + op);
        }
        numbers.push(result);
    }
}