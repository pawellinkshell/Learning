package pl.pawel.linkshell.learning.lesson_1.bean_properties;

import java.io.Serializable;

/*
 * A JavaBean is a Java Object that:
 *    * is serializable,
 *    * has a nullary constructor,
 *    and allows access to properties using getter and setter methods.
 */
public class User implements Serializable{

  private String name;
  private String surname;
  private int age;

  public User() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", age=" + age +
        '}';
  }

  public static void main(String[] args) {
    // 1) Getting inner fields of class using toString()
    System.out.println("Getting inner fields of class using toString()");
    User user_1 = new User();

    user_1.setName("Jeff");
    user_1.setSurname("Dummy");
    user_1.setAge(27);

    System.out.println(user_1);

  }

}
