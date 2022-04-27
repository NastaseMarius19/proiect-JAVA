package src.persistence;

public interface GenericRestaurant<T> {

    public void add(T entity);

    public T get(int index);

    public void delete(int entity);
}
