package strategy;

public class PercentageDiscount implements DiscountStrategy
{
    private final double percent;

    public PercentageDiscount(double percent)
    {
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double price)
    {
        return price * (1 - this.percent / 100);
    }
}