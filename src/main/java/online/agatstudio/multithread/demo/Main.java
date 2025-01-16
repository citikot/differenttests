package online.agatstudio.multithread.demo;

class Main {

    static int globalCounter;

    public static void main(String[] args) {

        MyThread1 myThread1 = new MyThread1("1");
        Runnable myThread2 = new MyThread2("2");
        Thread myThread21 = new Thread(myThread2);

        myThread1.start();
        myThread21.start();

    }

}
