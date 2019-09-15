package atmjavaconfig;

import org.springframework.context.annotation.Bean;

public class ATMconfig {
    @Bean
    public DataSource dataSource() {
        return new DataSource("customers.txt");
    }
    @Bean Bank bank() {
        return new Bank(dataSource());
    }
    @Bean
    public ATM atm() {
        return new ATM(bank());
    }
    @Bean
    public ATMSimulator atmSimulator() {
        return new ATMSimulator(atm());
    }
}
