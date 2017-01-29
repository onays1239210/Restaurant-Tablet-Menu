
package steamedchicken;

import java.math.BigDecimal;

/**
 * A mealsix item.
 * @author Steamed Chicken
 */
public class MealSix implements Item
{
    final String name = "Stuffed Chicken";
    final BigDecimal price = new BigDecimal(60);
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
