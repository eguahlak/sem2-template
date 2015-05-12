package application.boundary.console;

import application.control.Controller;

public interface Menu {
  Menu show(Controller controller);
  String getString(String key);
  int getInteger(String key);
  Menu setString(String key, String value);
  Menu setInteger(String key, int value);
  }
