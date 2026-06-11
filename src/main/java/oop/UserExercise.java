package oop;

public class UserExercise {
  public static void main(String[] args) {
   /* User user1 = new User();
    user1.name = "Vika";
    user1.email= "vika@test.com";
    user1.age = 32;

    System.out.println(user1.name);
    System.out.println(user1.email);
    System.out.println(user1.age); без конструктора */

    User user2 = new User("Alex","alex@test.com",28);

    System.out.println("name: " + user2.name+";  email: "+user2.email);
    System.out.println(user2.age);

  }
}
