package decorator;

import model.Order;
import template.OrderProcessor;

public class LoyaltyPointsDecorator extends ReceiptDecorator
{
    public LoyaltyPointsDecorator(OrderProcessor wrapped)
    {
        super(wrapped);
    }

    @Override
    protected String enhanceReceipt(String receipt, Order order)
    {
        return receipt + "Loyalty points added. ";
    }
}