package pl.pawel.linkshell.learning.lesson_1.eager_initialization_properties;

public class User {

  /*
   * This object fields are instantiated in eager mode
   */
  private String name = new String("defaultName_CreatedByEagerInit");
  private String surname = new String("defaultSurname_CreatedByEagerInit");
  private int age;

  public User() {
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

  /*
   * Notice that primitive types cannot be instantiated in eager mode,
   * because they have been already created due to primitive this type behavior.
   * In other words, primitive type has default value during the creation,
   * that why this technique does have no impact in here
   */
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
    System.out.println("Getting inner fields of class using toString() with eager initialization");
    User user_1 = new User();
    System.out.println(user_1);
  }

}
