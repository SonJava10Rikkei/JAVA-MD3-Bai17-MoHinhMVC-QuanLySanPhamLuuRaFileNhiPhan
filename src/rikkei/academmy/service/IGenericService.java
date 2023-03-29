package rikkei.academmy.service;

import java.util.List;
// b4. Xaay interface
public interface IGenericService<T> {
    List<T> findAll();

    void save(T t);

    T findbyId(int id);

    void deleteById(int id);
}
