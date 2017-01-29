
package steamedchicken;

import java.util.LinkedList;

/**
 * The order for the current customer. 
 * @author Steamed Chicken
 */
public class Order
{
    public static final int mealOneItemIndex = 0;
    public static final int mealTwoItemIndex = 1;
    public static final int mealThreeItemIndex = 2;
    public static final int mealFourItemIndex = 3;
    public static final int mealFiveItemIndex = 4;
    public static final int mealSixItemIndex = 5;
    public static final int sideItemIndex = 6;
    public static final int drinkItemIndex = 7;
    
    public static final int numberOfItems = 8;
    
    private Item[] orderItem = new Item[numberOfItems];
    
    /**
     * Initializes the elements in the orderItem array.
     */
    public Order()
    {
        Item mealOne = new MealOne();
        Item mealTwo = new MealTwo();
        Item mealThree = new MealThree();
        Item mealFour = new MealFour();
        Item mealFive = new MealFive();
        Item mealSix = new MealSix();
        Item side = new Side();
        Item drink = new Drink();
        
        orderItem[mealOneItemIndex] = mealOne;
        orderItem[mealTwoItemIndex] = mealTwo;
        orderItem[mealThreeItemIndex] = mealThree;
        orderItem[mealFourItemIndex] = mealFour;
        orderItem[mealFiveItemIndex] = mealFive;
        orderItem[mealSixItemIndex] = mealSix;
        orderItem[sideItemIndex] = side;
        orderItem[drinkItemIndex] = drink;
    }
    
    /**
     * Adds one to the element in orderArray representing the input item.
     * @param itemIndex index of the item in the orderArray 
     */
    public void addItem(int itemIndex)
    {
        orderItem[itemIndex].incrementAmount();
    }
    
    /**
     * Gets the input item from the orderArray.
     * @param itemIndex index of the item in the orderArray
     * @return item at the input itemIdex in orderArray
     */
    public Item getItem(int itemIndex)
    {
        return orderItem[itemIndex];
    }
}
