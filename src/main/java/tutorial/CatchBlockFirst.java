package tutorial;

public class CatchBlockFirst {
    public CatchBlockFirst() {
        System.out.println("create first");
    }

    public CatchBlockSecond createSecond() {
        System.out.println("create second");
        return new CatchBlockSecond();
    }
}
