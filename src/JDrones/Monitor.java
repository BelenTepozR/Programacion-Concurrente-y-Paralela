package JDrones;

public class Monitor {
    private int contents=0;
    private boolean available = false;

    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        available = false;
        notifyAll();
        return contents;
    }

    public synchronized void put() {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        contents = 1;
        available = true;
        notifyAll();
    }
}