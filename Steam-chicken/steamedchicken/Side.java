
package steamedchicken;

import java.math.BigDecimal;

/**
 * A side item.
 * @author Steamed Chicken
 */
public class Side implements Item
{
    final String name = "Side";
    final BigDecimal price = new BigDecimal(5);
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
