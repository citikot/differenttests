package online.agatstudio.atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    /*
    AtomicInteger — это класс из пакета java.util.concurrent.atomic, который обеспечивает
    атомарные операции над целыми числами без использования synchronized.

    Все операции (incrementAndGet, decrementAndGet, compareAndSet) выполняются потокобезопасно
    благодаря низкоуровневым механизмам процессора (CAS — Compare-And-Swap).

    • Потокобезопасный счётчик без блокировок
    • Быстрее, чем synchronized
    • Подходит для высоконагруженных многопоточных систем

👀   AtomicInteger особенно полезен при подсчёте событий, генерации ID или создании
     неблокирующих структур данных, где важна скорость и потокобезопасность без тяжёлых блокировок.
    */

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {
        }

        System.out.println("Результат: " + counter.get());
    }
}

