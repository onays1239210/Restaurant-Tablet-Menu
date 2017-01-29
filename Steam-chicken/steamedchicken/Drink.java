
package steamedchicken;

import java.math.BigDecimal;

/**
 * A drink item.
 * @author Steamed Chicken
 */
public class Drink implements Item
{
    final String name = "Drink";
    final BigDecimal price = new BigDecimal(1);
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
