public class Main {
    public static void main(String[] args)  {
        try {
            System.out.println(Calculator.calculate("(1 - (1)) - (1) - (1 - 1)"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
