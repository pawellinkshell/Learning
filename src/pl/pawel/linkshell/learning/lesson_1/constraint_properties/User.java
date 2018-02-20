package pl.pawel.linkshell.learning.lesson_1.constraint_properties;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class User {

  private static final String NAME = "name";
  private static final String SURNAME = "surname";
  private static final String AGE = "age";

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
  public void setName(String name) {
    String old = this.name;
    try {
      vetoableChangeSupport.fireVetoableChange(NAME, old, name);
      this.name = name;
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    }
    propertyChangeSupport.firePropertyChange(NAME, old, name);
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    String old = this.surname;
    try {
      vetoableChangeSupport.fireVetoableChange(SURNAME, old, surname);
      this.surname = surname;
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    }
    propertyChangeSupport.firePropertyChange(SURNAME, old, surname);
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age)  {
    int old = this.age;
    try {
      vetoableChangeSupport.fireVetoableChange(AGE, old, age);
      this.age = age;
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    }
    propertyChangeSupport.firePropertyChange(AGE, old, age);
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

    // Should pass changes
    user_1.setAge(19);
    user_1.setName("John");
    System.out.println(user_1);

    // Should veto be triggered, that's mean should be thrown an Exception
    user_1.setName("Jo");
    user_1.setSurname("As");
    user_1.setAge(-1);
    System.out.println("SIEMA");
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

    private String eventName;

    /*
     * Veto policy
     */
    @Override
    public void vetoableChange(final PropertyChangeEvent evt) throws PropertyVetoException {
      eventName = evt.getPropertyName();
      if (eventName.equalsIgnoreCase(NAME)) {
        String name = (String) evt.getNewValue();
        if (name.length() <= 2) {
          throw new PropertyVetoException("Name must be longer than 2 characters", evt);
        }
        return;
      }

      if (eventName.equalsIgnoreCase(SURNAME)) {
        String surname = (String) evt.getNewValue();
        if (surname.length() <= 2) {
          throw new PropertyVetoException("Surname must be longer than 2 characters", evt);
        }
        return;
      }

      if (eventName.equalsIgnoreCase(AGE)) {
        int age = (int) evt.getNewValue();
        if ((age < 0) || (age >= 150)) {
          throw new PropertyVetoException("Age must be between 0 and 150 inclusively", evt);
        }
        return;
      }
    }
  }
}
