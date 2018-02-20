package pl.pawel.linkshell.learning.lesson_1.immutable_sophisticated_1_properties;

/*
 * This example of immutable class, has following features:
 *   * can be extended by other class, but have immutables aspects for the object
 *   * in constructor body, parameters cannot be changed
 */
public class User {

  private final String name;
  private final String surname;
  private final int age;

  public User(final String name, final String surname, final int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  public final String getName() {
    return name;
  }

  public final String getSurname() {
    return surname;
  }

  public final int getAge() {
    return age;
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