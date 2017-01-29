
package steamedchicken;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 * Handles user input from the SalesView and updates data in the order.
 * @author SteamedChicken
 */
public class SalesController
{
    private SalesView salesView;
    private Order order;
    
    /**
     * Gets references to the SalesView and Order and adds listeners to the SalesView.
     * @param salesView the salesView that this controller handles user input from
     * @param order the order that the user is selecting
     */
    public SalesController(SalesView salesView, Order order)
    {
        this.salesView = salesView;
        this.order = order;
        
        salesView.addBackButtonListener(new BackButtonListener());
    }
    
    /**
     * A listener for the back button. Moves the user back to the menu screen.
     */
    class BackButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int mealOneAmount = order.getItem(Order.mealOneItemIndex).getAmount();
            int mealTwoAmount = order.getItem(Order.mealTwoItemIndex).getAmount();
            int mealThreeAmount = order.getItem(Order.mealThreeItemIndex).getAmount();
            int mealFourAmount = order.getItem(Order.mealFourItemIndex).getAmount();
            int mealFiveAmount = order.getItem(Order.mealFiveItemIndex).getAmount();
            int mealSixAmount = order.getItem(Order.mealSixItemIndex).getAmount();
            int sideAmount = order.getItem(Order.sideItemIndex).getAmount();
            int drinkAmount = order.getItem(Order.drinkItemIndex).getAmount();

            BigDecimal mealOnePrice = order.getItem(Order.mealOneItemIndex).getPrice();
            BigDecimal mealTwoPrice = order.getItem(Order.mealTwoItemIndex).getPrice();
            BigDecimal mealThreePrice = order.getItem(Order.mealThreeItemIndex).getPrice();
            BigDecimal mealFourPrice = order.getItem(Order.mealFourItemIndex).getPrice();
            BigDecimal mealFivePrice = order.getItem(Order.mealFiveItemIndex).getPrice();
            BigDecimal mealSixPrice = order.getItem(Order.mealSixItemIndex).getPrice();
            BigDecimal sidePrice = order.getItem(Order.sideItemIndex).getPrice();
            BigDecimal drinkPrice = order.getItem(Order.drinkItemIndex).getPrice();

            MenuView menuView = new MenuView(mealOneAmount, mealTwoAmount, mealThreeAmount, mealFourAmount, mealFiveAmount, mealSixAmount, sideAmount, drinkAmount);
            MenuController menuController = new MenuController(menuView, order);
            menuView.setVisible(true);
            salesView.close();
        }
    }
}
