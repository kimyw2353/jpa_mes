package tutorial;

public class ExceptionHandlingSub {
    private static Integer getNumber() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        Integer number = getNumber();

        System.out.println(number);
    }
}
