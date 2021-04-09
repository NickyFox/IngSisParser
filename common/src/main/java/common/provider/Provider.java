package common.provider;

public interface Provider<T> {
    void next();
    T get();
    boolean hasNext();
}
