package template;

import model.Order;
import strategy.DiscountStrategy;

public class RegularOrderProcessor extends OrderProcessor
{
    public RegularOrderProcessor(DiscountStrategy discount)
    {
        super(discount);
    }

    @Override
    protected double calculatePrice(Order order)
    {
        return order.getItems().stream()
        .mapToDouble(item -> item.getPrice()).sum();
    }

    @Override
    protected String generateReceipt(double total)
    {
        return String.format("Regular order of total: $%.2f ", total);
    }
}