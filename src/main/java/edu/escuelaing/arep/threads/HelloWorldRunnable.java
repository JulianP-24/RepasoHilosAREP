package edu.escuelaing.arep.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloWorldRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello world from runnable object: " + Thread.currentThread());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 100;
        ExecutorService pool = Executors.newFixedThreadPool(10);
        while (n > 0) {
            pool.submit(new HelloWorldRunnable());
            n = n-1;
            //Thread t = new Thread(new HelloWorldRunnable());
            //t.start();
        }
        //t.join();
        System.out.println("Hello from main: " + Thread.currentThread());
    }
}
