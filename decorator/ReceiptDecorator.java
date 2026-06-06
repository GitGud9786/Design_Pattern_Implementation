package decorator;

import model.Order;
import template.OrderProcessor;

public abstract class ReceiptDecorator extends OrderProcessor {
    protected final OrderProcessor wrapped;

    protected ReceiptDecorator(OrderProcessor wrapped)
    {
        super(wrapped.getDiscount());
        this.wrapped = wrapped;
    }

    @Override
    public String process(Order order)
    {
        String receipt = wrapped.process(order);
        return enhanceReceipt(receipt, order);
    }

    protected abstract String enhanceReceipt(String receipt, Order order);

    @Override
    protected double calculatePrice(Order order){return 0.0;}
    @Override
    protected String generateReceipt(double total){return "";}
}