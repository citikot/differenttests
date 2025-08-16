package online.agatstudio.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/*
CountDownLatch — это синхронизатор из пакета java.util.concurrent,
который позволяет одному или нескольким потокам ждать, пока другие потоки завершат свои задачи.

Он инициализируется счётчиком, и каждый вызов countDown() уменьшает его на 1.
Как только счётчик достигает нуля — все ожидающие потоки продолжают выполнение.

• Удобен для ожидания завершения группы потоков
• Позволяет синхронизировать старт или окончание работы
• Прост в использовании и потокобезопасен

CountDownLatch особенно полезен для синхронизации в тестах, многопоточных вычислениях
и в случаях, когда нужно дождаться инициализации нескольких компонентов перед стартом основной логики.
 */

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " завершил работу");
            latch.countDown();
        };

        new Thread(worker, "Поток 1").start();
        new Thread(worker, "Поток 2").start();
        new Thread(worker, "Поток 3").start();

        latch.await(); // ждём, пока счётчик не станет 0
        System.out.println("Все потоки завершили работу");
    }
}


