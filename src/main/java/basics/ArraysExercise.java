package basics;
import java.util.Arrays;
public class ArraysExercise {

  public static void main(String[] args) {
    //sum
    int[] numbers = {10, 20, 30, 40};
    int sum = 0;
    for (int i = 0; i < numbers.length; i++) {
      sum = sum + numbers[i];
    }
    System.out.println(sum);
    //max/min
    int max = numbers[0];
    int min = numbers[0];
    for (int y = 1; y < numbers.length; y++) {
      if (numbers[y] > max) {
        max = numbers[y];
      }
      if (numbers[y] < min) {
        min = numbers[y];
      }

    }
    System.out.println("max = " + max);
    System.out.println("min = " + min);
    //
    double[] sen = new double[4];
    sen[2] = 3.14;
    //for(double sens :sen)
    for (int s = 0; s < sen.length; s++) {
      System.out.print(sen[s] + " , ");
    }
    System.out.println ();
    // arrays.sort
    int[] scores = {5, 12, 7, 20, 3, 15};
    Arrays.sort(scores); //сортируем по возрастанию
    System.out.println ("Sorting in ascending order: "+Arrays.toString(scores));

    String[] names = {"Вася", "Петя", "Аня", "Игорь"};
    Arrays.sort(names);

    System.out.println(Arrays.toString(names));

    int[] arr = {7, 5, 3, 1, 9, 8};
    Arrays.sort(arr, 1, 4); // сортирует элементы с индекса 1 до 3 включительно (4 не включается)

    System.out.println(Arrays.toString(arr));

    //fill
    int[] marks = new int[10];
    Arrays.fill(marks, 3); // Все элементы теперь равны 3
    System.out.println(Arrays.toString(marks));
    Arrays.fill(marks,2,5,7);
    System.out.println(Arrays.toString(marks));
    int[] copy = Arrays.copyOf(marks, 5);
    System.out.println(Arrays.toString(copy));
    int[] mid = Arrays.copyOfRange(arr, 1, 4); // Скопирует элементы с индекса 1 по 3
    System.out.println(Arrays.toString(mid));

    int [] arr2 = {1,3,5};
    System.out.println(Arrays.equals(mid,arr2));

  }
}

