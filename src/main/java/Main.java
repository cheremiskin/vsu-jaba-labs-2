public class Main {
    public static void main(String[] args)  {
        try {
            System.out.println(Calculator.calculate("x + y * x"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
