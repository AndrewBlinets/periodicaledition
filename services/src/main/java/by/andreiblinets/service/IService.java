package by.andreiblinets.service;

import java.util.List;

public interface IService<T> {
    Long add(T t);
    void update(T t);
    List<T> getAll();
    void delete(Long id);
    T getById(Long id);
}
