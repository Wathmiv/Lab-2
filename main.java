import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------Program started-------");
        RiderProvider riderProvider = new RiderProvider();
        BusProvider busProvider = new BusProvider();

        Thread riderProviderThread = new Thread(riderProvider);
        Thread busProviderThread = new Thread(busProvider);

        riderProviderThread.start();
        busProviderThread.start();

        while (true) {
            try {
                int terminateCommand = System.in.read();
                if(terminateCommand != 0) {
                    System.out.println("---------Program terminated-------");
                    System.exit(0);
                }
            } catch ( IOException e) {
                e.printStackTrace();
            }
        }
    }
}
