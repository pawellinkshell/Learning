package pl.pawel.linkshell.learning.lesson_1.constraint_properties;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class User {

  private String name;
  private String surname;
  private int age;

  // This field give us possibility of boundary in the property `User`
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  // This field give us possibility of constraining in the property `User`
  private VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);

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
  public void setName(String name) throws PropertyVetoException {
    String old = this.name;
    this.name = name;
    vetoableChangeSupport.fireVetoableChange("name", old, name);
    propertyChangeSupport.firePropertyChange("name", old, name);
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) throws PropertyVetoException {
    String old = this.surname;
    this.surname = surname;
    vetoableChangeSupport.fireVetoableChange("surname", old, surname);
    propertyChangeSupport.firePropertyChange("surname", old, surname);
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) throws PropertyVetoException {
    int old = this.age;
    this.age = age;
    vetoableChangeSupport.fireVetoableChange("age", old, age);
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

  public void addVetoableChangeListener(VetoableChangeListener listener) {
    vetoableChangeSupport.addVetoableChangeListener(listener);
  }

  public void removeVetoableChangeListener(VetoableChangeListener listener) {
    vetoableChangeSupport.removeVetoableChangeListener(listener);
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", age=" + age +
        '}';
  }

  public static void main(String[] args) throws PropertyVetoException {
    User user_1 = new User("Jeff", "Dummy", 25);
    user_1.addPropertyChangeListener(new MyPropertyChangeListener());
    user_1.addVetoableChangeListener(new MyVetoableChangeListener());

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

  private static class MyVetoableChangeListener implements VetoableChangeListener {

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
      System.out.println("******** VETOS ****************");
      System.out.println("Name = " + evt.getPropertyName());
      System.out.println("Old Value = " + evt.getOldValue());
      System.out.println("New Value = " + evt.getNewValue());
      System.out.println("Propagation = " + evt.getPropagationId());  // Meaningless
      System.out.println("toString = " + evt.toString());             // Meaningless
      System.out.println("**********************************");
    }
  }
}
