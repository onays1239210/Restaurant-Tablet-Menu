
package steamedchicken;

import java.math.BigDecimal;

/**
 * Items that customers can order.
 * @author Steamed Chicken
 */
public interface Item
{
    /**
     * Returns the name of the item.
     * @return name of the item
     */
    public String getName();
    
    /**
     * Returns the price of the item.
     * @return price of the item
     */
    public BigDecimal getPrice();
    
    /**
     * Returns the amount of the item.
     * @return amount of the item
     */
    public int getAmount();
    
    /**
     * Increments the amount of the item.
     */
    public void incrementAmount();
    
    /**
     * Decrements the amount of the item.
     */
    public void decrementAmount();
}
