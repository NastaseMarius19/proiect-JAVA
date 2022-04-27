package src.persistence;

import src.domain.Restaurant;

/** generic contract for repositories. Minimum set of methods that all repositories should have **/
public interface GenericRepository<T> {

    int compareTo(Restaurant o1, Restaurant o2);

    public void add(T entity);

    public T get(int id);

    public void update(T entity);

    public void delete(T entity);

    public int getSize();

}
