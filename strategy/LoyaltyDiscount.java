package strategy;

public class LoyaltyDiscount implements DiscountStrategy
{
    private final int points;

    public LoyaltyDiscount(int points)
    {
        this.points = points;
    }

    @Override
    public double applyDiscount(double price)
    {
        return Math.max(0, price - (this.points * 0.01));
    }
}