package HW3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongLock{
    public static Map<String, Integer> counter = new HashMap<String, Integer>();


    public static void main(String[] args) {
        final var games = 5;
        new Thread(() -> myPlay("Ping", games)).start();
        new Thread(() -> myPlay(" Pong", games)).start();
    }

    private static void myPlay(String name, int games) {
        final Lock lock = new ReentrantLock();
        Integer ai = 0;
        while (true) {
                lock.lock();
                System.out.println(name);
                ai++;
                counter.put(name, ai);
                try {
                    if (--games == 0) {
                        break;
                    }
                } finally {
                    lock.unlock();
                }
        }
        System.out.println(counter);
    }

//    результат:
//    Ping
//    Ping
//    Ping
//    Ping
//    Ping
//    {Ping=5}
//    Pong
//    Pong
//    Pong
//    Pong
//    Pong
//    { Pong=5, Ping=5}
}
