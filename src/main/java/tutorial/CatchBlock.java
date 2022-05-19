package tutorial;

public class CatchBlock {
    public static void main(String[] args) {
        CatchBlockFirst catchBlockFirst = new CatchBlockFirst();

        try (CatchBlockSecond catchBlockSecond = catchBlockFirst.createSecond();
             CatchBlockThird catchBlockThird = catchBlockSecond.createThird()){
            catchBlockThird.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
