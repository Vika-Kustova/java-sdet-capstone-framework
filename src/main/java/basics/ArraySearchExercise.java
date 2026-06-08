package basics;

import java.util.Scanner;

public class ArraySearchExercise {

  public static void main(String[] args) {

    //find a number

    Scanner input = new Scanner(System.in);
    int[] numbers = {5, 12, 7, 20, 3, 15};
    System.out.print("Enter number: ");

    if (!input.hasNextInt()) {
      System.out.println("Invalid number");
      return;
    }

    int y = input.nextInt();
    boolean found = false;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == y) {
        found = true;
      }
    }
    if (found == true) {
      System.out.println("Number found");
    } else {
      System.out.println("Number not found");
    }

    // find index
    int index = -1;
    int[] array = {5, 12, 7, 20, 3, 15};
    System.out.print("Enter number: ");
    if (!input.hasNextInt()) {
      System.out.println("Invalid number");
      return;
    }
    int targetNumber = input.nextInt();

    for (int x = 0; x < array.length; x++) {
      if (array[x] == targetNumber) {
        index = x;
        break;
      }
    }
    if (index != -1) {
      System.out.print("Index found = " + index);
    } else {
      System.out.print("Index not found");
    }
  }
}
