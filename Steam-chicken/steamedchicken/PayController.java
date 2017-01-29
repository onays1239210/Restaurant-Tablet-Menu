
package steamedchicken;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 * Handles user input from the PayView and updates data in the order.
 * @author SteamedChicken
 */
public class PayController
{
    PayView payView;
    Order order;

    /**
     * Gets references to the payView and Order and adds listeners to the pay screen.
     * @param payView the payView that the payController handles user input from
     * @param order the order that the user is selecting
     */
    public PayController(PayView payView, Order order)
    {
        this.payView = payView;
        this.order = order;

        this.payView.addBackButtonListener(new BackButtonListener());
        this.payView.addPayButtonListener(new PayButtonListener());
    }
    
    /**
     * Gets the text to put on the receipt.
     * @return the text to put on the receipt
     */
    public String getReceiptText()
    {
        String result = "";
        Date date = new Date();    
        BigDecimal total = new BigDecimal(0);
        
        String receiptTitle = "Receipt     " + date.toString() + System.lineSeparator();
        result += receiptTitle;
        for (int i = 0; i < Order.numberOfItems; i++)
        {
            Item currentItem = order.getItem(i);
            int currentAmount = currentItem.getAmount();
            BigDecimal currentPrice = new BigDecimal(currentAmount).multiply(currentItem.getPrice());
            if (currentAmount > 0)
            {
                String currentLine = System.lineSeparator() + currentItem.getName() + "   Amount: " + currentAmount + "   Price: " + currentPrice.toString();
                result += currentLine;
                total = total.add(currentPrice);
            }
        }
        
        String totalLine = System.lineSeparator() + System.lineSeparator() + "Total:   " + total.toString();
        result += totalLine;
        
        return result;
    }

    /**
     * Listener for the back button. Moves the user back to the summary screen.
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

            SummaryView summaryView = new SummaryView(mealOneAmount, mealTwoAmount, mealThreeAmount, mealFourAmount, mealFiveAmount, mealSixAmount, sideAmount, drinkAmount,
                    mealOnePrice, mealTwoPrice, mealThreePrice, mealFourPrice, mealFivePrice, mealSixPrice, sidePrice, drinkPrice);
            SummaryController summaryController = new SummaryController(summaryView, order);
            summaryView.setVisible(true);
            payView.close();
        }

    }

    /**
     * Button listener for the pay button. Shows a JOptionPane for the user to input
     * their card number.
     */
    class PayButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane payOptionPane = new JOptionPane();

            String inputValue = payOptionPane.showInputDialog("Input card number");

            if (inputValue != null)
            {
                payView.initCustomerPayed();

                PayController.this.payView.addPrintReceiptButtonListener(new PrintReceiptButtonListener());
                PayController.this.payView.addDoneButtonListener(new DoneButtonListener());
            }
        }
    }

    /**
     * Listener for the print receipt button. Shows a text file with order information.
     */
    class PrintReceiptButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String receiptFilePath = "K:\\java CS 151\\Steam-chicken\\steamedchicken\\receipt.txt";
            
            // TODO: Add a relative path to receipt.txt
            // final String receiptPath = "/receipt/receipt.txt";
            File receiptFile = new File(receiptFilePath);
            
            try
            {
                BufferedWriter bw = new BufferedWriter(new FileWriter(receiptFile));
                String result = PayController.this.getReceiptText();
                bw.write(result);
                bw.close();
                Desktop.getDesktop().open(new File(receiptFilePath));
            } 
            catch (IOException ex1)
            {
                ex1.printStackTrace();
            }
            catch (Exception ex2)
            {
                ex2.printStackTrace();
            }
        }
    }

    /**
     * Listener for the done button. Saves the order information in the database.
     * Cleans the order state and moves back to the menu screen.
     */
    class DoneButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Connection con;
            PreparedStatement pst;

            final String dbPath = "/db/steamedchicken.sqlite";

            Date date = new Date();

            Item meal1 = order.getItem(Order.mealOneItemIndex);
            Item meal2 = order.getItem(Order.mealTwoItemIndex);
            Item meal3 = order.getItem(Order.mealThreeItemIndex);
            Item meal4 = order.getItem(Order.mealFourItemIndex);
            Item meal5 = order.getItem(Order.mealFiveItemIndex);
            Item meal6 = order.getItem(Order.mealSixItemIndex);
            Item side = order.getItem(Order.sideItemIndex);
            Item drink = order.getItem(Order.drinkItemIndex);

            int meal1Amount = meal1.getAmount();
            int meal2Amount = meal2.getAmount();
            int meal3Amount = meal3.getAmount();
            int meal4Amount = meal4.getAmount();
            int meal5Amount = meal5.getAmount();
            int meal6Amount = meal6.getAmount();
            int sideAmount = side.getAmount();
            int drinkAmount = drink.getAmount();

            BigDecimal meal1Price = meal1.getPrice();
            BigDecimal meal2Price = meal2.getPrice();
            BigDecimal meal3Price = meal3.getPrice();
            BigDecimal meal4Price = meal4.getPrice();
            BigDecimal meal5Price = meal5.getPrice();
            BigDecimal meal6Price = meal6.getPrice();
            BigDecimal sidePrice = side.getPrice();
            BigDecimal drinkPrice = drink.getPrice();

            double total = meal1Amount * meal1Price.doubleValue() + meal2Amount * meal2Price.doubleValue() + meal3Amount * meal3Price.doubleValue()
                    + meal4Amount * meal4Price.doubleValue() + meal5Amount * meal5Price.doubleValue() + meal6Amount * meal6Price.doubleValue()
                    + sideAmount * sidePrice.doubleValue() + drinkAmount * drinkPrice.doubleValue();

            try
            {
                String JDBCForName = "org.sqlite.JDBC";
                String sqlText = "INSERT INTO Sales (date, mealoneamount, mealtwoamount, mealthreeamount, mealfouramount, mealfiveamount, mealsixamount, sideamount, drinkamount, total)"
                        + "VALUES ('" + date + "', '" + meal1Amount + "', '" + meal2Amount + "', '" + meal3Amount + "', '" + meal4Amount + "', '" + meal5Amount + "', '" + meal6Amount + "', '" + sideAmount + "', '" + drinkAmount + "', '" + total + "')";
                String dbConnection = "jdbc:sqlite:K:\\java CS 151\\Steam-chicken\\db\\steamedchicken.sqlite";
                
                Class.forName(JDBCForName);
                // TODO: relative path
                con = DriverManager.getConnection(dbConnection);
                String sql = sqlText;
                pst = con.prepareStatement(sql);
                pst.execute();

                con.close();
                pst.close();
            } 
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            // can create a method for this 
            // cleans the order state and moves back to the menu screen
            Order newOrder = new Order();

            MenuView menuView = new MenuView(0, 0, 0, 0, 0, 0, 0, 0);
            MenuController menuController = new MenuController(menuView, newOrder);

            menuView.setVisible(true);
            payView.close();
        }
    }
}
