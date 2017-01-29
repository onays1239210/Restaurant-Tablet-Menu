
package steamedchicken;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * A pay user interface for customers to pay.
 * @author SteamedChicken
 */
public class PayView extends JFrame
{
    private JButton payButton;
    private JButton printReceiptButton;
    private JButton backButton;
    private JButton doneButton;
    private JComboBox payMethodComboBox;
    
    /**
     * Initializes the frame layout and components.
     */
    public PayView()
    {
        final int FRAME_HEIGHT = 700;
        final int FRAME_WIDTH = 700;
        
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLayout(new BorderLayout());
        
        JPanel paymentPanel = this.initializePaymentPanel();
        
        JPanel navigationPanel = this.initializeNavigationPanel();
        
        this.add(paymentPanel, BorderLayout.NORTH);
        this.add(navigationPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    private JPanel initializePaymentPanel()
    {
        final String creditCardOptionText = "Credit card";
        final String debitCardOptionText = "Debit card";
        final String payButtonText = "Pay";
        
        JPanel paymentPanel = new JPanel();
    	String[] payOptions = {creditCardOptionText, debitCardOptionText};    	
    	payButton = new JButton(payButtonText);
    	paymentPanel.setLayout(new FlowLayout());
    	
    	payMethodComboBox = new JComboBox(payOptions);   	
    	
    	paymentPanel.add(payMethodComboBox);
    	paymentPanel.add(payButton);
    	return paymentPanel;
    }
    
    private JPanel initializeNavigationPanel()
    {
        final String cancelButtonText = "Back";
        
        JPanel navigationPanel = new JPanel();
    	navigationPanel.setLayout(new FlowLayout());
    	
    	backButton = new JButton(cancelButtonText);
    	
    	navigationPanel.add(backButton);
    	
    	return navigationPanel;
    }
    
    /**
     * Shows the print receipt and done buttons after the customer has payed.
     */
    public void initCustomerPayed()
    {
        final String printReceiptButtonText = "Print receipt";
        final String doneButtonText = "Done";
        
        JPanel finishPanel = new JPanel();
        finishPanel.setLayout(new FlowLayout());
        
        printReceiptButton = new JButton(printReceiptButtonText);
        doneButton = new JButton(doneButtonText);
        
        finishPanel.add(printReceiptButton);
        finishPanel.add(doneButton);
        
        this.add(finishPanel, BorderLayout.CENTER);
        
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
     * Returns the selected pay option in the pay combobox.
     * @return the selected pay option in the pay combobox
     */
    public String getPayOption()
    {
        return (String) payMethodComboBox.getItemAt(payMethodComboBox.getSelectedIndex());
    }
    
    /**
     * Adds a listener for the back button.
     * @param listenForBackButton listener for the back button
     */
    public void addBackButtonListener(ActionListener listenForBackButton)
    {
        backButton.addActionListener(listenForBackButton);
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
     * Adds a listener for the print receipt button.
     * @param listenForPrintReceiptButton listener for the print receipt button
     */
    public void addPrintReceiptButtonListener(ActionListener listenForPrintReceiptButton)
    {
        printReceiptButton.addActionListener(listenForPrintReceiptButton);    
    }
    
    /**
     * Adds a listener for the done button.
     * @param listenForDoneButton listener for the done button
     */
    public void addDoneButtonListener(ActionListener listenForDoneButton)
    {
        doneButton.addActionListener(listenForDoneButton);
    }
}