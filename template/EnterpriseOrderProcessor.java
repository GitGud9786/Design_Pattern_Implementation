package template;

import model.Order;
import strategy.DiscountStrategy;

public class EnterpriseOrderProcessor extends OrderProcessor
{
    public EnterpriseOrderProcessor(DiscountStrategy discount)
    {
        super(discount);
    }

    @Override
    protected double calculatePrice(Order order)
    {
        double total = order.getItems().stream()
        .mapToDouble(item -> item.getPrice()).sum();

        return total * 0.9;
    }

    @Override
    protected String generateReceipt(double total)
    {
        return String.format("Enterprise order of total: $%.2f ", total);
    }
}