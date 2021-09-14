package fr.lille.alom;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Helloworld extends Thread {

    private Random random = new Random();
    private Map logs = new HashMap();
    private Long startTime;
    private String name;
    private boolean running = false;

    public Helloworld(Long startTime, String name) {
        this.startTime=startTime;
        this.name = name;
    }

    public Map getLogs() {
        return this.logs;
    }

    public void finish(){
        this.running = false;
    }

    public void run() {
        this.running = true;
        while(this.running) {
            this.logs.put((System.nanoTime()-startTime),"Thread ["+name+"]");
            if(random.nextInt(100) < 10) {
                this.logs.put((System.nanoTime()-startTime),"Thread ["+name+"] yield");
                yield();
            }
        }
    }
}