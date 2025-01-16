package online.agatstudio.multithread.demo;

import static online.agatstudio.multithread.demo.Main.globalCounter;

public class MyThread1 extends Thread {

    private int counter;
    private String name;

    MyThread1 (String name) {
        this.name = name;
    }

    @Override
    public void run() {

        try {
            do {
                counter++;
                globalCounter++;
                Thread.sleep(200);
                System.out.println("Thread: "+ name + " Counter: " + counter + " GlobalCounter: " + globalCounter);
            } while (counter < 20);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
