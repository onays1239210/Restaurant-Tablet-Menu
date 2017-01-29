
package steamedchicken;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 * Handles user actions from the SummaryView and updates data in the order.
 * @author Steamed Chicken
 */
public class SummaryController
{
    SummaryView summaryView;
    Order order;

    /**
     * Gets references to the summary view and order and adds listeners to the summary screen.
     * @param summaryView the summaryView that this controller handles user input from
     * @param order the order that the user is selecting
     */
    public SummaryController(SummaryView summaryView, Order order)
    {
        this.summaryView = summaryView;
        this.order = order;

        this.summaryView.addMealOneDecrementButtonListener(new MealOneDecrementButtonListener());
        this.summaryView.addMealOneIncrementButtonListener(new MealOneIncrementButtonListener());
        this.summaryView.addMealTwoDecrementButtonListener(new MealTwoDecrementButtonListener());
        this.summaryView.addMealTwoIncrementButtonListener(new MealTwoIncrementButtonListener());
        this.summaryView.addMealThreeDecrementButtonListener(new MealThreeDecrementButtonListener());
        this.summaryView.addMealThreeIncrementButtonListener(new MealThreeIncrementButtonListener());
        this.summaryView.addMealFourDecrementButtonListener(new MealFourDecrementButtonListener());
        this.summaryView.addMealFourIncrementButtonListener(new MealFourIncrementButtonListener());
        this.summaryView.addMealFiveDecrementButtonListener(new MealFiveDecrementButtonListener());
        this.summaryView.addMealFiveIncrementButtonListener(new MealFiveIncrementButtonListener());
        this.summaryView.addMealSixDecrementButtonListener(new MealSixDecrementButtonListener());
        this.summaryView.addMealSixIncrementButtonListener(new MealSixIncrementButtonListener());
        this.summaryView.addSideDecrementButtonListener(new SideDecrementButtonListener());
        this.summaryView.addSideIncrementButtonListener(new SideIncrementButtonListener());
        this.summaryView.addDrinkDecrementButtonListener(new DrinkDecrementButtonListener());
        this.summaryView.addDrinkIncrementButtonListener(new DrinkIncrementButtonListener());
        this.summaryView.addBackToMenuButtonListener(new BackToMenuButtonListener());
        this.summaryView.addPayButtonListener(new PayButtonListener());
    }

    private void setTotal()
    {
        Item meal1 = order.getItem(Order.mealOneItemIndex);
        Item meal2 = order.getItem(Order.mealTwoItemIndex);
        Item meal3 = order.getItem(Order.mealThreeItemIndex);
        Item meal4 = order.getItem(Order.mealFourItemIndex);
        Item meal5 = order.getItem(Order.mealFiveItemIndex);
        Item meal6 = order.getItem(Order.mealSixItemIndex);
        Item side = order.getItem(Order.sideItemIndex);
        Item drink = order.getItem(Order.drinkItemIndex);

        summaryView.setTotal(meal1.getAmount(), meal2.getAmount(), meal3.getAmount(), meal4.getAmount(), meal5.getAmount(), meal6.getAmount(), side.getAmount(), drink.getAmount(),
                meal1.getPrice(), meal2.getPrice(), meal3.getPrice(), meal4.getPrice(), meal5.getPrice(), meal6.getPrice(), side.getPrice(), drink.getPrice());
    }

