import java.util.concurrent.Semaphore;

public class sharedResources {
    public static int riders=0;

    public static Semaphore mutex = new Semaphore(1);

    public static Semaphore multiplex = new Semaphore(50);

    public static Semaphore bus = new Semaphore(0);

    public static Semaphore allAboard = new Semaphore(0);

    
}
