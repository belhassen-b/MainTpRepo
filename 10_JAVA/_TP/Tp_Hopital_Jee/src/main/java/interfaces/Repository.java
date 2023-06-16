package interfaces;
import java.util.List;

public interface Repository<T> {
    boolean create(T o);
    T findById(int id);
    List<T> findAll();
}