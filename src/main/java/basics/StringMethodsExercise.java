package basics;

public class StringMethodsExercise {
    public static void main(String[] args){
        String number ="25";
        int result = Integer.parseInt(number); // преобразовывает строку в число, если строка состоит из цифр
        System.out.println(result+5);

        //Методы length() toUpperCase() toLowerCase()
        String name ="Rome";
        int count = (name+1).length();
        System.out.println(count);
        String name1 = name.toUpperCase();
        System.out.println(name1);
        String name2 = name.toLowerCase();
        System.out.println(name2);
    }

}
