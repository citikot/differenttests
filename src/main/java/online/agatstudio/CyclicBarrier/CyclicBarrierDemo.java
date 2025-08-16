package online.agatstudio.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
CyclicBarrier — это синхронизатор из пакета java.util.concurrent,
который позволяет группе потоков дождаться друг друга, прежде чем продолжить выполнение.

В отличие от CountDownLatch, барьер можно использовать многократно — после того как все
потоки достигли точки синхронизации, он сбрасывается и готов к новому циклу.

• Синхронизирует несколько потоков в «точках встречи»
• Можно выполнять дополнительное действие при достижении барьера
• Подходит для повторяющихся этапов работы в параллельных задачах

CyclicBarrier особенно полезен, когда несколько потоков должны синхронизировать свои шаги — например,
в параллельных алгоритмах, симуляциях, или играх с одновременным обновлением состояния.
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () ->
                System.out.println("Все потоки достигли барьера, продолжаем!")
        );

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " готов");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " продолжает работу");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        new Thread(task, "Поток 1").start();
        new Thread(task, "Поток 2").start();
        new Thread(task, "Поток 3").start();
    }
}


