package application.boundary.console;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseMenu implements Menu {
  private final Map<String, String> strings = new HashMap<>();
  private final Map<String, Integer> integers = new HashMap<>();
  
  @Override
  public String getString(String key) {
    return strings.get(key);
    }

  @Override
  public int getInteger(String key) {
    return integers.get(key);
    }

  @Override
  public Menu setString(String key, String value) {
    strings.put(key, value);
    return this;
    }

  @Override
  public Menu setInteger(String key, int value) {
    integers.put(key, value);
    return this;
    }
  
  }
