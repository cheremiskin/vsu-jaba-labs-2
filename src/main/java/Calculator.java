import java.sql.Array;
import java.util.*;

public class Calculator {
    private static StringBuilder exp = new StringBuilder();
    private static Stack<Double> values = new Stack<>();
    private static Stack<Character> operators = new Stack<>();
    public static final Map<Character, Integer> priorities = new HashMap<>();
    static {
        priorities.put('(', -1);
        priorities.put(')', 100);
        priorities.put('+', 2);
        priorities.put('-', 2);
        priorities.put('*', 1);
        priorities.put('/', 1);
    }

    private static void readNextToken() {
        char startToken = exp.charAt(0);

        int endTokenPos = 1;
        boolean wasDot = false;

        if (isOperator(startToken)) {
            operators.push(startToken);
        } else if (isDigit(startToken)) {
            while (isDigit(exp.charAt(endTokenPos)) || exp.charAt(endTokenPos) == '.' && !wasDot) {
                if (exp.charAt(endTokenPos) == '.') wasDot = true;
                endTokenPos++;
            }

            values.push(Double.parseDouble(exp.substring(0, endTokenPos)));
        }

        exp.delete(0, endTokenPos);
    }

    public static double calculate(String expression) {
        exp = new StringBuilder(expression);

        exp.insert(0, '(');
        exp.append(')');

        while (exp.length() > 0) {
            readNextToken();
        }

        System.out.println(values);
        System.out.println(operators);

        return 1.1;
    }

    private static boolean isOperator(char symbol) {
        return priorities.containsKey(symbol);
    }

    private static boolean isDigit(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }
}
