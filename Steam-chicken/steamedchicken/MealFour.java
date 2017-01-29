
package steamedchicken;

import java.math.BigDecimal;

/**
 * A mealfour item.
 * @author Steamed Chicken
 */
public class MealFour implements Item
{
    final String name = "Yofu Chicken";
    final BigDecimal price = new BigDecimal(40);
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
