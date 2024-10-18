public class Bus implements Runnable {

    public void run(){
        try {
            SharedResources.mutex.acquire();
            System.out.println("Bus arrived.");

            if (SharedResources.riders > 0) {
                System.out.println(SharedResources.riders + " riders are boarding.");
                SharedResources.bus.release();
                SharedResources.allAboard.acquire();
            }
            SharedResources.mutex.release();
            depart();

        }
            
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void depart() {
        System.out.println("Bus departed");
    }
    
}