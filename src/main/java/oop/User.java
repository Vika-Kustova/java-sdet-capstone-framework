package oop;

import java.util.Objects;

public class User implements Validatable {

  private String name;
  private String email;
  private int age;

  public User(String name, String email, int age) {
    this.name = name;
    this.email = email;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public boolean isValid() {
    return name != null && !name.isBlank() && email != null && !email.isBlank() && age > 0;
  }

  @Override
  public boolean equals(Object obj) {
    //this = user1, obj = user2) for user1.equals(user2); this это объект у которого вызвали метод. если передаем один и тот же объект, то только тогда условие выполнится user1==user1
    if (this == obj) {
      return true;
    }
    //если объекты разные, условия не выполняется и идем дальше
    if (!(obj instanceof User otherUser)) { //instanceof проверяет является ли obj объектом типа юзер, если obj является User, назови этого пользователя otherUser
      return false;
    }
    return age == otherUser.age && name.equals(otherUser.name) && email.equals(otherUser.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, name, email);
  }
}
