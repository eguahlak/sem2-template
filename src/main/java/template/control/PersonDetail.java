package template.control;

public class PersonDetail {
  private final int id;
  private String firstName;
  private String lastName;
  private String email;
  private int age;

  public PersonDetail() {
    this.id = 0;
    }
  
  public PersonDetail(int id, String firstName, String lastName, String email, int age) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
    }

  public int getId() {
    return id;
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
  
  }
