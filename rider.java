public class Rider implements Runnable {
    int waitingNumber;
    
    public void run() {
        try {
            SharedResources.multiplex.acquire();
        
            SharedResources.mutex.acquire();
            SharedResources.riders++;
            waitingNumber = SharedResources.riders;
            SharedResources.mutex.release();

            System.out.println("Rider " + waitingNumber + " is waiting for the bus.");

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
