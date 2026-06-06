package decorator;

import model.Order;
import template.OrderProcessor;

public class TaxDecorator extends ReceiptDecorator
{
    private static final double TAX_RATE = 0.05;

    public TaxDecorator(OrderProcessor wrapped)
    {
        super(wrapped);
    }

    @Override
    protected String enhanceReceipt(String receipt, Order order)
    {
        double tax = order.getItems().stream()
        .mapToDouble(item -> item.getPrice()).sum() * TAX_RATE;

        return receipt + String.format("Additional tax: $%.2f ", tax);
    }
}