
package steamedchicken;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 * Handles user actions from the MenuView and updates data in the order.
 * @author SteamedChicken
 */
public class MenuController
{
    private MenuView menuView;
    private Order order;

    /**
     * Gets references to the MenuView and Order and adds listeners to the Menu.
     *
     * @param menuView the MenuView that this controller handles user input from
     * @param order the order that the user is selecting
     */
    public MenuController(MenuView menuView, Order order)
    {
        this.menuView = menuView;
        this.order = order;

        this.menuView.addMealOneButtonListener(new MealOneButtonListener());
        this.menuView.addMealTwoButtonListener(new MealTwoButtonListener());
        this.menuView.addMealThreeButtonListener(new MealThreeButtonListener());
        this.menuView.addMealFourButtonListener(new MealFourButtonListener());
        this.menuView.addMealFiveButtonListener(new MealFiveButtonListener());
        this.menuView.addMealSixButtonListener(new MealSixButtonListener());
        this.menuView.addCheckoutButtonListener(new CheckoutButtonListener());
        this.menuView.addSideButtonListener(new SideButtonListener());
        this.menuView.addDrinkButtonListener(new DrinkButtonListener());

        this.menuView.addAdminLoginKeyListener(new AdminLoginKeyListener());
    }

    /**
     * Button listener for meal one. Increments meal one amount.
     */
    class MealOneButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealOne = order.getItem(Order.mealOneItemIndex);
            mealOne.incrementAmount();
            menuView.setMealOneText(mealOne.getAmount());
        }
    }

    /**
     * Button listener for meal two. Increments meal two amount.
     */
    class MealTwoButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealTwo = order.getItem(Order.mealTwoItemIndex);
            mealTwo.incrementAmount();
            menuView.setMealTwoText(mealTwo.getAmount());
        }
    }

    /**
     * Button listener for meal three. Increments meal three amount.
     */
    class MealThreeButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealThree = order.getItem(Order.mealThreeItemIndex);
            mealThree.incrementAmount();
            menuView.setMealThreeText(mealThree.getAmount());
        }
    }

    /**
     * Button listener for meal four. Increments meal four amount.
     */
    class MealFourButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealFour = order.getItem(Order.mealFourItemIndex);
            mealFour.incrementAmount();
            menuView.setMealFourText(mealFour.getAmount());
        }
    }

    /**
     * Button listener for meal five. Increments meal five amount.
     */
    class MealFiveButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealFive = order.getItem(Order.mealFiveItemIndex);
            mealFive.incrementAmount();
            menuView.setMealFiveText(mealFive.getAmount());
        }
    }

    /**
     * Button listener for meal six. Increments meal six amount.
     */
    class MealSixButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealSix = order.getItem(Order.mealSixItemIndex);
            mealSix.incrementAmount();
            menuView.setMealSixText(mealSix.getAmount());
        }
    }

    /**
     * Button listener for side. Increments side amount.
     */
    class SideButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item side = order.getItem(Order.sideItemIndex);
            side.incrementAmount();
            menuView.setSideText(side.getAmount());
        }
    }

    /**
     * Button listener for drink. Increments drink amount.
     */
    class DrinkButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item drink = order.getItem(Order.drinkItemIndex);
            drink.incrementAmount();
            menuView.setDrinkText(drink.getAmount());
        }
    }

    /**
     * Button listener for checkout. Moves the user to the summary screen.
     */
    class CheckoutButtonListener implements ActionListener
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

            SummaryView summaryView = new SummaryView(mealOneAmount, mealTwoAmount, mealThreeAmount, mealFourAmount, mealFiveAmount, mealSixAmount, sideAmount, drinkAmount,
                    mealOnePrice, mealTwoPrice, mealThreePrice, mealFourPrice, mealFivePrice, mealSixPrice, sidePrice, drinkPrice);
            SummaryController summaryController = new SummaryController(summaryView, order);
            summaryView.setVisible(true);
            menuView.close();
        }
    }

    /**
     * KeyListener for the admin login. Moves the user to the admin screen if 
     * the input password is correct.
     */
    class AdminLoginKeyListener implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
            // does not need to be implemented for our purposes
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            final String adminPassword = "steamed";
            final String inputDialog = "Password:";
            
            if (e.getKeyCode() == KeyEvent.VK_A)
            {
                JOptionPane adminLoginOptionPane = new JOptionPane();

                String inputValue = adminLoginOptionPane.showInputDialog(inputDialog);
                
                if (inputValue.equals(adminPassword))
                {
                    SalesView salesView = new SalesView();
                    SalesController salesController = new SalesController(salesView, order);
                    
                    salesView.setVisible(true);
                    menuView.close();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            // does not need to be implemented for our purposes
        }
    }
}
