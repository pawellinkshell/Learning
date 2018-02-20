package pl.pawel.linkshell.learning.lesson_1.pojo_aka_normal_properties;

public class User {

  private String name;
  private String surname;
  private int age;

  public User(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  /*
     * Lazy initialization example for getting field
     */
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
   * Notice that primitive types cannot be instantiated lazy,
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
    System.out.println("Getting inner fields of class using toString()");
    User user_1 = new User("Jeff", "Dummy", 27);
    System.out.println(user_1);

  }

}
