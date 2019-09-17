package atmwithdatabase;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadFile implements ReadDataSource {
    private String filename;
    public ReadFile(String filename) {
        this.filename = filename;
    }
    public Map<Integer, Customer> readCustomer() throws IOException {
        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNext()) {
            int number = in.nextInt();
            int pin = in.nextInt();
            double currentBalance = in.nextDouble();
            Customer c = new Customer(number, pin, currentBalance);
            customers.put(c.getCustomerNumber(), c);
        }
        in.close();
        return customers;
    }
}
