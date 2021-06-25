package interpreter;

public interface Memory<K, V> {
  void save(K key, V value, boolean isFinal);

  V read(K key);

  boolean has(K key);

  boolean isFinal(K key);
}
