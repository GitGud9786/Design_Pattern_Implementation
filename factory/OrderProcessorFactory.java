package factory;
import template.OrderProcessor;

public abstract class OrderProcessorFactory {

    public OrderProcessor createProcessor(int loyaltyPoints) {
        OrderProcessor processor = buildProcessor(loyaltyPoints);  // factory method
        return processor;
    }
    protected abstract OrderProcessor buildProcessor(int loyaltyPoints);
}