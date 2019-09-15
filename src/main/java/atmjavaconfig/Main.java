package atmjavaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //DataSource dataSource = new DataSource("customers.txt");
//        Bank bank = new Bank(dataSource);
////        ATM atm = new ATM(bank);
////        ATMSimulator atmSimulator = new ATMSimulator(atm);
////        atmSimulator.run();
        ApplicationContext context;
        context = new AnnotationConfigApplicationContext(ATMconfig.class);
        ATMSimulator atmSimulator = context.getBean(ATMSimulator.class);
        atmSimulator.run();
    }
}
