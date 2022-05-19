package tutorial;

public class CatchBlockSecond implements AutoCloseable {
    public CatchBlockThird createThird() {
        System.out.println("create third");
        return new CatchBlockThird();
    }

    @Override
    public void close() throws Exception {
        System.out.println("second close");
    }
}
