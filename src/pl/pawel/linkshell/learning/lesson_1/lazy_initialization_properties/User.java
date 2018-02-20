package pl.pawel.linkshell.learning.lesson_1.lazy_initialization_properties;

public class User {

  private String name;
  private String surname;
  private int age;

  public User() {
  }

  /*
   * Lazy initialization example for getting field
   */
  public String getName() {
    if (name == null) {
      name = "defaultName_CreatedByLazyInit";
    }
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    if (this.surname == null) {
      this.surname = "defaultSurname_CreatedByLazyInit";
    }
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
    User user_1 = new User();
    System.out.println(user_1);

    System.out.println();
    System.out.println("Getting inner fields of class using getters with lazy initialization");
    user_1.getName();
    user_1.getSurname();
    user_1.getAge();
    System.out.println(user_1);

  }

}
