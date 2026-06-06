package factory;

import decorator.LoyaltyPointsDecorator;
import decorator.TaxDecorator;
import strategy.LoyaltyDiscount;
import strategy.NoDiscount;
import template.OrderProcessor;
import template.RegularOrderProcessor;

public class RegularOrderProcessorFactory extends OrderProcessorFactory {

    public RegularOrderProcessorFactory()
    {
    }

    @Override
    protected OrderProcessor buildProcessor(int loyaltyPoints) {
        var discount = loyaltyPoints > 0
                ? new LoyaltyDiscount(loyaltyPoints)
                : new NoDiscount();
        OrderProcessor base = new RegularOrderProcessor(discount);
        return new LoyaltyPointsDecorator(new TaxDecorator(base));
    }
}