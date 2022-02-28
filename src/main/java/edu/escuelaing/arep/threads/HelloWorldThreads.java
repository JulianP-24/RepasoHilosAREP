package edu.escuelaing.arep.threads;

import java.util.LinkedList;
import java.util.List;

public class HelloWorldThreads extends Thread {

    static List<Thread> threadlist = new LinkedList<>();

    @Override
    public void run() {
        System.out.println("Hello world froma a thread object: " + this.toString());
    }
    public static void main(String[] args){
        int i = 5;
        while (i>0) {
            Thread t = (new HelloWorldThreads());
            threadlist.add(t);
            t.start();
            i = i-1;
        }
        System.out.println("Hello from main: " + Thread.currentThread().toString());
        for (Thread t : threadlist){
            System.out.println("Stack Trace" + t.getState());
        }
    }
}
