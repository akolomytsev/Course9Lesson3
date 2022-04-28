package Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    public static void main(String[] args) {
        ReentrantLockCounter e = new ReentrantLockCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0;i<100;i++) {
            e.incrementCounter();
        }
    }

}
