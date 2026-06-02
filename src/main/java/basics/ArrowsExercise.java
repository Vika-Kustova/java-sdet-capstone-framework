package basics;

public class ArrowsExercise {
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
        System.out.println("max = "+max);
        System.out.println("min = "+min);
    }
}
