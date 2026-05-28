package basics;

import java.util.Scanner;
public class ScannerExercise {
    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       System.out.print("Enter name: ");
       String name = input.nextLine();
       System.out.print("Enter age: ");
       int age = input.nextInt();

       System.out.println("Name: "+name);
       System.out.println("Age: "+age);
    }
}
