package Lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {
    int counter;
    ReentrantLock reLock = new ReentrantLock(true);

    public void incrementCounter() {
        reLock.lock();
        try {
            counter += 1;
        } finally {
            System.out.print(counter + " ");
            reLock.unlock();
        }
    }

}
