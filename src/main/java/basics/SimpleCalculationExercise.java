package basics;

public class SimpleCalculationExercise {

  public static void main(String[] args) {
       /* int apples =5;
        int bananas = 3;
        int totalFruits = apples+bananas; */

        /*int apples, bananas, totalFruits;
        apples=5;
        bananas=3;
        totalFruits=apples+bananas;*/

    int apples = 5, bananas = 3, totalFruits = apples + bananas;

    System.out.println("Total fruits = " + totalFruits); // это выводит Total fruits на экран
    int x = 999;
    int y = 33;
    //x+=y; //x=x+y =1032

    System.out.println("x/y= " + (x / y));
    System.out.println(x == y);
    x += y; //x=x+y
    System.out.println("X1=" + x);
    int z = 3;
    z = -z;
    z++;
    z--;
    System.out.println(z);

  }
}
