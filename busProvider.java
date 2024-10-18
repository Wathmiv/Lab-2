import java.util.Random;

public class BusProvider implements Runnable{
    public static Random rand;

    public BusProvider(){
        rand = new Random();
    }

    public void run(){
        while (true){
            Bus bus = new Bus();
            Thread busThread = new Thread(bus);

            busThread.start();

            try{
                float meanArrivalTime = 60000f;
                float lambda = 1 / meanArrivalTime;
                Thread.sleep(Math.round(-Math.log(1 - rand.nextFloat()) / lambda));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
    
}
