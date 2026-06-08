package basics;

public class DebuggingExercise {
  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4};

    System.out.println(findIndex(numbers, 3));
    System.out.println(findIndex(numbers, 10));
  }

  public static int findIndex(int[] numbers, int target) {
    for (int i = 0; i <= numbers.length; i++) {
      if (numbers[i] == target) {
        return i;
      }
    }
    return -1;
  }

}
