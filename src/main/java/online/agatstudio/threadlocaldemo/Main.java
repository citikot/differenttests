package online.agatstudio.threadlocaldemo;

public class Main {

    private static final ThreadLocal<Integer> threadId =
            ThreadLocal.withInitial(() -> (int) (Math.random() * 1000));

    public static void main(String[] args) {
        Runnable task = () ->
                System.out.println(Thread.currentThread().getName() + " → " + threadId.get());

        new Thread(task, "Поток-1").start();
        new Thread(task, "Поток-2").start();
        new Thread(task, "Поток-3").start();
    }
}

