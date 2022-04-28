package PingPong;

public class Main {
    static final Object mon = new Object();
    static volatile String currentString = "Ping";
    static final int num = 50;

    public static void main(String[] args) {
        new Thread(() -> {
            try{
                for (int i = 0; i < num; i++) {
                    synchronized (mon){
                        while(!currentString.equals("Ping")){
                            mon.wait();
                        }
                        System.out.println("Ping");
                        currentString = "Pong";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try{
                for (int i = 0; i < num; i++) {
                    synchronized (mon){
                        while(!currentString.equals("Pong")){
                            mon.wait();
                        }
                        System.out.println("Pong ");
                        currentString = "Ping";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
