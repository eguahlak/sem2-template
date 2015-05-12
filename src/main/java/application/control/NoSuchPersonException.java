package application.control;

public class NoSuchPersonException extends Exception {
  private final int id;

  public NoSuchPersonException(int id) {
    this.id = id;
    }

  public int getId() {
    return id;
    }
  
  }
