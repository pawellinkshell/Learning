package pl.pawel.linkshell.learning.lesson_1.pojo_aka_normal_properties;

/*
 * POJO is an acronym for Plain Old Java Object. The name is used to emphasize
 * that the object in question is an ordinary Java Object,
 * not a special object, and in particular not an Enterprise JavaBean (especially before EJB 3),
 * not an Spring Bean, depend on 3-rd party dependency
 */
public class User {

  private String name;
  private String surname;
  private int age;

  public User(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

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
    User user_1 = new User("Jeff", "Dummy", 27);
    System.out.println(user_1);

  }

}
