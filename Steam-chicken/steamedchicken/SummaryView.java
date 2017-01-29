
package steamedchicken;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import javax.swing.*;

/**
 * A summary user interface for customers to edit and see their order.
 * @author Steamed Chicken
 */
public class SummaryView extends JFrame
{
    private Order order;

    private int mealOneAmount;
    private int mealTwoAmount;
    private int mealThreeAmount;
    private int mealFourAmount;
    private int mealFiveAmount;
    private int mealSixAmount;
    private int sideAmount;
    private int drinkAmount;

    private JButton mealOneDecrementButton;
    private JButton mealOneIncrementButton;
    private JLabel mealOneSummaryLabel;

    private JButton mealTwoDecrementButton;
    private JButton mealTwoIncrementButton;
    private JLabel mealTwoSummaryLabel;

    private JButton mealThreeDecrementButton;
    private JButton mealThreeIncrementButton;
    private JLabel mealThreeSummaryLabel;

    private JButton mealFourDecrementButton;
    private JButton mealFourIncrementButton;
    private JLabel mealFourSummaryLabel;

    private JButton mealFiveDecrementButton;
    private JButton mealFiveIncrementButton;
    private JLabel mealFiveSummaryLabel;

    private JButton mealSixDecrementButton;
    private JButton mealSixIncrementButton;
    private JLabel mealSixSummaryLabel;

    private JButton sideDecrementButton;
    private JButton sideIncrementButton;
    private JLabel sideSummaryLabel;

    private JButton drinkDecrementButton;
    private JButton drinkIncrementButton;
    private JLabel drinkSummaryLabel;
    
    private JButton backToMenuButton;
    private JButton payButton;
    
    JLabel totalLabel = new JLabel();

