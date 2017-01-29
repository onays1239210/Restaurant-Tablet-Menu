
package steamedchicken;

import java.math.BigDecimal;

/**
 * A mealfive item.
 * @author Steamed Chicken
 */
public class MealFive implements Item
{
    final String name = "Rotisserie Chicken";
    final BigDecimal price = new BigDecimal(50);
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
