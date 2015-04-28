package dk.cphbusiness.template.model;

public class Person {
  private int id;
  private String firstName;
  private String lastName;
  private int age;
  private String email;
  private String password;

  public Person(int id, String firstName, String lastName, int age, String email, String password) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.email = email;
    this.password = password;
    }

  public int getId() {
    return id;
    }

  public void setId(int id) {
    this.id = id;
    }

  public String getFirstName() {
    return firstName;
    }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
    }

  public String getLastName() {
    return lastName;
    }

  public void setLastName(String lastName) {
    this.lastName = lastName;
    }

  public int getAge() {
    return age;
    }

  public void setAge(int age) {
    this.age = age;
    }

  public String getEmail() {
    return email;
    }

  public void setEmail(String email) {
    this.email = email;
    }
  
  public void setPassword(String password) {
    this.password = password;
    }
  
  }
