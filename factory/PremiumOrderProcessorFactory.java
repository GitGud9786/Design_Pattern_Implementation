package factory;

import decorator.GiftWrapDecorator;
import decorator.LoyaltyPointsDecorator;
import decorator.TaxDecorator;
import strategy.PercentageDiscount;
import template.OrderProcessor;
import template.RegularOrderProcessor;

public class PremiumOrderProcessorFactory extends OrderProcessorFactory {

    public PremiumOrderProcessorFactory()
    {
    }

    @Override
    protected OrderProcessor buildProcessor(int loyaltyPoints) {
        OrderProcessor base = new RegularOrderProcessor(new PercentageDiscount(15));
        return new GiftWrapDecorator(new LoyaltyPointsDecorator(new TaxDecorator(base)));
    }
}