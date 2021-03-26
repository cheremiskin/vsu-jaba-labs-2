import java.sql.Array;
import java.util.*;

public class Calculator {
    private static StringBuilder exp = new StringBuilder();
    private static Stack<Double> values = new Stack<>();
    private static Stack<Character> operators = new Stack<>();

    private static final Map<Character, Integer> priorities = new HashMap<>();
    private static Map<Character, Double> variables = new HashMap<>();

    static {
        priorities.put('(', -1);
        priorities.put(')', 100);
        priorities.put('+', 2);
        priorities.put('-', 2);
        priorities.put('*', 1);
        priorities.put('/', 1);
        priorities.put('^', 0);
    }

    /**
     * <h3>Обрабатывает следующий токен</h3>
     */
    private static void readNextToken() throws Exception {
        char startToken = exp.charAt(0);

        int endTokenPos = 1;
        boolean wasDot = false;

        if (isOperator(startToken)) {
            while (!operators.empty() && priorities.get(startToken) > priorities.get(operators.peek())) {
                if (operators.peek() != '(') {
                    double v2 = values.pop();
                    double v1 = values.pop();
                    values.push(executeOperation(v1, v2, operators.pop()));
                } else {
                    operators.pop();
                }
            }
            operators.push(startToken);
        } else if (isDigit(startToken)) {
            while (isDigit(exp.charAt(endTokenPos)) || exp.charAt(endTokenPos) == '.' && !wasDot) {
                if (exp.charAt(endTokenPos) == '.') wasDot = true;
                endTokenPos++;
            }
            values.push(Double.parseDouble(exp.substring(0, endTokenPos)));
        }
        else if (isVariable(startToken)) {
            if (variables.containsKey(startToken)) {
                values.push(variables.get(startToken));
            } else {
                System.out.println("Enter '"+ startToken + "': ");
                Scanner in = new Scanner(System.in);
                double num = Double.parseDouble(in.nextLine());
                variables.put(startToken, num);
                values.push(num);
            }
        } else if (startToken != ' ') {
            throw new Exception("Unknown symbol:" + startToken);
        }
        exp.delete(0, endTokenPos);
    }

    /**
     * <h3>Выполнение заданой операции</h3>
     * @param v1 - первый операнд
     * @param v2 - второй операнд
     * @param operator - оператор
     */
    private static double executeOperation(double v1, double v2, char operator) throws Exception {
        switch (operator) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                return v1 / v2;
            case '^':
                return Math.pow(v1, v2);
            default:
                throw new Exception("Unknown operation");
        }
    }

    /**
     * <h3>Вычисляет значение выражения</h3>
     * @param expression - выражение, значение которого нужно вычислить
     */
    public static double calculate(String expression) throws Exception {
        exp = new StringBuilder('(' + expression + ')');

        while (exp.length() > 0) {
            readNextToken();
        }

        if (values.size() > 1 || operators.size() > 1) {
            throw new Exception("Unable to calculate expression");
        }

        return values.pop();
    }

    /**
     * <h3>Проверяет является ли символ операцией</h3>
     * @param symbol который нужно проверить
     */
    private static boolean isOperator(char symbol) {
        return priorities.containsKey(symbol);
    }

    /**
     * <h3>Проверяет является ли символ цифрой</h3>
     * @param symbol который нужно проверить
     */
    private static boolean isDigit(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }

    /**
     * <h3>Проверяет является ли символ переменной</h3>
     * @param symbol который нужно проверить
     */
    private static boolean isVariable(char symbol) {
        return symbol >= 'a' && symbol <= 'z' || symbol >= 'A' && symbol <='Z';
    }
}
