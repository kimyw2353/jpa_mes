package tutorial;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int parseInt = Integer.parseInt("test");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.getMessage());
        }
    }
}
