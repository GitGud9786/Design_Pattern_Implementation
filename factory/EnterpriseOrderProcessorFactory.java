package factory;
import decorator.GiftWrapDecorator;
import decorator.LoyaltyPointsDecorator;
import decorator.TaxDecorator;
import strategy.PercentageDiscount;
import template.EnterpriseOrderProcessor;
import template.OrderProcessor;
public class EnterpriseOrderProcessorFactory extends OrderProcessorFactory
{
    public EnterpriseOrderProcessorFactory()
    {
    }

    @Override
    protected OrderProcessor buildProcessor(int loyaltypoints)
    {
        OrderProcessor processor = new EnterpriseOrderProcessor(new PercentageDiscount(20)); // 20% off for enterprise customers
        return new LoyaltyPointsDecorator(new TaxDecorator(processor));
    }
    
}
