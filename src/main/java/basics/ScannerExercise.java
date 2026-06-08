package basics;

import java.util.Scanner;

public class ScannerExercise {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter name: ");
    String name = input.nextLine();
    while (name.isBlank() || !name.matches("[a-zA-Zа-яА-я]+")) {  //  || or
      System.out.println("Enter a valid name: ");
      name = input.nextLine();
    }

    System.out.println("Name: " + name);

    System.out.print("Enter age: ");
        /*if (input.hasNextInt()){

       int age = input.nextInt();
       System.out.println("Age: "+age);
       }
       else {
           System.out.println("Please enter a number. ");
       }
       }*/
        /*  while (!input.hasNextInt()) {
        System.out.println("Invalid input. Please enter a number:");
        input.nextLine();
        }
        int age = input.nextInt();
        System.out.println("Age: "+age);*/


        /* while (!input.hasNextInt()) {

            System.out.println("Please enter a number.");

            input.nextLine(); // убрать неправильный ввод

            System.out.print("Enter age: ");
        }

        int age = input.nextInt(); */
    String aget = input.nextLine();
    while (!aget.matches("\\d+")) {
      System.out.print("Please enter a number.");
      aget = input.nextLine();
    }
    int age = Integer.parseInt(aget);

    System.out.println("Age: " + age);
  }

       /* String str = "10 20 40 60";
        Scanner scanner = new Scanner(str);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int с = scanner.nextInt();

        System.out.println(a + b + с);*/
}

