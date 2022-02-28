package edu.escuelaing.arep.threads;

public class Friend {
    private String name;
    private Object bowBackLock = new Object();


    public Friend(String name){
        this.name = name;
    }

    public static void main(String[] args){
        Friend pedro = new Friend("Pedro");
        Friend julian = new Friend("Julian");

        new Thread(new Runnable() {
            @Override
            public void run() {
                pedro.bow(julian);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                julian.bow(pedro);
            }
        }).start();
    }

    public synchronized void bow(Friend f){
        System.out.format("%s: %s me saludo %n", name, f.getName());
        f.bow(this);
    }

    public void bowBack(Friend f) {
        synchronized (bowBackLock) {
            System.out.format("%s: %s me devolvio el saldudo %n", name, f.getName());
        }
    }

    public String getName(){
        return name;
    }
}
