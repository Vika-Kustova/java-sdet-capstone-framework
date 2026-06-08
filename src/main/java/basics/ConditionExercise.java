package basics;

import java.util.Scanner;

public class ConditionExercise {

  public static void main(String[] args) {
    int age = 15;
    if (age < 13) {
      System.out.println("Child");
    }
    if (age < 18) {
      System.out.println("Teenager");
    } else {
      System.out.println("Adult");
    }
    // Проверить, может ли человек купить билет для взрослого фильма:
       /* int age1 = 18;
        boolean hasTicket = true;
        if (age1 >= 18 && hasTicket) {
            System.out.println("Allowed");
        }else {
            System.out.println("Not allowed");
        }*/
    int age1 = 6;
    boolean hasTicket = true;
    boolean canEnter = age1 >= 18 && hasTicket;

    if (canEnter) {
      System.out.println("Allowed");
    }
//exersise

    Scanner console = new Scanner(System.in);
    System.out.println("Введите ваш возраст:");
    int age2 = console.nextInt();
    console.nextLine();

    System.out.println("Введите секретный код:");
    String secretCode = console.nextLine();

    if (age2 >= 18) {
      // Если возраст >= 18, проверяем секретный код
      if (secretCode.equals("OPEN")) {
        // Если код равен "OPEN", разрешаем вход
        System.out.println("Вход разрешен!");
      } else {
        // Если код не равен "OPEN", запрещаем вход
        System.out.println("Вам сегодня не повезло, вход запрещен.");
      }
    } else {
      // Если возраст < 18, запрещаем вход
      System.out.println("Вам сегодня не повезло, вход запрещен.");
    }
  }
}



