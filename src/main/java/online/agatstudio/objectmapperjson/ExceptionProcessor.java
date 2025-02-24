package online.agatstudio.objectmapperjson;

import java.util.Scanner;

public class ExceptionProcessor {

    public static void main(String[] args) {

        boolean working = true;

        while (working) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("введите целое число: ");
                int num = scanner.nextInt();
                String formattedString = String.format("вывод: %d %n", num * 2);
                System.out.println(formattedString);
                working = false;
            } catch (RuntimeException e) {
                System.out.println("введено не число, попробуйте еще раз! " + e);
            } finally {
                if (!working) {
                    System.out.println("Программа закончила выполнение успешно!");
                } else {
                    System.out.println("Переход к следующей попытке.");
              }
            }
        }
    }
}
