package template;

import model.Order;
import strategy.DiscountStrategy;

public abstract class OrderProcessor {
    protected final DiscountStrategy discount;

    protected OrderProcessor(DiscountStrategy discount)
    {
        this.discount = discount;
    }

    public DiscountStrategy getDiscount()
    {
        return discount;
    }

    public String process(Order order) // main template function
    {
        validate(order);
        double price = calculatePrice(order);
        double finalPrice = discount.applyDiscount(price);
        return generateReceipt(finalPrice);
    }

    protected void validate(Order order)
    {
        if(order.getItems().isEmpty())
        {
            throw new IllegalArgumentException("No items. ");
        }
    }

    protected abstract double calculatePrice(Order order);
    protected abstract String generateReceipt(double total);
}