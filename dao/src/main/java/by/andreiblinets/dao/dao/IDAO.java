package by.andreiblinets.dao.dao;

import java.util.List;

public interface IDAO<T> {

    Long create(T t);
    void update(T t);
    List<T> readAll();
    T readById(Long id);
    void delete(Long id);

}
