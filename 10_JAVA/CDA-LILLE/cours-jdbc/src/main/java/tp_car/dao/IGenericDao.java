package tp_car.dao;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDao<T> {
    T save(T type) throws SQLException;
    T findById(int id);

    void delete(int id);

    List<T> findAll();
    T update(T type);
}
