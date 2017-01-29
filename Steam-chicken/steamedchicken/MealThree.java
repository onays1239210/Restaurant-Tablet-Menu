
package steamedchicken;

import java.math.BigDecimal;

/**
 * A mealthree item.
 * @author Steamed Chicken
 */
public class MealThree implements Item
{
    final String name = "Lemon Chicken";
    final BigDecimal price = new BigDecimal(30);
    int amount = 0;
    
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public BigDecimal getPrice()
    {
        return price;
    }

    @Override
    public int getAmount()
    {
        return amount;
    }

    @Override
    public void incrementAmount()
    {
        amount++;
    }

    @Override
    public void decrementAmount()
    {
        amount--;
    }
}
