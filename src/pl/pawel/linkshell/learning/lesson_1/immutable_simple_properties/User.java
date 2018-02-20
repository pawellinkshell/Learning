package pl.pawel.linkshell.learning.lesson_1.immutable_simple_properties;

/*
 * This example of immutable class, has following features:
 *   * do not allow to be extended
 *   * in constructor body, parameters cannot be changed
 */
public final class User {

  private final String name;
  private final String surname;
  private final int age;

  public User(final String name, final String surname, final int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getAge() {
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