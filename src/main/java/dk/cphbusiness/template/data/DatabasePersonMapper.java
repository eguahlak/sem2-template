package dk.cphbusiness.template.data;

import dk.cphbusiness.template.model.MappingException;
import dk.cphbusiness.template.model.Person;
import dk.cphbusiness.template.model.PersonMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabasePersonMapper implements PersonMapper {
  private final String url;
  private final String username;
  private final String password;
  
  public DatabasePersonMapper(String driver, String url, String username, String password) throws ClassNotFoundException {
    Class.forName(driver);
    this.url = url;
    this.username = username;
    this.password = password;
    }
  
  private Person readPerson(ResultSet results) throws SQLException {
    int id = results.getInt("ID");
    String firstName = results.getString("FIRST_NAME");
    String lastName = results.getString("LAST_NAME");
    String email = results.getString("EMAIL");
    int age = results.getInt("AGE");
    String password = results.getString("PASSWORD");
    return new Person(id, firstName, lastName, age, email, password);
    }
  
  @Override
  public Person find(int id) throws MappingException {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      String sql = "SELECT * FROM TEMPLATE_PEOPLE WHERE ID = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet results = statement.executeQuery();
      if (results.next()) return readPerson(results);
      return null;
      }
    catch (SQLException ex) {
      Logger.getLogger(DatabasePersonMapper.class.getName()).log(Level.SEVERE, null, ex);
      throw new MappingException("Error finding person");
      }
    }

  @Override
  public Person save(Person person) throws MappingException {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      if (person.getId() == 0) {
        String sql =
            "INSERT INTO TEMPLATE_PEOPLE (ID, FIRST_NAME, LAST_NAME, AGE, EMAIL) "+
            "VALUES (TEMPLATE_PEOPLE_SEQUENCE.NEXTVAL, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, new String[] { "ID" });
        statement.setString(1, person.getFirstName());
        statement.setString(2, person.getLastName());
        statement.setInt(3, person.getAge());
        statement.setString(4, person.getEmail());
        statement.executeUpdate();
        ResultSet keys = statement.getGeneratedKeys();
        if (keys.next()) person.setId(keys.getInt(1));
        else throw new MappingException("Could not find id for new person");
        }
      else {
        String sql =
            "UPDATE TEMPLATE_PEOPLE "+
            "SET FIRST_NAME = ?, LAST_NAME = ?, AGE = ?, EMAIL = ? "+
            "WHERE ID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, person.getFirstName());
        statement.setString(2, person.getLastName());
        statement.setInt(3, person.getAge());
        statement.setString(4, person.getEmail());
        statement.setInt(5, person.getId());
        int count = statement.executeUpdate();
        if (count == 0) return null;
        }
      }
    catch (SQLException ex) {
      Logger.getLogger(DatabasePersonMapper.class.getName()).log(Level.SEVERE, null, ex);
      throw new MappingException("Error saving person");
      }
    return person;
    }

  @Override
  public Collection<Person> list() throws MappingException {
    Collection<Person> people = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      String sql = "SELECT * FROM TEMPLATE_PEOPLE ORDER BY FIRST_NAME, LAST_NAME";
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet results = statement.executeQuery();
      while (results.next()) people.add(readPerson(results));
      }
    catch (SQLException ex) {
      Logger.getLogger(DatabasePersonMapper.class.getName()).log(Level.SEVERE, null, ex);
      throw new MappingException(("Error listing people"));
      }
    return people;
    }
  
  }
