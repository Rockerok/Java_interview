package HW3;

public class PingPong3_1 {

    public static void main(String[] args) {
        final var games = 5;
        new Thread(() -> myPlay("Ping", games)).start();
        new Thread(() -> myPlay(" Pong", games)).start();
    }

    private static synchronized void myPlay(String name, int games) {
        while (true) {
            System.out.println(name);
            try {
                PingPong3_1.class.notify();
                if (--games == 0) {
                    break;
                } else {
                    PingPong3_1.class.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
