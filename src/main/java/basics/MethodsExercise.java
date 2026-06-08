package basics;

public class MethodsExercise {

  /*  public static void main(String[] args){
        printSquare(2);
    }
  public static void printSquare (int number){
    System.out.println("Square: " + number*number);
  }*/
  public static void main(String[] args) {
    System.out.println("Square: " + square(2));
    System.out.println(square(5) + 10);
    System.out.println("sum=" + sum(2, 3));
    int multiplyResult = multiply(3, 5);
    System.out.println("multiply= " + multiplyResult);
    System.out.println(isEven(5));
    int[] arr = {1, 2, 3, 4, 4};
    int[] arr2 = {1, 2, 3, 4};
    System.out.println("sumArray = " + sumArray(arr));
    //System.out.println(sumArray(new int[]{1, 2, 3, 4}));
    int[] result = findMaxMin(arr);
    System.out.println("Max = " + result[0]);
    System.out.println("Min = " + result[1]);
    System.out.println(contains(arr, 5));
    System.out.println(findIndex(arr, 3));
    System.out.println(countOccurrences(arr, 4));
    System.out.println(areArraysEqual(arr, arr2));
  }

  public static int square(int number) {
    return number * number;
  }

  public static int sum(int a, int b) {
    return a + b;
  }

  public static int multiply(int a, int b) {
    return a * b;
  }

  public static boolean isEven(int number) {
    return number % 2 == 0;
  }

  public static int sumArray(int[] numbers) {
    int sum = 0;
    for (int i = 0; i < numbers.length; i++) {
      sum = sum + numbers[i];
    }
    return sum;
  }

  public static int[] findMaxMin(int[] numbers) {
    int max = numbers[0];
    int min = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > max) {
        max = numbers[i];
      }
      if (numbers[i] < min) {
        min = numbers[i];
      }
    }
    return new int[]{max, min};

  }

  public static boolean contains(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {

      if (target == numbers[i]) {
        return true;
      }
    }
    return false;
  }

  public static int findIndex(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      if (target == numbers[i]) {
        return i;
      }
    }
    return -1;
  }

  public static int countOccurrences(int[] numbers, int target) {
    int count = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (target == numbers[i]) {
        count++;
      }
    }
    return count;
  }

  public static boolean areArraysEqual(int[] first, int[] second) {
    if (first.length != second.length) {
      return false;
    }
    for (int i = 0; i < first.length; i++) {
      if (first[i] != second[i]) {
        return false;
      }
    }
    return true;
  }
}


