package basics;

public class LoopExercise {
    public static void main(String[] args) {
        //int i=1;
        /*while (i<=5){
            System.out.println(i);
            i++; */
        for (int i = 2; i<=10; i+=2) /*i=i+2)*/ {
            System.out.println(i);
        }
        for (int v = 10; v>=0; v=v-2){
            System.out.println(v);
        }
        for (int i2 = 1; i2<5; i2++)  {
            System.out.println(i2);
        }
        // print sum 55 while
        int d =1;
        int sum = 0;
        while (d<=10){
            sum=sum+d;
            d++;
        }
        System.out.println("sum="+sum);
        // print sum 55 for


        int sum1 =0;
        for (int c = 1; c <= 10;  c++) {
            sum1=sum1+c;

        }
        System.out.println("sum="+sum1);

        // multiplication table

        for (int m= 1; m<=10; m++){
            int mult = 5*m;
            System.out.println("mult= 5 x "+m+" = "+mult);
        }
        //Print the number of even numbers from 1 to 100.
        int count=0;
        for (int y=1; y<=100; y++) {
            if (y%2==0){
                count++; //увеличивает счетчик на 1 раз каждый раз при выполнение условия count+1 = сумма четных чисел
            }
        }
        System.out.println("count "+count);
    }
    }

