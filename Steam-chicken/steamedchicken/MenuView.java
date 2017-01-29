
package steamedchicken;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * A Menu user interface for customers to select what they want to order. Employees can
 * login to see the sales records through the Menu.
 * @author SteamedChicken
 */
public class MenuView extends JFrame
{
    private JButton checkoutButton;
    private JButton mealOneButton;
    private JButton mealTwoButton;
    private JButton mealThreeButton;
    private JButton mealFourButton;
    private JButton mealFiveButton;
    private JButton mealSixButton;
    private JButton sideButton;
    private JButton drinkButton;

    /**
     * Initializes the frame layout and components.
     * @param mealOneAmount amount of meal one
     * @param mealTwoAmount amount of meal two
     * @param mealThreeAmount amount of meal three
     * @param mealFourAmount amount of meal four
     * @param mealFiveAmount amount of meal five
     * @param mealSixAmount amount of meal six
     * @param sideAmount amount of side
     * @param drinkAmount amount of drink
     */
    public MenuView(int mealOneAmount, int mealTwoAmount, int mealThreeAmount,
            int mealFourAmount, int mealFiveAmount, int mealSixAmount,
            int sideAmount, int drinkAmount)
    {
        final int FRAME_HEIGHT = 700;
        final int FRAME_WIDTH = 700;

        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLayout(new BorderLayout());

        JPanel mealsPanel = this.initializeMealPanel(mealOneAmount, mealTwoAmount, mealThreeAmount,
                mealFourAmount, mealFiveAmount, mealSixAmount);
        this.add(mealsPanel, BorderLayout.CENTER);

        JPanel sideAndDrinkPanel = this.initializeSideAndDrinkPanel(sideAmount, drinkAmount);
        this.add(sideAndDrinkPanel, BorderLayout.SOUTH);

        this.setVisible(true);
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
     * Initializes the meal panel and adds all the components.
     *
     * @param mealOneAmount order amount of meal one
     * @param mealTwoAmount order amount of meal two
     * @param mealThreeAmount order amount of meal three
     * @param mealFourAmount order amount of meal four
     * @param mealFiveAmount order amount of meal five
     * @param mealSixAmount order amount of meal six
     * @return meal panel
     */
    private JPanel initializeMealPanel(int mealOneAmount, int mealTwoAmount, int mealThreeAmount,
            int mealFourAmount, int mealFiveAmount, int mealSixAmount)
    {
        final int GRID_MEAL_ROWS = 2;
        final int GRID_MEAL_COLS = 3;

        final String meal1Path = "/images/meal1.jpg";
        final String meal2Path = "/images/meal2.jpeg";
        final String meal3Path = "/images/meal3.jpg";
        final String meal4Path = "/images/meal4.jpg";
        final String meal5Path = "/images/meal5.jpg";
        final String meal6Path = "/images/meal6.jpg";

        JPanel mealsPanel = new JPanel();
        mealsPanel.setLayout(new GridLayout(GRID_MEAL_ROWS, GRID_MEAL_COLS));

        ImageIcon mealOneImageIcon = new ImageIcon(MenuView.class.getResource(meal1Path));
        ImageIcon mealTwoImageIcon = new ImageIcon(MenuView.class.getResource(meal2Path));
        ImageIcon mealThreeImageIcon = new ImageIcon(MenuView.class.getResource(meal3Path));
        ImageIcon mealFourImageIcon = new ImageIcon(MenuView.class.getResource(meal4Path));
        ImageIcon mealFiveImageIcon = new ImageIcon(MenuView.class.getResource(meal5Path));
        ImageIcon mealSixImageIcon = new ImageIcon(MenuView.class.getResource(meal6Path));
        
        String mealOneText = "<html>" + "Steamed Chicken" + "<br>" + "Amount: " + mealOneAmount + "<br>" + "Price: $10";
        String mealTwoText = "<html>" + "BBQ Chicken" + "<br>" + "Amount: " + mealTwoAmount + "<br>" + "Price: $10";
        String mealThreeText = "<html>" + "Lemon Chicken" + "<br>" + "Amount: " + mealThreeAmount + "<br>" + "Price: $10";
        String mealFourText = "<html>" + "Tofu Chicken" + "<br>" + "Amount: " + mealFourAmount + "<br>" + "Price: $10";
        String mealFiveText = "<html>" + "Rotisserie Chicken" + "<br>" + "Amount: " + mealFiveAmount + "<br>" + "Price: $10";
        String mealSixText = "<html>" + "Stuffed Chicken" + "<br>" + "Amount: " + mealSixAmount + "<br>" + "Price: $10";

        mealOneButton = new JButton(mealOneText, mealOneImageIcon);
        mealOneButton.setHorizontalTextPosition(JButton.LEFT);
        mealOneButton.setVerticalTextPosition(JButton.BOTTOM);
        
        mealTwoButton = new JButton(mealTwoText, mealTwoImageIcon);
        mealTwoButton.setHorizontalTextPosition(JButton.LEFT);
        mealTwoButton.setVerticalTextPosition(JButton.BOTTOM);
        
        mealThreeButton = new JButton(mealThreeText, mealThreeImageIcon);
        mealThreeButton.setHorizontalTextPosition(JButton.LEFT);
        mealThreeButton.setVerticalTextPosition(JButton.BOTTOM);
        
        mealFourButton = new JButton(mealFourText, mealFourImageIcon);
        mealFourButton.setHorizontalTextPosition(JButton.LEFT);
        mealFourButton.setVerticalTextPosition(JButton.BOTTOM);
        
        mealFiveButton = new JButton(mealFiveText, mealFiveImageIcon);
        mealFiveButton.setHorizontalTextPosition(JButton.LEFT);
        mealFiveButton.setVerticalTextPosition(JButton.BOTTOM);
        
        mealSixButton = new JButton(mealSixText, mealSixImageIcon);
        mealSixButton.setHorizontalTextPosition(JButton.LEFT);
        mealSixButton.setVerticalTextPosition(JButton.BOTTOM);

        mealsPanel.add(mealOneButton);
        mealsPanel.add(mealTwoButton);
        mealsPanel.add(mealThreeButton);
        mealsPanel.add(mealFourButton);
        mealsPanel.add(mealFiveButton);
        mealsPanel.add(mealSixButton);

        return mealsPanel;
    }

    /**
     * Initializes the side and drink panel and adds components.
     * @param sideAmount order amount of side
     * @param drinkAmount or amount of drink
     * @return sideAndDrink panel
     */
    private JPanel initializeSideAndDrinkPanel(int sideAmount, int drinkAmount)
    {
        final int GRID_SIDE_AND_DRINK_ROWS = 1;
        final int GRID_SIDE_AND_DRINK_COLS = 2;

        final String sidePath = "/images/side.jpg";
        final String drinkPath = "/images/drink.png";
        final String checkoutPath = "/images/checkout.png";
        final String checkoutButtonText = "Checkout";

        final ImageIcon sideImageIcon = new ImageIcon(MenuView.class.getResource(sidePath));
        final ImageIcon drinkImageIcon = new ImageIcon(MenuView.class.getResource(drinkPath));
        final ImageIcon checkoutImageIcon = new ImageIcon(MenuView.class.getResource(checkoutPath));
        
        String sideButtonText = "<html>" + "Side" + "<br>" + "Amount: " + sideAmount + "<br>" + "Price: $2";
        String drinkButtonText = "<html>" + "Drink" + "<br>" + "Amount: " + drinkAmount + "<br>" + "Price: $1";
        
        JPanel sideAndDrinkPanel = new JPanel();
        sideAndDrinkPanel.setLayout(new GridLayout(GRID_SIDE_AND_DRINK_ROWS, GRID_SIDE_AND_DRINK_COLS));   

        sideButton = new JButton(sideButtonText, sideImageIcon);
        sideButton.setHorizontalTextPosition(JButton.LEFT);
        sideButton.setVerticalTextPosition(JButton.BOTTOM);

        drinkButton = new JButton(drinkButtonText, drinkImageIcon);
        drinkButton.setHorizontalTextPosition(JButton.LEFT);
        drinkButton.setVerticalTextPosition(JButton.BOTTOM);

        sideAndDrinkPanel.add(sideButton);
        sideAndDrinkPanel.add(drinkButton);

        checkoutButton = new JButton(checkoutButtonText, checkoutImageIcon);

        sideAndDrinkPanel.add(checkoutButton);

        return sideAndDrinkPanel;
    }

    /**
     * Adds an ActionListener for mealOneButton.
     * @param listenForMealOneButton ActionListener for mealOneButton
     */
    public void addMealOneButtonListener(ActionListener listenForMealOneButton)
    {
        mealOneButton.addActionListener(listenForMealOneButton);
    }

    /**
     * Adds an ActionListener for mealTwoButton.
     * @param listenForMealTwoButton ActionListener for mealTwoButton
     */
    public void addMealTwoButtonListener(ActionListener listenForMealTwoButton)
    {
        mealTwoButton.addActionListener(listenForMealTwoButton);
    }

    /**
     * Adds an ActionListener for mealThreeButton.
     * @param listenForMealThreeButton ActionListener for mealThreeButton
     */
    public void addMealThreeButtonListener(ActionListener listenForMealThreeButton)
    {
        mealThreeButton.addActionListener(listenForMealThreeButton);
    }

    /**
     * Adds an ActionListener for mealFourButton.
     * @param listenForMealFourButton ActionListener for mealFourButton
     */
    public void addMealFourButtonListener(ActionListener listenForMealFourButton)
    {
        mealFourButton.addActionListener(listenForMealFourButton);
    }

    /**
     * Adds an ActionListener for mealFiveButton.
     * @param listenForMealFiveButton ActionListener for mealFiveButton
     */
    public void addMealFiveButtonListener(ActionListener listenForMealFiveButton)
    {
        mealFiveButton.addActionListener(listenForMealFiveButton);
    }

    /**
     * Adds an ActionListener for mealSixButton.
     * @param listenForMealSixButton ActionListener for mealSixButton
     */
    public void addMealSixButtonListener(ActionListener listenForMealSixButton)
    {
        mealSixButton.addActionListener(listenForMealSixButton);
    }

    /**
     * Adds an ActionListener for checkoutButton.
     * @param listenForCheckoutButton ActionListener for checkoutButton
     */
    public void addCheckoutButtonListener(ActionListener listenForCheckoutButton)
    {
        checkoutButton.addActionListener(listenForCheckoutButton);
    }

    /**
     * Adds an ActionListener for sideButton.
     * @param listenForSideButton ActionListener for sideButton
     */
    public void addSideButtonListener(ActionListener listenForSideButton)
    {
        sideButton.addActionListener(listenForSideButton);
    }

    /**
     * Adds an ActionListener for drinkButton
     * @param listenForDrinkButton ActionListener for drinkButton
     */
    public void addDrinkButtonListener(ActionListener listenForDrinkButton)
    {
        drinkButton.addActionListener(listenForDrinkButton);
    }

    /**
     * Adds a KeyListener for the admin login.
     * @param listenForAdminLoginKeyListener KeyListener for the admin login
     */
    public void addAdminLoginKeyListener(KeyListener listenForAdminLoginKeyListener)
    {
        checkoutButton.addKeyListener(listenForAdminLoginKeyListener);
        mealOneButton.addKeyListener(listenForAdminLoginKeyListener);
        mealTwoButton.addKeyListener(listenForAdminLoginKeyListener);
        mealThreeButton.addKeyListener(listenForAdminLoginKeyListener);
        mealFourButton.addKeyListener(listenForAdminLoginKeyListener);
        mealFiveButton.addKeyListener(listenForAdminLoginKeyListener);
        mealSixButton.addKeyListener(listenForAdminLoginKeyListener);
        sideButton.addKeyListener(listenForAdminLoginKeyListener);
        drinkButton.addKeyListener(listenForAdminLoginKeyListener);
    }

    /**
     * Sets the text for mealOneButton.
     * @param mealOneAmount order amount of mealOne
     */
    public void setMealOneText(int mealOneAmount)
    {
        final String mealOneText = "<html>" + "Steamed Chicken" + "<br>" + "Amount: " + mealOneAmount + "<br>" + "Price: $10";
        mealOneButton.setText(mealOneText);
    }

    /**
     * Sets the text for mealTwoButton.
     * @param mealTwoAmount order amount of mealTwo
     */
    public void setMealTwoText(int mealTwoAmount)
    {
        final String mealTwoText = "<html>" + "BBQ Chicken" + "<br>" + "Amount: " + mealTwoAmount + "<br>" + "Price: $10";
        mealTwoButton.setText(mealTwoText);
    }

    /**
     * Sets the text for mealThreeButton.
     * @param mealThreeAmount order amount of mealThree
     */
    public void setMealThreeText(int mealThreeAmount)
    {
        final String mealThreeText = "<html>" + "Lemon Chicken" + "<br>" + "Amount: " + mealThreeAmount + "<br>" + "Price: $10";
        mealThreeButton.setText(mealThreeText);
    }

    /**
     * Sets the text for mealFourButton.
     * @param mealFourAmount order amount of mealFour
     */
    public void setMealFourText(int mealFourAmount)
    {
        final String mealFourText = "<html>" + "Tofu Chicken" + "<br>" + "Amount: " + mealFourAmount + "<br>" + "Price: $10";
        mealFourButton.setText(mealFourText);
    }

    /**
     * Sets the text for mealFiveButton.
     * @param mealFiveAmount order amount of mealFive
     */
    public void setMealFiveText(int mealFiveAmount)
    {
        final String mealFiveText = "<html>" + "Rotisserie Chicken" + "<br>" + "Amount: " + mealFiveAmount + "<br>" + "Price: $10";
        mealFiveButton.setText(mealFiveText);
    }

    /**
     * Sets the text for mealSixButton.
     * @param mealSixAmount order amount of mealSix
     */
    public void setMealSixText(int mealSixAmount)
    {
        final String mealSixText = "<html>" + "Stuffed Chicken" + "<br>" + "Amount: " + mealSixAmount + "<br>" + "Price: $10";
        mealSixButton.setText(mealSixText);
    }

    /**
     * Sets the text for sideButton.
     * @param sideAmount order amount of side
     */
    public void setSideText(int sideAmount)
    {
        final String sideText = "<html>" + "Mashed Potatoes" + "<br>" + "Amount: " + sideAmount + "<br>" + "Price: $2";
        sideButton.setText(sideText);
    }

    /**
     * Sets the text for drinkButton
     * @param drinkAmount order amount of drink
     */
    public void setDrinkText(int drinkAmount)
    {
        final String drinkText = "<html>" + "Drink" + "<br>" + "Amount: " + drinkAmount + "<br>" + "Price: $1";
        drinkButton.setText(drinkText);
    }
}