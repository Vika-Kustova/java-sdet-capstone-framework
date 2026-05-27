package basics;

public class MathOperatorsExercise {
    public static void main(String[] args) {
        int a = 2;
        int b = 10;
        int d = 5;

        int sum = a+b;
        System.out.println ("Sum = "+sum);

        int difference = a-b;
        int multiplication = a*b;
        double division = (double) a/b;
        int div = d%a; // оператор «остаток от деления»
        /*Это очень полезный оператор, и используется он довольно часто.
         Например, чтобы узнать, четное число или нет, достаточно поделить
         его на 2 и полученный остаток сравнить с нулем.
         Если остаток от деления равен нулю, число четное, если равен единице — нечетное.
         (a % 2) == 0
         == используется для сравнения с нулем*/

        System.out.println ("difference = "+difference);
        System.out.println ("multiplication = "+multiplication);
        System.out.println ("division = "+division);
        System.out.println ("div = "+div);

        int c =(a+b)*2;
       // c=c*2;
        c++; //Оператор инкремент (увеличение на единицу) выглядит так
        c--; //Оператор декремент (уменьшение на единицу) выглядит так
        //одна и та же переменная может одновременно быть слева и справа от оператора присваивания
        System.out.println ("c = " + c);

    }
}