    /**
     * Initializes panels and adds them to the summary view
     * @param mealOneAmount the amount of meal one
     * @param mealTwoAmount the amount of meal two
     * @param mealThreeAmount the amount of meal three
     * @param mealFourAmount the amount of meal four
     * @param mealFiveAmount the amount of meal five
     * @param mealSixAmount the amount of meal six
     * @param sideAmount the amount of sides
     * @param drinkAmount the amount of drinks
     * @param mealOnePrice the price of meal one
     * @param mealTwoPrice the price of meal two
     * @param mealThreePrice the price of meal three
     * @param mealFourPrice the price of meal four
     * @param mealFivePrice the price of meal five
     * @param mealSixPrice the price of meal six
     * @param sidePrice the price of the side
     * @param drinkPrice the price of the drink
     */
    public SummaryView(int mealOneAmount, int mealTwoAmount, int mealThreeAmount,
            int mealFourAmount, int mealFiveAmount, int mealSixAmount,
            int sideAmount, int drinkAmount,
            BigDecimal mealOnePrice, BigDecimal mealTwoPrice, BigDecimal mealThreePrice, BigDecimal mealFourPrice, BigDecimal mealFivePrice, BigDecimal mealSixPrice, BigDecimal sidePrice, BigDecimal drinkPrice)
    {
        final int FRAME_HEIGHT = 700;
        final int FRAME_WIDTH = 700;

        this.order = order;

        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLayout(new BorderLayout());

        JPanel summaryPanel = this.initializeSummaryPanel(mealOneAmount, mealTwoAmount, mealThreeAmount, mealFourAmount, mealFiveAmount, mealSixAmount, sideAmount, drinkAmount,
                mealOnePrice, mealTwoPrice, mealThreePrice, mealFourPrice, mealFivePrice, mealSixPrice, sidePrice, drinkPrice);

        this.add(summaryPanel, BorderLayout.NORTH);
        
        JPanel navigationPanel = this.initializeNavigationPanel();
        
        this.add(navigationPanel, BorderLayout.SOUTH);
        
        JPanel priceSummaryPanel = this.initializePriceSummaryPanel(mealOneAmount, mealTwoAmount, mealThreeAmount, mealFourAmount, mealFiveAmount, mealSixAmount, sideAmount, drinkAmount,
                mealOnePrice, mealTwoPrice, mealThreePrice, mealFourPrice, mealFivePrice, mealSixPrice, sidePrice, drinkPrice);
        
        this.add(priceSummaryPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    private JPanel initializeSummaryPanel(int mealOneAmount, int mealTwoAmount, int mealThreeAmount, int mealFourAmount, int mealFiveAmount, int mealSixAmount, int sideAmount, int drinkAmount,
            BigDecimal mealOnePrice, BigDecimal mealTwoPrice, BigDecimal mealThreePrice, BigDecimal mealFourPrice, BigDecimal mealFivePrice, BigDecimal mealSixPrice, BigDecimal sidePrice, BigDecimal drinkPrice)
    {
        // library implementation error? could not use 7 rows without it outputing something weird
        final int GRID_SUMMARY_ROWS = 0; //7
        final int GRID_SUMMARY_COLS = 3; //3

        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(new GridLayout(GRID_SUMMARY_ROWS, GRID_SUMMARY_COLS));

        mealOneDecrementButton = new JButton("-");
        mealOneIncrementButton = new JButton("+");
        mealOneSummaryLabel = new JLabel("Steamed Chicken  -  Amount: " + mealOneAmount + "  -  Price: " + mealOnePrice.multiply(new BigDecimal(mealOneAmount)));

        summaryPanel.add(mealOneDecrementButton);
        summaryPanel.add(mealOneIncrementButton);
        summaryPanel.add(mealOneSummaryLabel);

        mealTwoDecrementButton = new JButton("-");
        mealTwoIncrementButton = new JButton("+");
        mealTwoSummaryLabel = new JLabel("BBQ Chicken  -  Amount: " + mealTwoAmount + "  -  Price: " + mealTwoPrice.multiply(new BigDecimal(mealTwoAmount)));

        summaryPanel.add(mealTwoDecrementButton);
        summaryPanel.add(mealTwoIncrementButton);
        summaryPanel.add(mealTwoSummaryLabel);

        mealThreeDecrementButton = new JButton("-");
        mealThreeIncrementButton = new JButton("+");
        mealThreeSummaryLabel = new JLabel("Lemon Chicken  -  Amount: " + mealThreeAmount + "  -  Price: " + mealThreePrice.multiply(new BigDecimal(mealThreeAmount)));

        summaryPanel.add(mealThreeDecrementButton);
        summaryPanel.add(mealThreeIncrementButton);
        summaryPanel.add(mealThreeSummaryLabel);

        mealFourDecrementButton = new JButton("-");
        mealFourIncrementButton = new JButton("+");
        mealFourSummaryLabel = new JLabel("Tofu Chicken  -  Amount: " + mealFourAmount + "  -  Price: " + mealFourPrice.multiply(new BigDecimal(mealFourAmount)));

        summaryPanel.add(mealFourDecrementButton);
        summaryPanel.add(mealFourIncrementButton);
        summaryPanel.add(mealFourSummaryLabel);

        mealFiveDecrementButton = new JButton("-");
        mealFiveIncrementButton = new JButton("+");
        mealFiveSummaryLabel = new JLabel("Rotisserie Chicken  -  Amount: " + mealFiveAmount + "  -  Price: " + mealFivePrice.multiply(new BigDecimal(mealFiveAmount)));

        summaryPanel.add(mealFiveDecrementButton);
        summaryPanel.add(mealFiveIncrementButton);
        summaryPanel.add(mealFiveSummaryLabel);

        mealSixDecrementButton = new JButton("-");
        mealSixIncrementButton = new JButton("+");
        mealSixSummaryLabel = new JLabel("Stuffed Chicken  -  Amount: " + mealSixAmount + "  -  Price: " + mealSixPrice.multiply(new BigDecimal(mealSixAmount)));

        summaryPanel.add(mealSixDecrementButton);
        summaryPanel.add(mealSixIncrementButton);
        summaryPanel.add(mealSixSummaryLabel);

        sideDecrementButton = new JButton("-");
        sideIncrementButton = new JButton("+");
        sideSummaryLabel = new JLabel("Mash Potatoes  -  Amount: " + sideAmount + "  -  Price: " + sidePrice.multiply(new BigDecimal(sideAmount)));

        summaryPanel.add(sideDecrementButton);
        summaryPanel.add(sideIncrementButton);
        summaryPanel.add(sideSummaryLabel);

        drinkDecrementButton = new JButton("-");
        drinkIncrementButton = new JButton("+");
        drinkSummaryLabel = new JLabel("Drink  -  Amount: " + drinkAmount + "  -  Price: " + drinkPrice.multiply(new BigDecimal(drinkAmount)));


        summaryPanel.add(drinkDecrementButton);
        summaryPanel.add(drinkIncrementButton);
        summaryPanel.add(drinkSummaryLabel);

        return summaryPanel;
    }
    
    private JPanel initializeNavigationPanel()
    {
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new FlowLayout());
        
        backToMenuButton = new JButton("Back");
        
        payButton = new JButton("Pay");
        
        navigationPanel.add(backToMenuButton);
        navigationPanel.add(payButton);
        
        return navigationPanel;
    }
    
    private JPanel initializePriceSummaryPanel(int mealOneAmount, int mealTwoAmount, int mealThreeAmount, int mealFourAmount, int mealFiveAmount, int mealSixAmount, int sideAmount, int drinkAmount,
            BigDecimal mealOnePrice, BigDecimal mealTwoPrice, BigDecimal mealThreePrice, BigDecimal mealFourPrice, BigDecimal mealFivePrice, BigDecimal mealSixPrice, BigDecimal sidePrice, BigDecimal drinkPrice)
    {
        JPanel priceSummaryPanel = new JPanel();
        priceSummaryPanel.setLayout(new FlowLayout());
        
        this.setTotal(mealOneAmount, mealTwoAmount, mealThreeAmount, mealFourAmount, mealFiveAmount, mealSixAmount, sideAmount, drinkAmount, 
                mealOnePrice, mealTwoPrice, mealThreePrice, mealFourPrice, mealFivePrice, mealSixPrice, sidePrice, drinkPrice);
        
        priceSummaryPanel.add(totalLabel);
        
        return priceSummaryPanel;
    }
    
    /**
     * Closes this frame.
     */
    public void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    /**
     * Adds a listener for meal one decrement button.
     * @param listenForMealOneDecrementButton listener for meal one decrement button
     */
    public void addMealOneDecrementButtonListener(ActionListener listenForMealOneDecrementButton)
    {
        mealOneDecrementButton.addActionListener(listenForMealOneDecrementButton);
    }
    
    /**
     * Adds a listener for meal one increment button.
     * @param listenForMealOneIncrementButton listener for meal one increment button
     */
    public void addMealOneIncrementButtonListener(ActionListener listenForMealOneIncrementButton)
    {
        mealOneIncrementButton.addActionListener(listenForMealOneIncrementButton);
    }
    
    /**
     * Adds a listener for meal two decrement button.
     * @param listenForMealTwoDecrementButton listener for meal two decrement button
     */
    public void addMealTwoDecrementButtonListener(ActionListener listenForMealTwoDecrementButton)
    {
        mealTwoDecrementButton.addActionListener(listenForMealTwoDecrementButton);
    }
    
    /**
     * Adds a listener for meal two increment button.
     * @param listenForMealTwoIncrementButton listener for meal two increment button
     */
    public void addMealTwoIncrementButtonListener(ActionListener listenForMealTwoIncrementButton)
    {
        mealTwoIncrementButton.addActionListener(listenForMealTwoIncrementButton);
    }
    
    /**
     * Adds a listener for meal three decrement button
     * @param listenForMealThreeDecrementButton listener for meal three decrement button
     */
    public void addMealThreeDecrementButtonListener(ActionListener listenForMealThreeDecrementButton)
    {
        mealThreeDecrementButton.addActionListener(listenForMealThreeDecrementButton);
    }
    
    /**
     * Adds a listener for meal three increment button
     * @param listenForMealThreeIncrementButton listener for meal three increment button
     */
    public void addMealThreeIncrementButtonListener(ActionListener listenForMealThreeIncrementButton)
    {
        mealThreeIncrementButton.addActionListener(listenForMealThreeIncrementButton);
    }
    
    /**
     * Adds a listener for meal four decrement button.
     * @param listenForMealFourDecrementButton listener for meal four decrement button
     */
    public void addMealFourDecrementButtonListener(ActionListener listenForMealFourDecrementButton)
    {
        mealFourDecrementButton.addActionListener(listenForMealFourDecrementButton);
    }
    
    /**
     * Adds a listener for meal four increment button.
     * @param listenForMealFourIncrementButton listener for meal for increment button
     */
    public void addMealFourIncrementButtonListener(ActionListener listenForMealFourIncrementButton)
    {
        mealFourIncrementButton.addActionListener(listenForMealFourIncrementButton);
    }
    
    /**
     * Adds a listener for meal five decrement button
     * @param listenForMealFiveDecrementButton listener for meal five decrement button
     */
    public void addMealFiveDecrementButtonListener(ActionListener listenForMealFiveDecrementButton)
    {
        mealFiveDecrementButton.addActionListener(listenForMealFiveDecrementButton);
    }
    
    /**
     * Adds a listener for meal five increment button
     * @param listenForMealFiveIncrementButton listener for meal five increment button
     */
    public void addMealFiveIncrementButtonListener(ActionListener listenForMealFiveIncrementButton)
    {
        mealFiveIncrementButton.addActionListener(listenForMealFiveIncrementButton);
    }
    
    /**
     * Adds a listener for meal six decrement button.
     * @param listenForMealSixDecrementButton listener for meal six decrement button
     */
    public void addMealSixDecrementButtonListener(ActionListener listenForMealSixDecrementButton)
    {
        mealSixDecrementButton.addActionListener(listenForMealSixDecrementButton);
    }
    
    /**
     * Adds a listener for meal six increment button.
     * @param listenForMealSixIncrementButton listener for meal six increment button
     */
    public void addMealSixIncrementButtonListener(ActionListener listenForMealSixIncrementButton)
    {
        mealSixIncrementButton.addActionListener(listenForMealSixIncrementButton);
    }
    
    /**
     * Adds a listener for the side decrement button.
     * @param listenForSideDecrementButton listener for side decrement button
     */
    public void addSideDecrementButtonListener(ActionListener listenForSideDecrementButton)
    {
        sideDecrementButton.addActionListener(listenForSideDecrementButton);
    }
    
    /**
     * Adds a listener for the side increment button.
     * @param listenForSideIncrementButton listener for side increment button
     */
    public void addSideIncrementButtonListener(ActionListener listenForSideIncrementButton)
    {
        sideIncrementButton.addActionListener(listenForSideIncrementButton);
    }

    
    /**
     * Adds a listener for the drink decrement button.
     * @param listenForDrinkDecrementButton listener for the drink decrement button
     */
    public void addDrinkDecrementButtonListener(ActionListener listenForDrinkDecrementButton)
    {
    	drinkDecrementButton.addActionListener(listenForDrinkDecrementButton);
    }
    
    /**
     * Adds a listener for the drink increment button.
     * @param listenForDrinkIncrementButton listener for the drink increment button
     */
    public void addDrinkIncrementButtonListener(ActionListener listenForDrinkIncrementButton)
    {
        drinkIncrementButton.addActionListener(listenForDrinkIncrementButton);
    }
    
    /**
     * Adds a listener for the back button.
     * @param listenForBackToMenuButton listener for the back button
     */
    public void addBackToMenuButtonListener(ActionListener listenForBackToMenuButton)
    {
        backToMenuButton.addActionListener(listenForBackToMenuButton);
    }
    
    /**
     * Adds a listener for the pay button.
     * @param listenForPayButton listener for the pay button
     */
    public void addPayButtonListener(ActionListener listenForPayButton)
    {
        payButton.addActionListener(listenForPayButton);
    }
    
    /**
     * Sets the text for meal one summary.
     * @param mealOneAmount amount of meal one
     * @param mealOnePrice price of meal one
     */
    public void setMealOneSummary(int mealOneAmount, BigDecimal mealOnePrice)
    {
        mealOneSummaryLabel.setText("Meal One  -  Amount: " + mealOneAmount + "  -  Price: $" + mealOnePrice.multiply(new BigDecimal(mealOneAmount)));
    }
    
    /**
     * Sets the text for meal two summary.
     * @param mealTwoAmount amount of meal two
     * @param mealTwoPrice price of meal two
     */
    public void setMealTwoSummary(int mealTwoAmount, BigDecimal mealTwoPrice)
    {
        mealTwoSummaryLabel.setText("Meal Two  -  Amount: " + mealTwoAmount + "  -  Price: $" + mealTwoPrice.multiply(new BigDecimal(mealTwoAmount)));
    }
    
    /**
     * Sets the text for meal three summary.
     * @param mealThreeAmount amount of meal three
     * @param mealThreePrice price of meal three
     */
    public void setMealThreeSummary(int mealThreeAmount, BigDecimal mealThreePrice)
    {
    	mealThreeSummaryLabel.setText("Meal Three  -  Amount: " + mealThreeAmount + "   - Price: $" + mealThreePrice.multiply(new BigDecimal(mealThreeAmount)));
    }
    
    /**
     * Sets the text for meal four summary.
     * @param mealFourAmount amount of meal four
     * @param mealFourPrice price of meal four
     */
    public void setMealFourSummary(int mealFourAmount, BigDecimal mealFourPrice)
    {
        mealFourSummaryLabel.setText("Meal Four  -  Amount: " + mealFourAmount + "  -  Price: $" + mealFourPrice.multiply(new BigDecimal(mealFourAmount)));
    }
    
    /**
     * Sets the text for meal five summary.
     * @param mealFiveAmount amount of meal five
     * @param mealFivePrice price of meal five
     */
    public void setMealFiveSummary(int mealFiveAmount, BigDecimal mealFivePrice)
    {
        mealFiveSummaryLabel.setText("Meal Five  -  Amount: " + mealFiveAmount + "  -  Price: $" + mealFivePrice.multiply(new BigDecimal(mealFiveAmount)));
    }
    
    /**
     * Sets the text for meal six summary.
     * @param mealSixAmount amount of meal six
     * @param mealSixPrice price of meal six
     */
    public void setMealSixSummary(int mealSixAmount, BigDecimal mealSixPrice)
    {
        mealSixSummaryLabel.setText("Meal Six  -  Amount: " + mealSixAmount + "  -  Price: $" + mealSixPrice.multiply(new BigDecimal(mealSixAmount)));
    }
    
    /**
     * Sets the text for side summary.
     * @param sideAmount amount of side
     * @param sidePrice price of side
     */
    public void setSideSummary(int sideAmount, BigDecimal sidePrice)
    {
    	sideSummaryLabel.setText("Side  -  Amount: " + sideAmount + "  -  Price: $" + sidePrice.multiply(new BigDecimal(sideAmount)));
    }
    
    /**
     * Sets the text for drink summary.
     * @param drinkAmount amount of drink
     * @param drinkPrice price of drink
     */
    public void setDrinkSummary(int drinkAmount, BigDecimal drinkPrice)
    {
    	drinkSummaryLabel.setText("Drink  -  Amount; " + drinkAmount + "  -  Price; $" + drinkPrice.multiply(new BigDecimal(drinkAmount)));
    }
    
    /**
     * Sets the total.
     * @param mealOneAmount amount of meal one
     * @param mealTwoAmount amount of meal two
     * @param mealThreeAmount amount of meal three
     * @param mealFourAmount amount of meal four
     * @param mealFiveAmount amount of meal five
     * @param mealSixAmount amount of meal six
     * @param sideAmount amount of side
     * @param drinkAmount amount of drink
     * @param mealOnePrice price of meal one
     * @param mealTwoPrice price of meal two
     * @param mealThreePrice price of meal three
     * @param mealFourPrice price of meal four
     * @param mealFivePrice price of meal five
     * @param mealSixPrice price of meal six
     * @param sidePrice price of side
     * @param drinkPrice price of drink
     */
    public void setTotal(int mealOneAmount, int mealTwoAmount, int mealThreeAmount, int mealFourAmount, int mealFiveAmount, int mealSixAmount, int sideAmount, int drinkAmount,
            BigDecimal mealOnePrice, BigDecimal mealTwoPrice, BigDecimal mealThreePrice, BigDecimal mealFourPrice, BigDecimal mealFivePrice, BigDecimal mealSixPrice, BigDecimal sidePrice, BigDecimal drinkPrice)
    {
        BigDecimal mealOneTotal = new BigDecimal(mealOneAmount).multiply(mealOnePrice);
        BigDecimal mealTwoTotal = new BigDecimal(mealTwoAmount).multiply(mealTwoPrice);
        BigDecimal mealThreeTotal = new BigDecimal(mealThreeAmount).multiply(mealThreePrice);
        BigDecimal mealFourTotal = new BigDecimal(mealFourAmount).multiply(mealFourPrice);
        BigDecimal mealFiveTotal = new BigDecimal(mealFiveAmount).multiply(mealFivePrice);
        BigDecimal mealSixTotal = new BigDecimal(mealSixAmount).multiply(mealSixPrice);
        BigDecimal sideTotal = new BigDecimal(sideAmount).multiply(sidePrice);
        BigDecimal drinkTotal = new BigDecimal(drinkAmount).multiply(drinkPrice);
        BigDecimal total = mealOneTotal.add(mealTwoTotal).add(mealThreeTotal).add(mealFourTotal).add(mealFiveTotal).add(mealSixTotal).add(sideTotal).add(drinkTotal);
        
        totalLabel.setText("Total: " + total.toString());
    }
}
