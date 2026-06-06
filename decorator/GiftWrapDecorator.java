package decorator;

import model.Order;
import template.OrderProcessor;

public class GiftWrapDecorator extends ReceiptDecorator
{
    public GiftWrapDecorator(OrderProcessor wrapped)
    {
        super(wrapped);
    }

    @Override
    protected String enhanceReceipt(String receipt, Order order)
    {
        return receipt + "Gift wrap applied. ";
    }
}