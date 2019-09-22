package atmwithJDBC;

import org.springframework.dao.DataAccessException;

import java.util.HashMap;

public interface CustomerDao {
    void save(int pin);
    void update(int number, Customer customer);
    void deleteByID(int number);
    Customer findByID(int number);
    HashMap<Integer, Customer> findAll() throws DataAccessException;
}
