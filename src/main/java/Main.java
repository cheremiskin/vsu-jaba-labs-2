public class Main {
    public static void main(String[] args)  {
        try {
            System.out.println(Calculator.calculate("x + y^x * 4"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
