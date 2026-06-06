import java.util.List;
import model.Order;
import model.Item;
import factory.OrderProcessorFactory;
import factory.RegularOrderProcessorFactory;
import factory.PremiumOrderProcessorFactory;
import factory.EnterpriseOrderProcessorFactory;
import template.OrderProcessor;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(List.of(new Item("Laptop", 1000), new Item("Mouse", 50)));
        
        OrderProcessorFactory regularFactory = new RegularOrderProcessorFactory();
        OrderProcessor regularProcessor = regularFactory.createProcessor(10);
        System.out.println("Regular Customer: " + regularProcessor.process(order));
        
        OrderProcessorFactory premiumFactory = new PremiumOrderProcessorFactory();
        OrderProcessor premiumProcessor = premiumFactory.createProcessor(0);
        System.out.println("Premium Customer: " + premiumProcessor.process(order));
        
        OrderProcessorFactory enterpriseFactory = new EnterpriseOrderProcessorFactory();
        OrderProcessor enterpriseProcessor = enterpriseFactory.createProcessor(225);
        System.out.println("Enterprise Customer: " + enterpriseProcessor.process(order));
    }
}