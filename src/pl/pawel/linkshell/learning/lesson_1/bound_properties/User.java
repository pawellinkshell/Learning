package pl.pawel.linkshell.learning.lesson_1.bound_properties;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class User {

  private String name;
  private String surname;
  private int age;

  // This field give us possibility of boundary in the property `User`
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  public User(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  /*
   * Each setter should calling now `propertyChangeSupport` to have history about it
   */
  public void setName(String name) {
    String old = this.name;
    this.name = name;
    propertyChangeSupport.firePropertyChange("name", old, name);
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    String old = this.surname;
    this.surname = surname;
    propertyChangeSupport.firePropertyChange("surname", old, surname);
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    int old = this.age;
    this.age = age;
    propertyChangeSupport.firePropertyChange("age", old, age);
  }

  /*
     *  This is delegated method.
     *  Delegated method means, that we inner method from some field are accesible directly
     */
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
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
    User user_1 = new User("Jeff", "Dummy", 25);
    user_1.addPropertyChangeListener(new MyPropertyChangeListener());

    user_1.setAge(19);
    user_1.setName("John");
    System.out.println(user_1);
  }

  private static class MyPropertyChangeListener implements PropertyChangeListener {

    // This method is called every time the property value is changed
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      System.out.println("******** CHANGES ****************");
      System.out.println("Name = " + evt.getPropertyName());
      System.out.println("Old Value = " + evt.getOldValue());
      System.out.println("New Value = " + evt.getNewValue());
      System.out.println("Propagation = " + evt.getPropagationId());  // Meaningless
      System.out.println("toString = " + evt.toString());             // Meaningless
      System.out.println("**********************************");
    }
  }
}
