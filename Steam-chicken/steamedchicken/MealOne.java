
package steamedchicken;

import java.math.BigDecimal;

/**
 * A mealone item.
 * @author Steamed Chicken
 */
public class MealOne implements Item
{
    final String name = "Steamed Chicken";
    final BigDecimal price = new BigDecimal(10);
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
