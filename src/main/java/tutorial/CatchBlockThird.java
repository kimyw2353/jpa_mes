package tutorial;

public class CatchBlockThird implements AutoCloseable {
    public void run() {
        System.out.println("catch block run");
    }

    @Override
    public void close() throws Exception {
        System.out.println("third close");
    }
}
