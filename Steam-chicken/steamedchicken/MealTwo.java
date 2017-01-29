
package steamedchicken;

import java.math.BigDecimal;

/**
 * A mealtwo item.
 * @author Steamed Chicken
 */
public class MealTwo implements Item
{
    final String name = "BBQ Chicken";
    final BigDecimal price = new BigDecimal(20);
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
