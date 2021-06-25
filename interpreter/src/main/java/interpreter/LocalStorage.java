package interpreter;

import interpreter.value.Value;
import java.util.HashMap;
import java.util.Map;

public class LocalStorage implements Memory<String, Value> {

  private Map<String, Value> memory;
  private Map<String, Boolean> finals;

  public LocalStorage() {
    this.memory = new HashMap<>();
    this.finals = new HashMap<>();
  }

  @Override
  public void save(String key, Value value, boolean isFinal) {
    this.finals.put(key, isFinal);
    this.memory.put(key, value);
  }

  @Override
  public boolean isFinal(String key) {
    return finals.get(key);
  }

  @Override
  public Value read(String key) {
    return this.memory.get(key);
  }

  @Override
  public boolean has(String key) {
    return this.memory.containsKey(key);
  }
}
