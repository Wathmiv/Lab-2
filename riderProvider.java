import java.util.Random;

public class RiderProvider implements Runnable{
    public static Random rand;

    public RiderProvider(){
        rand = new Random();
    }

    public void run(){
        while (true){
            Rider rider = new Rider();
            Thread riderThread = new Thread(rider);

            riderThread.start();

            try{
                float meanArrivalTime = 1000f; // 30 sec
                float lambda = 1 / meanArrivalTime;
                Thread.sleep(Math.round(-Math.log(1 - rand.nextFloat()) / lambda));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }


    
}
