public class Rider implements Runnable {
    int waitingNumber;
    
    public void run() {
        try {
            SharedResources.multiplex.acquire();
        
            SharedResources.mutex.acquire();
            SharedResources.riders++;
            SharedResources.riderId++;
            waitingNumber = SharedResources.riderId;
            System.out.println("Rider " + waitingNumber + " has entered. Total waiting riders: " + SharedResources.riders);
            SharedResources.mutex.release();

            SharedResources.bus.acquire();
            SharedResources.multiplex.release();

            boardBus();

            SharedResources.riders--;

            if (SharedResources.riders == 0) {
                SharedResources.allAboard.release();
            }

            else {
                SharedResources.bus.release();
            }
            
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void boardBus() {
       System.out.println("Rider " + waitingNumber + " has boarded the bus.");
    }
}