    /**
     * A listener for the meal one decrement button. Decrements the amount for meal one.
     */
    class MealOneDecrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealOne = order.getItem(Order.mealOneItemIndex);
            mealOne.decrementAmount();
            summaryView.setMealOneSummary(mealOne.getAmount(), mealOne.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal one increment button. Increments the amount of meal one.
     */
    class MealOneIncrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealOne = order.getItem(Order.mealOneItemIndex);
            mealOne.incrementAmount();
            summaryView.setMealOneSummary(mealOne.getAmount(), mealOne.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal two decrement button. Decrements the amount of meal two.
     */
    class MealTwoDecrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealTwo = order.getItem(Order.mealTwoItemIndex);
            mealTwo.decrementAmount();
            summaryView.setMealTwoSummary(mealTwo.getAmount(), mealTwo.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal two increment button. Increments the amount of meal two.
     */
    class MealTwoIncrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealTwo = order.getItem(Order.mealTwoItemIndex);
            mealTwo.incrementAmount();
            summaryView.setMealTwoSummary(mealTwo.getAmount(), mealTwo.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal three decrement button. Decrements the amount of meal three.
     */
    class MealThreeDecrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealThree = order.getItem(Order.mealThreeItemIndex);
            mealThree.decrementAmount();
            summaryView.setMealThreeSummary(mealThree.getAmount(), mealThree.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal three increment button. Increments the amount of meal three.
     */
    class MealThreeIncrementButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealThree = order.getItem(Order.mealThreeItemIndex);
            mealThree.incrementAmount();
            summaryView.setMealThreeSummary(mealThree.getAmount(), mealThree.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal four decrement button. Decrements the amount of meal four.
     */
    class MealFourDecrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealFour = order.getItem(Order.mealFourItemIndex);
            mealFour.decrementAmount();
            summaryView.setMealFourSummary(mealFour.getAmount(), mealFour.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal four increment button. Increments the amount of meal four.
     */
    class MealFourIncrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealFour = order.getItem(Order.mealFourItemIndex);
            mealFour.incrementAmount();
            summaryView.setMealFourSummary(mealFour.getAmount(), mealFour.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal five decrement button. Decrements the amount of meal five.
     */
    class MealFiveDecrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealFive = order.getItem(Order.mealFiveItemIndex);
            mealFive.decrementAmount();
            summaryView.setMealFiveSummary(mealFive.getAmount(), mealFive.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal five increment button. Increments the amount of meal five.
     */
    class MealFiveIncrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealFive = order.getItem(Order.mealFiveItemIndex);
            mealFive.incrementAmount();
            summaryView.setMealFiveSummary(mealFive.getAmount(), mealFive.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal six decrement button. Decrements the amount of meal six.
     */
    class MealSixDecrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealSix = order.getItem(Order.mealSixItemIndex);
            mealSix.decrementAmount();
            summaryView.setMealSixSummary(mealSix.getAmount(), mealSix.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the meal six increment button. Increments the amount of meal six.
     */
    class MealSixIncrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item mealSix = order.getItem(Order.mealSixItemIndex);
            mealSix.incrementAmount();
            summaryView.setMealSixSummary(mealSix.getAmount(), mealSix.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the side decrement button. Decrements the amount of side.
     */
    class SideDecrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item side = order.getItem(Order.sideItemIndex);
            side.decrementAmount();
            summaryView.setSideSummary(side.getAmount(), side.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the side increment button. Increments the amount of side.
     */
    class SideIncrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item side = order.getItem(Order.sideItemIndex);
            side.incrementAmount();
            summaryView.setSideSummary(side.getAmount(), side.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the drink decrement button. Decrements the amount of drink.
     */
    class DrinkDecrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item drink = order.getItem(Order.drinkItemIndex);
            drink.decrementAmount();
            summaryView.setDrinkSummary(drink.getAmount(), drink.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the drink increment button. Increments the amount of drink.
     */
    class DrinkIncrementButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Item drink = order.getItem(Order.drinkItemIndex);
            drink.incrementAmount();
            summaryView.setDrinkSummary(drink.getAmount(), drink.getPrice());
            SummaryController.this.setTotal();
        }
    }

    /**
     * A listener for the back to menu button. Moves the user back to the menu screen.
     */
    class BackToMenuButtonListener implements ActionListener
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

            MenuView menuView = new MenuView(mealOneAmount, mealTwoAmount, mealThreeAmount, mealFourAmount, mealFiveAmount, mealSixAmount, sideAmount, drinkAmount);
            MenuController menuController = new MenuController(menuView, order);
            menuView.setVisible(true);
            summaryView.close();
        }
    }

    /**
     * Moves the user to the pay screen.
     */
    class PayButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            PayView payView = new PayView();
            PayController payController = new PayController(payView, order);
            payView.setVisible(true);
            summaryView.close();
        }
    }
}
