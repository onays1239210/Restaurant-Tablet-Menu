
package steamedchicken;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * A class to run the Steamed Chicken restaurant ordering application.
 *
 * @author Steamed Chicken
 */
public class SteamedChicken
{
    /**
     * Sets the Nimbus look and feel.
     */
    private void setLookAndFeel()
    {
        try
        {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Order order = new Order();

        // each item amount starts at 0
        MenuView menuView = new MenuView(0, 0, 0, 0, 0, 0, 0, 0);
        MenuController menuController = new MenuController(menuView, order);
    }
}
