package atmwithJDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CustomerDaoImp implements CustomerDao{
    JdbcTemplate jdbcTemplate;
    public CustomerDaoImp (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(int pin) {
        String query = "INSERT INTO customers (pin) VALUES (?);";
        Object[] data = new Object[]
                { pin };
        jdbcTemplate.update(query, data);
    }

    public void update(int id, Customer customer) {
        String query = "UPDATE Customers SET balance=? WHERE number=?";
        Object[] data = new Object[]
                { customer.getAccount().getBalance(), id };
        jdbcTemplate.update(query, data);
    }

    public void deleteByID(int id) {
        String query = "DELETE FROM customers WHERE number=?";
        Object[] data = new Object[]
                { id };
        jdbcTemplate.update(query, data);
    }

    public Customer findByID(int id) {
        String query = "SELECT * FROM customers WHERE number = " + id;
        Customer customer = jdbcTemplate.queryForObject(query, new CustomerRowMapper());
        return customer;
    }

    public HashMap<Integer, Customer> findAll() throws DataAccessException {
        String query = "SELECT * FROM Customers";
        HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();

        for (Customer c : jdbcTemplate.query(query, new CustomerRowMapper())){
            customers.put(c.getCustomerNumber(), c);
        }
        return customers;

    }

    class CustomerRowMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer(
                    rs.getInt("id"),
                    rs.getInt("password"),
                    rs.getDouble("balance")
            );
            return customer;
        }
    }
}
